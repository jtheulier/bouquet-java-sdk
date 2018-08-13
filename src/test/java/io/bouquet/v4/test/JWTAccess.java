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
// https://pqbi.prod.proquest.com/release/v4.2 {\"customerId\":\"555dcdca2cdcd184b46114a7\",\"clientId\":\"counter\",\"userId\":\"57d2c209de3e1a6b6d4612e2\",\"privateKey\":\"MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQChpXy+d533FIYdU\\n8QicANRpwHpLOTaum0E9dBrq0py4oLUmNTbAdcA4KR4pcvpP7FwD61Hk1s74NwFds\\nVmBeeI0vXk6zsCdsxskk7l1Dqi+OVMXUbUoCO9V8ZjGpMjuBUbkSjI1nh7ocZ3hrT\\nIWqC9nDBiBmsZzOxMfnbCB5z/sMdNXhso6JqDSeXqDn4eWAZtYgBiQt3mtUIhRotn\\n+Z9lxAYAZwbQCpOmkxEDsSkkLx4qoU/FrDhsuRWpN3f+AfMRt7mg3yxwGj2ms/rEf\\nx/u2BNlg+2iSAsfil4LU3BYExwxufGX3Ch9Wkd6YOF7iuVr0UOZr7XVnJG97fYc0L\\n35AgMBAAECggEAVUJbDH89E2CA6KERF3TrWzryWBG01+VysSYSe2fKidQNW6MMykM\\nrKyxRs80HQ4yzwz6Rj+oaOff9NOiTb593owRabBbidgdBBZcaBEEveFw9XUzpmiap\\nEypj2kvfBf0HLRYgY+YzgEowy0SCwBaFJ91k658lCGO80w/1BZxMY9P4rnqTKiHFI\\nplAJNk62WPbp5q2x0/KCwFQNHxsI6uVosSMEAmLaSMs1+LioNMjCkUQiS6PSYfcd6\\nYp8DS+18cJfcr1nn+7nyyJAA3+CD4GD6uBo37Oien1uM+ZPg/ED+eWFhoXXfjYWiL\\nBU+XLl6UzDPndy5zrEJ23BpOmSWYqgQKBgQD1rIhWj2k17XmH1hgDu05rrl4WmaFl\\nBeqzxBW4PFk5NsabuCZuI3qEi4Xw7+B5aJcRAcDYX/Kmh0zjTgZJbB7L3r3nLecc3\\n0vlM1+kyrMRkWi0dKulLmyeJIA6FQbf68WA/GA2cwUAjWGnLD8biG1rlXrwkEfwn9\\n5jveZFs2W4yQKBgQCocNAvwgIoM733OVhVpiMf+ZnGvSALPhh6wTII6hYZVlYM4ct\\nlA0gUxU7Ed+4S+AwvVCYZxW4puI2QOS3bNmctHiHewwCEd/VDI6vq3qs5Nd5UzzvJ\\n3Y7WJW28FuCqpHUUcCFABxMVC4kCIeVBhXjjqLH5YnpzT7tacNi8ljSjsQKBgQCO8\\nGKnEmvhn5kNSqjQSwPWrS47MgnwkF+9VkJY3mv/WPp3kc5yWJwpUFCPHdJacVsr3v\\nxIKJMzBxfaTQRlZc4JSkDtqAyHBPjQk3J7nCBSAWuNSzCvO/KglJYytRc546EXaj/\\nEjmmDp78AmELjjx4y8VcFbr0cqLepCs1XEokF2QKBgHg9Z+/fn2iRXxcfIXaqjUJj\\nDCn5kelUn2bpiM0iRTo7DlxNxsLJ7+eb3ZmUPyfdV91lRXl6HSS9MJj2qExm7oofi\\n3AYZcMqWrNdwHh+EV5anOaPtI9qkG8/8rCk6CYIFefMD4BETJPmUxxpk90M6XoiT0\\nHF0cGE9ioeiik9VEBRAoGAVwW475ufEpkccnSKW/CuWM6Iyf/hz4d5Nk6rls2gnvb\\nAkipQzNuApSB7aobFjigs4mR7k//sRnfLdddFo627fiVtxEYCVNLeNcizttpVTdyf\\noWpWv2aOoauQJhnYkdRMuO1Q7cARpGpItNT7tFeGqz91vt4QK4hyDi7EM/QlAfI=\"}
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
			JWTConfiguration.fromJson(args[1]);
			JWTAccess test = new JWTAccess();
			System.out.println(test.md5("288934af-7f1e-4d49-989d-f9a935489097", "=hA8HapH+pug"));
			//test.getAccessToken(args[0], configuration);
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


	public String md5(String salt, String input) {
		String md5 = null;
		if (null == input) {
			return null;
		}
		if (salt == null) {
			return input;
		} else {
			input += salt;
		}
		// digest
		try {
			// Create MessageDigest object for MD5
			MessageDigest digest = MessageDigest.getInstance("MD5");

			// Update input string in message digest
			digest.update(input.getBytes(), 0, input.length());

			// Converts message digest value in base 16 (hex)
			md5 = new BigInteger(1, digest.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		return md5;
	}



}
