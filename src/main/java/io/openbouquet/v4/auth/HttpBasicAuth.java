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
package io.openbouquet.v4.auth;

import java.util.List;
import java.util.Map;

import io.openbouquet.v4.Pair;

public class HttpBasicAuth implements Authentication {
	private String username;
	private String password;
	private String customerId;
	private String clientId;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	@Override
	public void applyToParams(List<Pair> queryParams, Map<String, String> headerParams) {
		if (username == null && password == null) {
			return;
		}
		if (getCustomerId() != null) {
			queryParams.add(new Pair("customerId", getCustomerId()));
		}
		queryParams.add(new Pair("client_id", getClientId()));
		queryParams.add(new Pair("login", getUsername()));
		queryParams.add(new Pair("password", getPassword()));
		queryParams.add(new Pair("response_type", "token"));
		headerParams.put("Content-Type","application/x-www-form-urlencoded");
	}

}
