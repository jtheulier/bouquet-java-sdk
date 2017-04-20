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

import java.security.PrivateKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.auth0.jwt.Algorithm;
import com.auth0.jwt.JWTSigner;

import io.openbouquet.v4.Pair;

public class JWTAuth implements Authentication {
	private String clientId;
	private String customerId;
	private String userId;
	private PrivateKey privateKey;

	@Override
	public void applyToParams(List<Pair> queryParams, Map<String, String> headerParams) {
		final String issuer = getClientId();
		final long iat = System.currentTimeMillis() / 1000L; // issued at claim
		final int exp =  60 * 30; // expires claim. In this case the token  expires in 30 minutes
		final JWTSigner signer = new JWTSigner(getPrivateKey());
		final HashMap<String, Object> claims = new HashMap<String, Object>();
		claims.put("iss", issuer);
		claims.put("iat", iat);
		if (getCustomerId() != null) {
			claims.put("customerId", getCustomerId());
		}
		claims.put("sub", getUserId());

		JWTSigner.Options opts = new JWTSigner.Options();
		opts.setAlgorithm(Algorithm.RS256);
		opts.setExpirySeconds(exp);
		opts.setIssuedAt(false);
		final String jwt = signer.sign(claims, opts);
		queryParams.add(new Pair("grant_type", "sso"));
		queryParams.add(new Pair("clientId", issuer));
		queryParams.add(new Pair("assertion", jwt));
		headerParams.put("Content-Type","application/x-www-form-urlencoded");
	}

	public String getClientId() {
		return clientId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public String getUserId() {
		return userId;
	}

	public PrivateKey getPrivateKey() {
		return privateKey;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


	public void setPrivateKey(PrivateKey privateKey) {
		this.privateKey = privateKey;
	}
}
