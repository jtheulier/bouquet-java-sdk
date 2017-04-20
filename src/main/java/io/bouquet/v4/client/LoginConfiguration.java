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


public class LoginConfiguration implements Serializable {

	private static final long serialVersionUID = 6318591534411668339L;

	private final String customerId;
	private final String clientId;
	private final String login;
	private final String password;

	public LoginConfiguration(@JsonProperty("customerId") String customerId, @JsonProperty("clientId") String clientId, @JsonProperty("login") String login,
			@JsonProperty("password") String password) {
		super();
		this.customerId = customerId;
		this.clientId = clientId;
		this.login = login;
		this.password = password;
	}

	public String getCustomerId() {
		return customerId;
	}


	public String getClientId() {
		return clientId;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
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

	public static LoginConfiguration fromJson(String json) {
		ObjectMapper mapper = new ObjectMapper();

		LoginConfiguration client = null;
		try {
			client = mapper.readValue(json, LoginConfiguration.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return client;
	}

}
