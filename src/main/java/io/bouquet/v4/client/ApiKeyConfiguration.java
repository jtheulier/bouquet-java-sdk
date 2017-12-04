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
package io.bouquet.v4.client;

import java.io.IOException;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JWT configuration used to request access token (OAuth) in order to use API belong this user
 * The configuration requires to know
 * - the customer (can be null if you want to decide on which customer to connect to later)
 * - the OpenBouquet Client id from which the JWT key will be validated
 * - The userId user's Id (Bouquet) on which an access token has to be created
 * - The JWT raw private key found in the Client object to be used (without header & footer)
 * @author jtheulier
 *
 */

public class ApiKeyConfiguration implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 6318591534411668339L;

	private final String clientId;
	private final String assertion;

	/**
	 *
	 * @param url Base URL of the server API (ex: http://mybouquetserverhost/v4.2
	 * @param customerId Customer identifier to connect to
	 * @param clientId Client identifier
	 * @param assertion JWT private key (stored in the client object referenced above)
	 * @param login login of the user which will be used to get an access token
	 * @param customerId customerId defined with the Bouquet server
	 */
	public ApiKeyConfiguration(@JsonProperty("basePath") String basePath, @JsonProperty("clientId") String clientId
			, @JsonProperty("customerId") String assertion) {
		super();
		this.clientId = clientId;
		this.assertion = assertion;

	}

	public String getClientId() {
		return clientId;
	}

	public String getRedirectUrl() {
		return null;
	}

	public String getAccessType() {
		return "sso";
	}

	public String getAssertion() {
		return assertion;
	}

	public String toJson() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static ApiKeyConfiguration fromJson(String json) {
		ObjectMapper mapper = new ObjectMapper();

		ApiKeyConfiguration client = null;
		try {
			client = mapper.readValue(json, ApiKeyConfiguration.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return client;
	}
}
