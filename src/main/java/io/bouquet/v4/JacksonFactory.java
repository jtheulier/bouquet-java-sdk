/*******************************************************************************
 * Copyright 2017 julien@squidsolutions.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package io.bouquet.v4;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.time.format.DateTimeParseException;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.squid.kraken.v4.model.ChosenMetric;
import com.squid.kraken.v4.model.Expression;

import io.bouquet.v4.ApiException.ApiError;

public class JacksonFactory extends GsonFactory implements JsonFactory {
	ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * JSON constructor.
	 *
	 * @param apiClient
	 *            An instance of ApiClient
	 */
	public JacksonFactory(ApiClient apiClient) {

		super(apiClient);

		objectMapper.setSerializationInclusion(Include.NON_NULL);
		//
		JsonSerializer<ChosenMetric> chosenMetricSerializer = new JsonSerializer<ChosenMetric>() {

			@Override
			public void serialize(ChosenMetric src, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
				if (src.getId() != null) {
					jgen.writeString(src.getId());
				} else {
					jgen.writeString(objectMapper.writeValueAsString(src.getExpression()));
				}

			}

		};
		//
		JsonDeserializer<ChosenMetric> chosenMetricDeserializer = new JsonDeserializer<ChosenMetric>() {

			@Override
			public ChosenMetric deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
				JsonNode metricNode = jp.readValueAsTree();
				if (metricNode.isObject()) {
					String id = (metricNode.get("id") != null) ? metricNode.get("id").asText() : null;
					String name = (metricNode.get("name") != null) ? metricNode.get("name").asText() : null;
					String expression = (metricNode.get("expression") != null) ? metricNode.get("expression").toString() : null;
					return new ChosenMetric(id, name, objectMapper.readValue(expression, Expression.class));

				} else {
					return new ChosenMetric(metricNode.toString());
				}
			}

		};

		//
		SimpleModule module = new SimpleModule();
		module.addSerializer(LocalDate.class, new LocalDateTypeSerializer());
		module.addDeserializer(LocalDate.class, new LocalDateTypeDeserializer());
		module.addSerializer(DateTime.class, new DateTimeTypeSerializer());
		module.addDeserializer(DateTime.class, new DateTimeTypeDeserializer());
		module.addSerializer(Date.class, new DateTypeSerializer(apiClient));
		module.addDeserializer(Date.class, new DateTypeDeserializer(apiClient));
		module.addDeserializer(ApiException.class, new ApiExceptionDeserializer());
		module.addSerializer(ChosenMetric.class, chosenMetricSerializer);
		module.addDeserializer(ChosenMetric.class, chosenMetricDeserializer);
		objectMapper.registerModule(module);
	}

	/**
	 * Serialize the given Java object into JSON string.
	 *
	 * @param obj
	 *            Object
	 * @return String representation of the JSON
	 */
	public String serialize(Object obj) {
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Deserialize the given JSON string to Java object.
	 *
	 * @param <T>
	 *            Type
	 * @param body
	 *            The JSON string
	 * @param returnType
	 *            The type to deserialize inot
	 * @return The deserialized Java object
	 * @throws ApiException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public <T> T deserialize(String body, Type returnType) throws ApiException {
		try {
			JavaType javaType = objectMapper.getTypeFactory().constructType(returnType);
			if (returnType instanceof ParameterizedType) {
				Type[] types = ((ParameterizedType) returnType).getActualTypeArguments();
				Type type = ((ParameterizedType) returnType).getRawType();
				javaType = objectMapper.getTypeFactory().constructParametricType((Class<?>) type, (Class<?>) types[0]);
			}

			if (getClient().isLenientOnJson()) {
				return (T) objectMapper.readValue(new StringReader(body), javaType);
			} else {
				return (T) objectMapper.readValue(body, javaType);
			}
		} catch (JsonParseException | JsonMappingException e) {
			// Fallback processing when failed to parse JSON form response body:
			// return the response body string directly for the String return
			// type;
			// parse response body into date or datetime for the Date return
			// type.
			if (returnType.equals(String.class))
				return (T) body;
			else if (returnType.equals(Date.class))
				return (T) getClient().parseDateOrDatetime(body);
			else if (body != null && body.indexOf("apiError") != -1) {
				try {
					throw objectMapper.readValue(body, ApiException.class);
				} catch (IOException e1) {
					System.out.println(body);
					e.printStackTrace();
				}
			}
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}

/**
 * Jackson Adapter for java Util Date type
 */
class DateTypeSerializer extends JsonSerializer<Date> {
	private final ApiClient apiClient;

	static final DateTimeFormatter formatter = ISODateTimeFormat.date();

	public DateTypeSerializer(ApiClient apiClient) {
		this.apiClient = apiClient;
	}

	@Override
	public void serialize(Date date, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException {
		String value = apiClient.formatDatetime(date);
		jgen.writeString(value);
	}
}

class DateTypeDeserializer extends JsonDeserializer<Date> {
	private final ApiClient apiClient;

	/**
	 * Constructor for DateAdapter
	 *
	 * @param getClient()
	 *            Api client
	 */
	public DateTypeDeserializer(ApiClient apiClient) {
		super();
		this.apiClient = apiClient;
	}

	@Override
	public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		String date = jp.getText();
		return apiClient.parseDateOrDatetime(date);
	}
}

/**
 * Jackson Adapter for Joda DateTime type
 */
class DateTimeTypeSerializer extends JsonSerializer<DateTime> {

	static final DateTimeFormatter formatter = ISODateTimeFormat.date();

	@Override
	public void serialize(DateTime date, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException {
		try {
			String s = formatter.print(date);
			jgen.writeString(s);
		} catch (DateTimeParseException e) {
			System.err.println(e);
			jgen.writeString((String) null);
		}
	}
}

class DateTimeTypeDeserializer extends JsonDeserializer<DateTime> {

	static final DateTimeFormatter formatter = ISODateTimeFormat.date();

	@Override
	public DateTime deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		String date = jp.getText();
		if (date == null) {
			return null;
		} else {
			return formatter.parseDateTime(date);

		}
	}
}

/**
 * Jackson Adapter for Joda LocalDate type
 */
class LocalDateTypeSerializer extends JsonSerializer<LocalDate> {

	static final DateTimeFormatter formatter = ISODateTimeFormat.date();

	@Override
	public void serialize(LocalDate date, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException {
		try {
			String s = formatter.print(date);
			jgen.writeString(s);
		} catch (DateTimeParseException e) {
			System.err.println(e);
			jgen.writeString((String) null);
		}
	}
}

class LocalDateTypeDeserializer extends JsonDeserializer<LocalDate> {

	static final DateTimeFormatter formatter = ISODateTimeFormat.date();

	@Override
	public LocalDate deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		String date = jp.getText();
		if (date == null) {
			return null;
		} else {
			return formatter.parseLocalDate(date);

		}
	}
}

class ApiExceptionDeserializer extends JsonDeserializer<ApiException> {

	@Override
	public ApiException deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		JsonNode studyNode = jp.readValueAsTree();
		JsonNode node = studyNode.get("error");
		String message = null;
		if (node != null) {
			message = studyNode.get("error").asText();
		}
		int code = studyNode.get("code").asInt();
		ApiException ae = new ApiException(code, message);
		node = studyNode.get("redirectURL");
		if (node != null) {
			ae.setRedirectURL(node.asText());
		}
		node = studyNode.get("clientId");
		if (node != null) {
			ae.setClientId(node.asText());
		}
		node = studyNode.get("type");
		if (node != null) {
			ae.setType(node.asText());
		}
		node = studyNode.get("apiError");
		if (node != null) {
			ae.setApiError(ApiError.valueOf(node.asText()));
		}

		return ae;

	}

}
