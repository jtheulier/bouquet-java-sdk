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
import java.lang.reflect.Type;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.squid.kraken.v4.model.APICredentials;
import com.squid.kraken.v4.model.ChosenMetric;
import com.squid.kraken.v4.model.Col;
import com.squid.kraken.v4.model.Col.OriginType;
import com.squid.kraken.v4.model.Col.Role;
import com.squid.kraken.v4.model.Credentials;
import com.squid.kraken.v4.model.DBMSCredentials;
import com.squid.kraken.v4.model.DimensionPK;
import com.squid.kraken.v4.model.Expression;
import com.squid.kraken.v4.model.ExtendedType;
import com.squid.kraken.v4.model.FacetMember;
import com.squid.kraken.v4.model.FacetMemberInterval;
import com.squid.kraken.v4.model.FacetMemberString;
import com.squid.kraken.v4.model.MetricPK;
import com.squid.kraken.v4.model.Oauth2RefreshCredentials;

public class GsonFactory implements JsonFactory {
	private ApiClient apiClient;
	private Gson gson;

	/**
	 * JSON constructor.
	 *
	 * @param getClient() An instance of ApiClient
	 */
	public GsonFactory(ApiClient apiClient) {
		this.apiClient = apiClient;
		JsonDeserializer<ChosenMetric> chosenMetricDeserializer = new JsonDeserializer<ChosenMetric>() {
			@Override
			public ChosenMetric deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
				if (json.isJsonObject()) {
					JsonObject jsonObject = json.getAsJsonObject();
					Expression expression = gson.fromJson(jsonObject, Expression.class);
					return new ChosenMetric(expression);
				} else {
					return new ChosenMetric(json.getAsString());
				}
			}
		};
		JsonSerializer<ChosenMetric> chosenMetricSerializer = new JsonSerializer<ChosenMetric>() {

			@Override
			public JsonElement serialize(ChosenMetric src, Type typeOfSrc, JsonSerializationContext context) {
				if (src.getId() != null) {
					return new JsonPrimitive(src.getId());
				} else {
					return context.serialize(src.getExpression(), Expression.class);
				}
			}

		};
		JsonDeserializer<FacetMember> facetMemberDeserializer = new JsonDeserializer<FacetMember>() {
			@Override
			public FacetMember deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
				if (json.isJsonObject()) {
					JsonObject jsonObject = json.getAsJsonObject();
					if (jsonObject != null) {
						if ("i".equals(jsonObject.get("type").getAsString())) {
							return gson.fromJson(jsonObject, FacetMemberInterval.class);
						} else if ("v".equals(jsonObject.get("type").getAsString())) {
							return gson.fromJson(jsonObject, FacetMemberString.class);
						} else {
							// throw new ApiException("Invalid facet type");
							return null;
						}
					}
					// throw new ApiException("Invalid facet type");
					return null;

				} else {
					// throw new ApiException("Invalid facet type");
					return null;

				}
			}
		};
		JsonSerializer<FacetMember> facetMemberSerializer = new JsonSerializer<FacetMember>() {

			@Override
			public JsonElement serialize(FacetMember src, Type typeOfSrc, JsonSerializationContext context) {
				if (src instanceof FacetMemberInterval) {
					return context.serialize(src, FacetMemberInterval.class);
				} else if (src instanceof FacetMemberString) {
					return context.serialize(src, FacetMemberString.class);
				} else {
					return null;
				}
			}

		};

		JsonDeserializer<Credentials> credentialsDeserializer = new JsonDeserializer<Credentials>() {
			@Override
			public Credentials deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
				if (json.isJsonObject()) {
					JsonObject jsonObject = json.getAsJsonObject();
					if (jsonObject != null) {
						if ("API".equals(jsonObject.get("type").getAsString())) {
							return gson.fromJson(jsonObject, APICredentials.class);
						} else if ("DBMS".equals(jsonObject.get("type").getAsString())) {
							return gson.fromJson(jsonObject, DBMSCredentials.class);
						} else if ("REFRESH".equals(jsonObject.get("type").getAsString())) {
							return gson.fromJson(jsonObject, Oauth2RefreshCredentials.class);
						} else {
							// throw new ApiException("Invalid facet type");
							return null;
						}
					}
					// throw new ApiException("Invalid facet type");
					return null;

				} else {
					// throw new ApiException("Invalid facet type");
					return null;

				}
			}
		};

		JsonSerializer<Credentials> credentialsSerializer = new JsonSerializer<Credentials>() {

			@Override
			public JsonElement serialize(Credentials src, Type typeOfSrc, JsonSerializationContext context) {
				if (src instanceof APICredentials) {
					return context.serialize(src, APICredentials.class);
				} else if (src instanceof DBMSCredentials) {
					return context.serialize(src, DBMSCredentials.class);
				} else if (src instanceof Oauth2RefreshCredentials) {
					return context.serialize(src, Oauth2RefreshCredentials.class);
				} else {
					return null;
				}
			}

		};

		JsonDeserializer<Col> colSerializer = new JsonDeserializer<Col>() {
			@Override
			public Col deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
				if (json.isJsonObject()) {
					JsonObject jsonObject = json.getAsJsonObject();
					Col col = new Col();
					if (jsonObject.get("id") != null && jsonObject.get("id").isJsonNull() == false) {
						col.setId(jsonObject.get("id").getAsString());
					}
					if (jsonObject.get("name") != null && jsonObject.get("name").isJsonNull() == false) {
						col.setName(jsonObject.get("name").getAsString());
					}
					if (jsonObject.get("definiti") != null && jsonObject.get("definiti").isJsonNull() == false) {
						col.setDefinition(jsonObject.get("definition").getAsString());
					}
					if (jsonObject.get("extendedType") != null && jsonObject.get("extendedType").isJsonNull() == false) {
						col.setExtendedType(gson.fromJson(jsonObject.get("extendedType"), ExtendedType.class));
					}
					if (jsonObject.get("originType") != null && jsonObject.get("originType").isJsonNull() == false) {
						col.setOriginType(OriginType.valueOf(jsonObject.get("originType").getAsString()));
					}
					if (jsonObject.get("description") != null && jsonObject.get("description").isJsonNull() == false) {
						col.setDescription(jsonObject.get("description").getAsString());
					}
					if (jsonObject.get("format") != null && jsonObject.get("format").isJsonNull() == false) {
						col.setFormat(jsonObject.get("format").getAsString());
					}
					if (jsonObject.get("pos") != null && jsonObject.get("pos").isJsonNull() == false) {
						col.setPos(jsonObject.get("pos").getAsInt());
					}
					if (jsonObject.get("lname") != null && jsonObject.get("lname").isJsonNull() == false) {
						col.setLname(jsonObject.get("lname").getAsString());
					}
					if (jsonObject.get("role") != null && jsonObject.get("role").isJsonNull() == false) {
						col.setRole(Role.valueOf(jsonObject.get("role").getAsString()));
					}
					if (col.getRole() != null && jsonObject.get("pk") != null && jsonObject.get("pk").isJsonNull() == false) {
						if (Role.DOMAIN == col.getRole()) {
							col.setPk(gson.fromJson(jsonObject.get("pk"), DimensionPK.class));
						} else if (Role.DATA == col.getRole()) {
							col.setPk(gson.fromJson(jsonObject.get("pk"), MetricPK.class));
						}
					}
					return col;

				} else {
					return null;
				}
			}
		};

		gson = new GsonBuilder().registerTypeAdapter(Date.class, new DateAdapter(apiClient)).registerTypeAdapter(DateTime.class, new DateTimeTypeAdapter()).registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter()).registerTypeAdapter(FacetMember.class, facetMemberDeserializer)
				.registerTypeAdapter(FacetMember.class, facetMemberSerializer).registerTypeAdapter(ChosenMetric.class, chosenMetricDeserializer).registerTypeAdapter(ChosenMetric.class, chosenMetricSerializer).registerTypeAdapter(Credentials.class, credentialsDeserializer)
				.registerTypeAdapter(ChosenMetric.class, credentialsSerializer).registerTypeAdapter(Col.class, colSerializer).create();
	}

	/**
	 * Serialize the given Java object into JSON string.
	 *
	 * @param obj Object
	 * @return String representation of the JSON
	 */
	public String serialize(Object obj) {
		return gson.toJson(obj);
	}

	/**
	 * Deserialize the given JSON string to Java object.
	 *
	 * @param            <T> Type
	 * @param body       The JSON string
	 * @param returnType The type to deserialize inot
	 * @return The deserialized Java object
	 */
	@SuppressWarnings("unchecked")
	public <T> T deserialize(String body, Type returnType) throws ApiException {
		try {
			if (getClient().isLenientOnJson()) {
				JsonReader jsonReader = new JsonReader(new StringReader(body));
				// see
				// https://google-gson.googlecode.com/svn/trunk/gson/docs/javadocs/com/google/gson/stream/JsonReader.html#setLenient(boolean)
				jsonReader.setLenient(true);
				return gson.fromJson(jsonReader, returnType);
			} else {
				return gson.fromJson(body, returnType);
			}
		} catch (JsonParseException e) {
			// Fallback processing when failed to parse JSON form response body:
			// return the response body string directly for the String return
			// type;
			// parse response body into date or datetime for the Date return
			// type.
			if (returnType.equals(String.class))
				return (T) body;
			else if (returnType.equals(Date.class))
				return (T) getClient().parseDateOrDatetime(body);
			else
				throw (e);
		} catch (Exception e) {
			throw e;
		}
	}

	public ApiClient getClient() {
		return apiClient;
	}

}

