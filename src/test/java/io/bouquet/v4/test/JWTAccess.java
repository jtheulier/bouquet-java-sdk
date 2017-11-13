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
package io.bouquet.v4.test;

import io.bouquet.v4.ApiClient;
import io.bouquet.v4.api.ModelApi;
import io.bouquet.v4.auth.OAuth;
import io.bouquet.v4.client.JWTConfiguration;

/**
 * Test class to get an access token from a JWT key (found in a Client object)
 * This JWT allows to log using any user on Bouquet. Such access should be kept for specific cases such as complex batch integrations, SSO
 * @author jtheulier
 *
 */
public class JWTAccess {

	public JWTAccess() {
	}

	/**
	 * Provide the JWT configuration using a JSON String
	 * @param args command line arguments (server base path such as http://bouquehost/v4.2, JWT object as string)
	 */
	public static void main(String[] args) {
		try {
			JWTConfiguration configuration = JWTConfiguration.fromJson(args[1]);
			JWTAccess test = new JWTAccess();
			test.getAccessToken(args[0], configuration);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getAccessToken(String basePath, JWTConfiguration configuration) throws Exception {

		ApiClient apiClient = new ApiClient();
		apiClient.setBasePath(basePath);
		new ModelApi(apiClient, configuration);

		System.out.println(((OAuth) apiClient.getAuthentication("kraken_auth")).getAccessToken());
		return ((OAuth) apiClient.getAuthentication("kraken_auth")).getAccessToken();

	}

}
