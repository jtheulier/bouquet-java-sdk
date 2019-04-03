/*******************************************************************************
 * Copyright 2017 julien@squidsolutions.com
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package io.bouquet.v4.api;

import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Call;
import com.squid.kraken.v4.model.AccessToken;
import io.bouquet.v4.ApiClient;
import io.bouquet.v4.ApiException;
import io.bouquet.v4.ApiResponse;
import io.bouquet.v4.Pair;
import io.bouquet.v4.client.JWTConfiguration;
import io.bouquet.v4.client.LoginConfiguration;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseApi {

  private ApiClient apiClient;

  public BaseApi(ApiClient apiClient, LoginConfiguration configuration) throws ApiException {
    this.apiClient = apiClient;
    AccessToken accesstoken;
    accesstoken = getAccessTokenWithLogin(configuration);
    apiClient.setAccessToken(accesstoken.getId().getTokenId());
  }

  public BaseApi(ApiClient apiClient, JWTConfiguration configuration) throws ApiException {
    this.apiClient = apiClient;
    AccessToken accesstoken;
    accesstoken = getAccessTokenWithJWT(configuration);
    apiClient.setAccessToken(accesstoken.getId().getTokenId());
  }

  public BaseApi(ApiClient apiClient, String clientId, String assertion) throws ApiException {
    this.apiClient = apiClient;
    AccessToken accesstoken;
    accesstoken = getAccessTokenWitApiKey(assertion, clientId);
    apiClient.setAccessToken(accesstoken.getId().getTokenId());
  }

  public BaseApi(ApiClient apiClient, String accessToken) throws ApiException {
    this.apiClient = apiClient;
    apiClient.setAccessToken(accessToken);
  }

  private AccessToken getAccessTokenWithJWT(JWTConfiguration configuration) throws ApiException {
    if (configuration.getClientId() == null) {
      throw new ApiException(400, "Missing the required parameter 'clientId' when calling getSSOToken");
    }
    if (configuration.getUserId() == null) {
      throw new ApiException(400, "Missing the required parameter 'login' when calling getSSOToken");
    }

    this.apiClient.setJWTKey(configuration);

    Object localVarPostBody = null;

    // create path and map variables
    String localVarPath = "/rs/token";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    String[] localVarAuthNames = new String[] {"jwt_auth"};

    Type localVarReturnType = new TypeToken<AccessToken>() {}.getType();

    Call call = apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams,
        localVarFormParams, localVarAuthNames, null);
    ApiResponse<AccessToken> resp = apiClient.execute(call, localVarReturnType);
    return resp.getData();
  }

  private AccessToken getAccessTokenWitApiKey(String jwt, String clientId) throws ApiException {
    if (clientId == null) {
      throw new ApiException(400, "Missing the required parameter 'clientId' when calling getAccessTokenWitApiKey");
    }
    if (jwt == null) {
      throw new ApiException(400, "Missing the required parameter 'jwt' when calling getAccessTokenWitApiKey");
    }

    this.apiClient.setApiKey(jwt, clientId);;

    Object localVarPostBody = null;

    // create path and map variables
    String localVarPath = "/rs/token";

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    String[] localVarAuthNames = new String[] {"api_key_auth"};

    Type localVarReturnType = new TypeToken<AccessToken>() {}.getType();

    Call call = apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams,
        localVarFormParams, localVarAuthNames, null);
    ApiResponse<AccessToken> resp = apiClient.execute(call, localVarReturnType);
    return resp.getData();
  }

  private AccessToken getAccessTokenWithLogin(LoginConfiguration configuration) throws ApiException {
    if (configuration.getClientId() == null) {
      throw new ApiException(400, "Missing the required parameter 'clientId' when calling getAccessToken");
    }
    if (configuration.getLogin() == null) {
      throw new ApiException(400, "Missing the required parameter 'login' when calling getAccessToken");
    }
    if (configuration.getPassword() == null) {
      throw new ApiException(400, "Missing the required parameter 'password' when calling getAccessToken");
    }

    Object localVarPostBody = null;

    // create path and map variables
    String localVarPath = "/rs/auth-token";
    this.apiClient.setBasicAuth(configuration);

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    String[] localVarAuthNames = new String[] {"basic_auth"};

    Type localVarReturnType = new TypeToken<AccessToken>() {}.getType();

    Call call = apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams,
        localVarFormParams, localVarAuthNames, null);
    ApiResponse<AccessToken> resp = apiClient.execute(call, localVarReturnType);
    return resp.getData();
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }
}