/**
 * Gson Adapter for Util Date type
 */
class DateAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {
	private final ApiClient apiClient;

	/**
	 * Constructor for DateAdapter
	 *
	 * @param getClient() Api client
	 */
	public DateAdapter(ApiClient apiClient) {
		super();
		this.apiClient = apiClient;
	}

	/**
	 * Serialize
	 *
	 * @param src       Date
	 * @param typeOfSrc Type
	 * @param context   Json Serialization Context
	 * @return Json Element
	 */
	@Override
	public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context) {
		if (src == null) {
			return JsonNull.INSTANCE;
		} else {
			return new JsonPrimitive(apiClient.formatDatetime(src));
		}
	}

	/**
	 * Deserialize
	 *
	 * @param json      Json element
	 * @param date      Type
	 * @param typeOfSrc Type
	 * @param context   Json Serialization Context
	 * @return Date
	 * @throw JsonParseException if fail to parse
	 */
	@Override
	public Date deserialize(JsonElement json, Type date, JsonDeserializationContext context) throws JsonParseException {
		String str = json.getAsJsonPrimitive().getAsString();
		try {
			return apiClient.parseDateOrDatetime(str);
		} catch (RuntimeException e) {
			throw new JsonParseException(e);
		}
	}
}

/**
 * Gson Adapter for Joda DateTime type
 */
