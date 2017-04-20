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
package io.openbouquet.v4.test;

import java.util.List;

import io.openbouquet.v4.ApiClient;
import io.openbouquet.v4.api.ModelApi;
import io.openbouquet.v4.client.JWTConfiguration;
import io.openbouquet.v4.model.User;

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
			test.run(args[0], configuration);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Test case run
	 * @param basePath base URL of the Bouquet server (ending with /v4.2)
	 * @param configuration JWT object containing the key, user to login with & client
	 * @throws Exception when an error occurs
	 */
	public void run(String basePath, JWTConfiguration configuration) throws Exception {

		ApiClient apiClient = new ApiClient();
		apiClient.setBasePath(basePath);
		ModelApi api = new ModelApi(apiClient, configuration);

		List<User> users = api.getUsers();
		for (User user : users) {
			System.out.println(user.toString());
		}
	}

}
