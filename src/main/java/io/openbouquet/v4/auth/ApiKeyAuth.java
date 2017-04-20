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

public class ApiKeyAuth implements Authentication {
	private String jwt;
	private String clientId;


	public String getJwt() {
		return jwt;
	}

	public String getClientId() {
		return clientId;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	@Override
	public void applyToParams(List<Pair> queryParams, Map<String, String> headerParams) {
		queryParams.add(new Pair("assertion", getJwt()));
		queryParams.add(new Pair("client_id",  getClientId()));
		headerParams.put("Content-Type","application/x-www-form-urlencoded");
	}

}