class DateTimeTypeAdapter extends TypeAdapter<DateTime> {

	private final DateTimeFormatter formatter = ISODateTimeFormat.dateTime();

	@Override
	public void write(JsonWriter out, DateTime date) throws IOException {
		if (date == null) {
			out.nullValue();
		} else {
			out.value(formatter.print(date));
		}
	}

	@Override
	public DateTime read(JsonReader in) throws IOException {
		switch (in.peek()) {
		case NULL:
			in.nextNull();
			return null;
		default:
			String date = in.nextString();
			return formatter.parseDateTime(date);
		}
	}
}

/**
 * Gson Adapter for Joda LocalDate type
 */
class LocalDateTypeAdapter extends TypeAdapter<LocalDate> {

	private final DateTimeFormatter formatter = ISODateTimeFormat.date();

	@Override
	public void write(JsonWriter out, LocalDate date) throws IOException {
		if (date == null) {
			out.nullValue();
		} else {
			out.value(formatter.print(date));
		}
	}

	@Override
	public LocalDate read(JsonReader in) throws IOException {
		switch (in.peek()) {
		case NULL:
			in.nextNull();
			return null;
		default:
			String date = in.nextString();
			return formatter.parseLocalDate(date);
		}
	}
}

/**
 * Gson Adapter for Joda LocalDate type
 */
class ApiExceptionTypeAdapter extends TypeAdapter<ApiException> {
	@Override
	public void write(JsonWriter out, ApiException exception) throws IOException {
		;
	}

	@Override
	public ApiException read(JsonReader in) throws IOException {
		in.beginObject();
		String message = null;
		int code = 0;
		String redirectURL = null;
		String clientId = null;
		String type = null;
		while (in.hasNext()) {
			switch (in.nextName()) {
			case "code":
				code = in.nextInt();
				break;
			case "type":
				type = in.nextString();
			case "error":
				message = in.nextString();
			case "redirectURL":
				redirectURL = in.nextString();
			case "clientId":
				clientId = in.nextString();
			}
		}
		ApiException ae = new ApiException(code, message);
		ae.setType(type);
		ae.setRedirectURL(redirectURL);
		ae.setClientId(clientId);
		return ae;
	}
}
