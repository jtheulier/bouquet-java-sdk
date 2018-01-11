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
package io.bouquet.v4.api;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Call;

import io.bouquet.v4.ApiClient;
import io.bouquet.v4.ApiException;
import io.bouquet.v4.ApiResponse;
import io.bouquet.v4.Pair;
import io.bouquet.v4.ProgressRequestBody;
import io.bouquet.v4.ProgressResponseBody;
import io.bouquet.v4.client.JWTConfiguration;
import io.bouquet.v4.client.LoginConfiguration;
import io.bouquet.v4.model.AccessRight;
import io.bouquet.v4.model.AccessToken;
import io.bouquet.v4.model.ApiKey;
import io.bouquet.v4.model.Attribute;
import io.bouquet.v4.model.Bookmark;
import io.bouquet.v4.model.BookmarkPK;
import io.bouquet.v4.model.CacheInfo;
import io.bouquet.v4.model.Client;
import io.bouquet.v4.model.CustomerInfo;
import io.bouquet.v4.model.DataTable;
import io.bouquet.v4.model.DatabaseInfo;
import io.bouquet.v4.model.Dimension;
import io.bouquet.v4.model.DimensionOption;
import io.bouquet.v4.model.Domain;
import io.bouquet.v4.model.ExpressionSuggestion;
import io.bouquet.v4.model.Facet;
import io.bouquet.v4.model.FacetSelection;
import io.bouquet.v4.model.Metric;
import io.bouquet.v4.model.Project;
import io.bouquet.v4.model.ProjectAnalysisJob;
import io.bouquet.v4.model.ProjectFacetJob;
import io.bouquet.v4.model.Relation;
import io.bouquet.v4.model.State;
import io.bouquet.v4.model.User;
import io.bouquet.v4.model.UserGroup;

/**
 * Main client API class, provides all end points to manage clients, user & groups & projects
 * Handle authentication through JWT token.
 * To get a JWT private key, you have to generate a new Client. With this JWT private key you can connect to OpenBouquet server to request an access token for a given user
 * @author jtheulier
 *
 */

public class ModelApi extends BaseApi {

	public ModelApi(ApiClient apiClient, LoginConfiguration configuration) throws ApiException {
		super(apiClient, configuration);
	}

	public ModelApi(ApiClient  apiClient, JWTConfiguration configuration) throws ApiException {
		super(apiClient, configuration);
	}

	public ModelApi(ApiClient apiClient, String clientId, String assertion) throws ApiException {
		super(apiClient, clientId, assertion);
	}

	/**
	 * Get the public Customer information based on the Token passed in.
	 *
	 * @return CustomerInfo
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public CustomerInfo getCustomerInfo() throws ApiException {
		Object localVarPostBody = null;

		// create path and map variables
		String localVarPath = "/rs".replaceAll("\\{format\\}", "json");

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<CustomerInfo>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<CustomerInfo> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();
	}

	/**
	 * Get Database Status and vendor information
	 *
	 * @param projectId  (required)
	 * @return DatabaseInfo
	 * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
	 */
	public DatabaseInfo getDatabaseStatus(String projectId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException("Missing the required parameter 'projectId' when calling getDatabaseStatus(Async)");
		}


		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/database".replaceAll("\\{format\\}","json")
				.replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId.toString()));

		List<Pair> localVarQueryParams = new ArrayList<Pair>();

		Map<String, String> localVarHeaderParams = new HashMap<String, String>();

		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		final String[] localVarAccepts = {
				"application/json"
		};
		final String localVarAccept = getApiClient().selectHeaderAccept(localVarAccepts);
		if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

		final String[] localVarContentTypes = {

		};
		final String localVarContentType = getApiClient().selectHeaderContentType(localVarContentTypes);
		localVarHeaderParams.put("Content-Type", localVarContentType);

		if(progressListener != null) {
			getApiClient().getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
				@Override
				public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
					com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
					return originalResponse.newBuilder()
							.body(new ProgressResponseBody(originalResponse.body(), progressListener))
							.build();
				}
			});
		}

		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<DatabaseInfo>(){}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
		ApiResponse<DatabaseInfo> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();
	}


	/**
	 * Gets All ApiKeys
	 *
	 * @return List<InlineResponse200>
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public List<ApiKey> getApiKeys() throws ApiException {
		Object localVarPostBody = null;

		// create path and map variables
		String localVarPath = "/rs/apikeys".replaceAll("\\{format\\}", "json");

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<List<ApiKey>>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<List<ApiKey>> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Gets a ApiKey
	 *
	 * @param apiKeyId
	 * @return ApiKey
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public ApiKey getApiKey(String apiKeyId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'apiKeyId' is set
		if (apiKeyId == null) {
			throw new ApiException(400, "Missing the required parameter 'apiKeyId' when calling getApiKey");
		}

		// create path and map variables
		String localVarPath = "/rs/apikeys/{apiKeyId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "apiKeyId" + "\\}", getApiClient().escapeString(apiKeyId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<ApiKey>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<ApiKey> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Updates a ApiKey
	 *
	 * @param body the apiKey to update
	 * @return ApiKey
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public ApiKey updateApiKey(ApiKey body) throws ApiException {
		Object localVarPostBody = body;

		// verify the required parameter 'apiKeyId' is set
		if (body.getId().getApiKeyId() == null) {
			throw new ApiException(400, "Missing the required parameter 'apiKeyId' when calling updateApiKey");
		}

		// verify the required attribute oid us set as the id
		if (body.getId().getApiKeyId().equals(body.getOid()) == false) {
			throw new ApiException(400, "Object id differs from object oid");
		}

		// create path and map variables
		String localVarPath = "/rs/apikeys/{apiKeyId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "apiKeyId" + "\\}", getApiClient().escapeString(body.getId().getApiKeyId().toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<ApiKey>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<ApiKey> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Creates a ApiKey, if apiKey's oid is set, it will be created under this id
	 *
	 * @param body
	 * @return ApiKey
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public ApiKey setApiKey(ApiKey body) throws ApiException {
		Object localVarPostBody = body;

		// create path and map variables
		String localVarPath = "/rs/apikeys";
		if (body.getOid() != null) {
			localVarPath += "/" + getApiClient().escapeString(body.getOid());
		}

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<ApiKey>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<ApiKey> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Deletes a ApiKey
	 *
	 * @param apiKeyId
	 * @return Boolean
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Boolean deleteApiKey(String apiKeyId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'apiKeyId' is set
		if (apiKeyId == null) {
			throw new ApiException(400, "Missing the required parameter 'apiKeyId' when calling deleteApiKey");
		}

		// create path and map variables
		String localVarPath = "/rs/apikeys/{apiKeyId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "apiKeyId" + "\\}", getApiClient().escapeString(apiKeyId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Boolean>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Boolean> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Gets All Clients
	 *
	 * @return List<InlineResponse200>
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public List<Client> getClients() throws ApiException {
		Object localVarPostBody = null;

		// create path and map variables
		String localVarPath = "/rs/clients".replaceAll("\\{format\\}", "json");

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<List<Client>>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<List<Client>> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Gets a Client
	 *
	 * @param clientId
	 * @return Client
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Client getClient(String clientId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'clientId' is set
		if (clientId == null) {
			throw new ApiException(400, "Missing the required parameter 'clientId' when calling getClient");
		}

		// create path and map variables
		String localVarPath = "/rs/clients/{clientId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "clientId" + "\\}", getApiClient().escapeString(clientId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Client>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Client> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Updates a Client
	 *
	 * @param body the client to update
	 * @return Client
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Client updateClient(Client body) throws ApiException {
		Object localVarPostBody = body;

		// verify the required parameter 'clientId' is set
		if (body.getId().getClientId() == null) {
			throw new ApiException(400, "Missing the required parameter 'clientId' when calling updateClient");
		}

		// verify the required attribute oid us set as the id
		if (body.getId().getClientId().equals(body.getOid()) == false) {
			throw new ApiException(400, "Object id differs from object oid");
		}

		// create path and map variables
		String localVarPath = "/rs/clients/{clientId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "clientId" + "\\}", getApiClient().escapeString(body.getId().getClientId().toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Client>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Client> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Creates a Client, if client's oid is set, it will be created under this id
	 *
	 * @param body
	 * @return Client
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Client setClient(Client body) throws ApiException {
		Object localVarPostBody = body;

		// create path and map variables
		String localVarPath = "/rs/clients";
		if (body.getOid() != null) {
			localVarPath += "/" + getApiClient().escapeString(body.getOid());
		}

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Client>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Client> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Deletes a Client
	 *
	 * @param clientId
	 * @return Boolean
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Boolean deleteClient(String clientId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'clientId' is set
		if (clientId == null) {
			throw new ApiException(400, "Missing the required parameter 'clientId' when calling deleteClient");
		}

		// create path and map variables
		String localVarPath = "/rs/clients/{clientId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "clientId" + "\\}", getApiClient().escapeString(clientId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Boolean>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Boolean> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Validate connection definition and return a list of available schemas as a suggestion
	 *
	 * @param url
	 *        the JDBC url
	 * @param username
	 *        the username
	 * @param password
	 *        the password
	 * @param projectId
	 *        the project if algety defined
	 * @return ExpressionSuggestion
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public ExpressionSuggestion validateProjectConnection(String url, String username, String password, String projectId) throws ApiException {
		Object localVarPostBody = null;

		// create path and map variables
		String localVarPath = "/rs/connections/validate".replaceAll("\\{format\\}", "json");

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "url", url));

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "username", username));

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "password", password));

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "projectId", projectId));
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<ExpressionSuggestion>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<ExpressionSuggestion> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Gets all AnalysisJobs
	 *
	 * @return List<InlineResponse200>
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public List<ProjectAnalysisJob> getAnalysisJobs() throws ApiException {
		Object localVarPostBody = null;

		// create path and map variables
		String localVarPath = "/rs/internalanalysisjobs".replaceAll("\\{format\\}", "json");

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<List<ProjectAnalysisJob>>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<List<ProjectAnalysisJob>> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Deletes a domain
	 *
	 * @param internalJobId
	 * @return Boolean
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Boolean deleteDomain(String internalJobId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'internalJobId' is set
		if (internalJobId == null) {
			throw new ApiException(400, "Missing the required parameter 'internalJobId' when calling deleteDomain");
		}

		// create path and map variables
		String localVarPath = "/rs/internalanalysisjobs/{internalJobId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "internalJobId" + "\\}", getApiClient().escapeString(internalJobId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Boolean>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Boolean> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Logout the current User (identified by the AccessToken) by invalidating all its AccessTokens
	 *
	 * @return String
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public String logoutUser() throws ApiException {
		Object localVarPostBody = null;

		// create path and map variables
		String localVarPath = "/rs/logout".replaceAll("\\{format\\}", "json");

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<String>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<String> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Gets All Project
	 *
	 * @return List<InlineResponse200>
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public List<Project> getProjects() throws ApiException {
		Object localVarPostBody = null;

		// create path and map variables
		String localVarPath = "/rs/projects".replaceAll("\\{format\\}", "json");

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<List<Project>>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<List<Project>> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Gets a Project
	 *
	 * @param projectId
	 * @param deepread
	 * @return Project
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Project getProject(String projectId, Boolean deepread) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling getProject");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "deepread", deepread));
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Project>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Project> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Updates a Project
	 *
	 * @param body the project to update
	 * @return Project
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Project updateProject(Project body) throws ApiException {
		Object localVarPostBody = body;

		// verify the required parameter 'projectId' is set
		if (body.getId().getProjectId() == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling updateProject");
		}

		// verify the required attribute oid us set as the id
		if (body.getId().getProjectId().equals(body.getOid()) == false) {
			throw new ApiException(400, "Object id differs from object oid");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(body.getId().getProjectId().toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Project>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Project> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Creates a Project, if project's oid is set, it will be created under this id
	 *
	 * @param body
	 * @return Project
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Project setProject(Project body) throws ApiException {
		Object localVarPostBody = body;

		// create path and map variables
		String localVarPath = "/rs/projects".replaceAll("\\{format\\}", "json");
		if (body.getOid() != null) {
			localVarPath += "/" + getApiClient().escapeString(body.getOid());
		}

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Project>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Project> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Deletes a Project
	 *
	 * @param projectId
	 * @return Boolean
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Boolean deleteProject(String projectId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling deleteProject");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Boolean>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Boolean> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Gets all AnalysisJobs
	 *
	 * @param projectId
	 * @return List<InlineResponse200>
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public List<ProjectAnalysisJob> getAnalysisJobs(String projectId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling getAnalysisJobs");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/analysisjobs".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<List<ProjectAnalysisJob>>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<List<ProjectAnalysisJob>> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Create, update and/or re-compute an AnalysisJob
	 *
	 * @param projectId
	 * @param body
	 * @param timeout
	 * @param maxResults
	 *        paging size
	 * @param startIndex
	 *        paging start index
	 * @param lazy
	 *        if true, get the analysis only if algety in cache
	 * @param format
	 *        output format
	 * @param compression
	 *        output compression
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public ProjectAnalysisJob putAnalysisJob(String projectId, ProjectAnalysisJob body, Integer timeout, Integer maxResults, Integer startIndex, Boolean lazy, String format, String compression)
			throws ApiException {
		Object localVarPostBody = body;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling putAnalysisJob");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/analysisjobs".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		if (timeout != null) {
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "timeout", timeout));
		}
		if (maxResults != null) {
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "maxResults", maxResults));
		}
		if (startIndex != null) {
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "startIndex", startIndex));
		}
		if (lazy != null) {
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "lazy", lazy));
		}
		if (format != null) {
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "format", format));
		}
		if (compression != null) {
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "compression", compression));
		}
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<ProjectAnalysisJob>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<ProjectAnalysisJob> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Create, update and/or re-compute an AnalysisJob
	 *
	 * @param projectId
	 * @param body
	 * @param timeout
	 * @param maxResults
	 *        paging size
	 * @param startIndex
	 *        paging start index
	 * @param lazy
	 *        if true, get the analysis only if algety in cache
	 * @param format
	 *        output format
	 * @param compression
	 *        output compression
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public ProjectAnalysisJob setAnalysisJob(String projectId, ProjectAnalysisJob body, Integer timeout, Integer maxResults, Integer startIndex, Boolean lazy, String format, String compression)
			throws ApiException {
		Object localVarPostBody = body;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling setAnalysisJob");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/analysisjobs".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "timeout", timeout));

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "maxResults", maxResults));

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "startIndex", startIndex));

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "lazy", lazy));

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "format", format));

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "compression", compression));
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<ProjectAnalysisJob>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<ProjectAnalysisJob> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * JSONP specific method which supports both get operation and set operation using GET
	 *
	 * @param projectId
	 * @param jobId
	 * @param analysisJob
	 * @param timeout
	 * @return ProjectAnalysisJob
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public ProjectAnalysisJob getAnalysisJob(String projectId, String jobId, String analysisJob, Integer timeout) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling get");
		}

		// verify the required parameter 'jobId' is set
		if (jobId == null) {
			throw new ApiException(400, "Missing the required parameter 'jobId' when calling get");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/analysisjobs/{jobId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId.toString()))
				.replaceAll("\\{" + "jobId" + "\\}", getApiClient().escapeString(jobId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "analysisJob", analysisJob));

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "timeout", timeout));
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<ProjectAnalysisJob>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<ProjectAnalysisJob> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Deletes an AnalysisJobs
	 *
	 * @param projectId
	 * @param jobId
	 * @return Boolean
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Boolean deleteAnalysisJob(String projectId, String jobId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling deleteAnalysisJob");
		}

		// verify the required parameter 'jobId' is set
		if (jobId == null) {
			throw new ApiException(400, "Missing the required parameter 'jobId' when calling deleteAnalysisJob");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/analysisjobs/{jobId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId.toString()))
				.replaceAll("\\{" + "jobId" + "\\}", getApiClient().escapeString(jobId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Boolean>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Boolean> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Gets an AnalysisJobs&#39; results as a file
	 *
	 * @param projectId
	 * @param jobId
	 * @param ext
	 * @param timeout
	 *        response timeout in milliseconds in case the job is not yet computed. If no timeout set, the method will return according to current job status.
	 * @param maxResults
	 *        paging size
	 * @param startIndex
	 *        paging start index
	 * @param lazy
	 *        if true, get the analysis only if algety in cache
	 * @param type
	 *        response media type (optional)
	 * @param template
	 *        Velocity template as a base64 String (optional)
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public InputStream getAnalysisJobResultsAsFile(String projectId, String jobId, String ext, Integer timeout, Integer maxResults, Integer startIndex, Boolean lazy, String type, String template)
			throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling getResultsAsFile");
		}

		// verify the required parameter 'jobId' is set
		if (jobId == null) {
			throw new ApiException(400, "Missing the required parameter 'jobId' when calling getResultsAsFile");
		}

		// verify the required parameter 'ext' is set
		if (ext == null) {
			throw new ApiException(400, "Missing the required parameter 'ext' when calling getResultsAsFile");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/analysisjobs/{jobId}.{ext}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId.toString()))
				.replaceAll("\\{" + "jobId" + "\\}", getApiClient().escapeString(jobId.toString())).replaceAll("\\{" + "ext" + "\\}", getApiClient().escapeString(ext.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		if (timeout != null) {
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "timeout", timeout));
		}
		if (maxResults != null) {
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "maxResults", maxResults));
		}
		if (startIndex != null) {
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "startIndex", startIndex));
		}
		if (lazy != null) {
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "lazy", lazy));
		}
		if (type != null) {
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "type", type));
		}
		if (template != null) {
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "template", template));
		}
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<InputStream>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<InputStream> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Gets an AnalysisJobs&#39; results as a file
	 *
	 * @param projectId
	 * @param jobId
	 * @param ext
	 * @param timeout
	 *        response timeout in milliseconds in case the job is not yet computed. If no timeout set, the method will return according to current job status.
	 * @param maxResults
	 *        paging size
	 * @param startIndex
	 *        paging start index
	 * @param lazy
	 *        if true, get the analysis only if algety in cache
	 * @param type
	 *        response media type (optional)
	 * @param template
	 *        Velocity template as a base64 String (optional)
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public InputStream postAndGetResultsAsFile(String projectId, String jobId, String ext, Integer timeout, Integer maxResults, Integer startIndex, Boolean lazy, String type, String template)
			throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling postAndGetResultsAsFile");
		}

		// verify the required parameter 'jobId' is set
		if (jobId == null) {
			throw new ApiException(400, "Missing the required parameter 'jobId' when calling postAndGetResultsAsFile");
		}

		// verify the required parameter 'ext' is set
		if (ext == null) {
			throw new ApiException(400, "Missing the required parameter 'ext' when calling postAndGetResultsAsFile");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/analysisjobs/{jobId}.{ext}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId.toString()))
				.replaceAll("\\{" + "jobId" + "\\}", getApiClient().escapeString(jobId.toString())).replaceAll("\\{" + "ext" + "\\}", getApiClient().escapeString(ext.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "lazy", lazy));

		if (timeout != null) {
			localVarFormParams.put("timeout", timeout);
		}
		if (maxResults != null) {
			localVarFormParams.put("maxResults", maxResults);
		}
		if (startIndex != null) {
			localVarFormParams.put("startIndex", startIndex);
		}
		if (type != null) {
			localVarFormParams.put("type", type);
		}
		if (template != null) {
			localVarFormParams.put("template", template);
		}
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<InputStream>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<InputStream> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Gets an AnalysisJobs&#39; results decorated by a Velocity template
	 *
	 * @param projectId
	 * @param jobId
	 * @param timeout
	 *        response timeout in milliseconds in case the job is not yet computed. If no timeout set, the method will return according to current job status.
	 * @param maxResults
	 *        paging size
	 * @param startIndex
	 *        paging start index
	 * @param lazy
	 *        if true, get the analysis only if algety in cache
	 * @param type
	 *        response media type
	 * @param template
	 *        Velocity template as a base64 String
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public InputStream render(String projectId, String jobId, Integer timeout, Integer maxResults, Integer startIndex, Boolean lazy, String type, String template) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling render");
		}

		// verify the required parameter 'jobId' is set
		if (jobId == null) {
			throw new ApiException(400, "Missing the required parameter 'jobId' when calling render");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/analysisjobs/{jobId}/render".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId
				.toString())).replaceAll("\\{" + "jobId" + "\\}", getApiClient().escapeString(jobId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		if (timeout != null) {
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "timeout", timeout));
		}
		if (maxResults != null) {
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "maxResults", maxResults));
		}
		if (startIndex != null) {
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "startIndex", startIndex));
		}
		if (lazy != null) {
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "lazy", lazy));
		}
		if (type != null) {
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "type", type));
		}
		if (template != null) {
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "template", template));
		}
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<InputStream>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<InputStream> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Gets an AnalysisJobs&#39; results as a DataTable
	 *
	 * @param projectId
	 * @param jobId
	 * @param timeout
	 *        response timeout in milliseconds in case the job is not yet computed. If no timeout set, the method will return according to current job status.
	 * @param maxResults
	 *        paging size
	 * @param startIndex
	 *        paging start index
	 * @param lazy
	 *        if true, get the analysis only if algety in cache
	 * @param format
	 *        output format
	 * @param compression
	 *        output compression
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Object getAnalysisJobResults(String projectId, String jobId, Integer timeout, Integer maxResults, Integer startIndex, Boolean lazy, String format, String compression) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling getAnalysisJobResults");
		}

		// verify the required parameter 'jobId' is set
		if (jobId == null) {
			throw new ApiException(400, "Missing the required parameter 'jobId' when calling getAnalysisJobResults");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/analysisjobs/{jobId}/results".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId
				.toString())).replaceAll("\\{" + "jobId" + "\\}", getApiClient().escapeString(jobId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		if (timeout != null) {
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "timeout", timeout));
		}
		if (maxResults != null) {
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "maxResults", maxResults));
		}
		if (startIndex != null) {
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "startIndex", startIndex));
		}
		if (lazy != null) {
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "lazy", lazy));
		}
		if (format != null) {
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "format", format));
		}
		if (compression != null) {
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "compression", compression));
		}
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType;
		if (format == null) {
			localVarReturnType = new TypeToken<DataTable>() {}.getType();
		} else {
			localVarReturnType = new TypeToken<InputStream>() {}.getType();
		}
		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<String> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Get the SQL code used to compute the analysis
	 *
	 * @param projectId
	 * @param jobId
	 * @param prettyfier
	 *        if true return the SQL code as a html page and apply a prettyfier (default to true)
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public String viewSQL(String projectId, String jobId, Boolean prettyfier) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling viewSQL");
		}

		// verify the required parameter 'jobId' is set
		if (jobId == null) {
			throw new ApiException(400, "Missing the required parameter 'jobId' when calling viewSQL");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/analysisjobs/{jobId}/sql".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId.toString()))
				.replaceAll("\\{" + "jobId" + "\\}", getApiClient().escapeString(jobId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "prettyfier", prettyfier));
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<String>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<String> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Gets all domains
	 *
	 * @param projectId
	 * @return List<InlineResponse200>
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public List<Domain> getDomains(String projectId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling getDomains");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/domains".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<List<Domain>>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<List<Domain>> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Gets suggestions for Domain
	 *
	 * @param projectId
	 * @param expression
	 * @param offset
	 * @return ExpressionSuggestion
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public ExpressionSuggestion getDomainSuggestion(String projectId, String expression, Integer offset) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling getDomainSuggestion");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/domains-suggestion".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "expression", expression));

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "offset", offset));
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<ExpressionSuggestion>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<ExpressionSuggestion> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Gets a domain
	 *
	 * @param projectId
	 * @param domainId
	 * @param deepread
	 * @return Domain
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Domain getDomain(String projectId, String domainId, Boolean deepread) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling getDomain");
		}

		// verify the required parameter 'domainId' is set
		if (domainId == null) {
			throw new ApiException(400, "Missing the required parameter 'domainId' when calling getDomain");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/domains/{domainId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId.toString()))
				.replaceAll("\\{" + "domainId" + "\\}", getApiClient().escapeString(domainId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "deepread", deepread));
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Domain>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Domain> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Updates a domain
	 *
	 * @param body the domain to update
	 * @return Domain
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Domain updateDomain(Domain body) throws ApiException {
		Object localVarPostBody = body;

		// verify the required parameter 'projectId' is set
		if (body.getId().getProjectId() == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling updateAttribute");
		}

		// verify the required parameter 'domainId' is set
		if (body.getId().getDomainId() == null) {
			throw new ApiException(400, "Missing the required parameter 'domainId' when calling updateAttribute");
		}

		// verify the required attribute oid us set as the id
		if (body.getId().getDomainId().equals(body.getOid()) == false) {
			throw new ApiException(400, "Object id differs from object oid");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/domains/{domainId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(body.getId().getProjectId().toString()))
				.replaceAll("\\{" + "domainId" + "\\}", getApiClient().escapeString(body.getId().getDomainId().toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Domain>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Domain> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Creates a domain, if domain's oid is set, it will be created under this id
	 *
	 * @param projectId
	 * @param body
	 * @return Domain
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Domain setDomain(String projectId, Domain body) throws ApiException {
		Object localVarPostBody = body;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling setDomain");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/domains".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId.toString()));
		if (body.getOid() != null) {
			localVarPath += "/" + getApiClient().escapeString(body.getOid());
		}

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Domain>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Domain> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Deletes a domain
	 *
	 * @param projectId
	 * @param domainId
	 * @return Boolean
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Boolean deleteDomain(String projectId, String domainId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling deleteDomain");
		}

		// verify the required parameter 'domainId' is set
		if (domainId == null) {
			throw new ApiException(400, "Missing the required parameter 'domainId' when calling deleteDomain");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/domains/{domainId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId.toString()))
				.replaceAll("\\{" + "domainId" + "\\}", getApiClient().escapeString(domainId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Boolean>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Boolean> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Gets cache status for this domain
	 *
	 * @param projectId
	 * @param domainId
	 * @return InlineResponse200
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public CacheInfo getCacheInfo(String projectId, String domainId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling getCacheInfo");
		}

		// verify the required parameter 'domainId' is set
		if (domainId == null) {
			throw new ApiException(400, "Missing the required parameter 'domainId' when calling getCacheInfo");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/domains/{domainId}/cache".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId.toString()))
				.replaceAll("\\{" + "domainId" + "\\}", getApiClient().escapeString(domainId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<CacheInfo>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<CacheInfo> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Release all caches associated with a domain (facets, analysis)
	 *
	 * @param projectId
	 * @param domainId
	 * @return CacheInfo
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public CacheInfo releaseDomainCache(String projectId, String domainId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling releaseDomainCache");
		}

		// verify the required parameter 'domainId' is set
		if (domainId == null) {
			throw new ApiException(400, "Missing the required parameter 'domainId' when calling releaseDomainCache");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/domains/{domainId}/cache/refresh".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId
				.toString())).replaceAll("\\{" + "domainId" + "\\}", getApiClient().escapeString(domainId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<CacheInfo>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<CacheInfo> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Get all Dimensions for the Domain (including child dimensions).
	 *
	 * @param projectId
	 * @param domainId
	 * @return List<InlineResponse200>
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public List<Dimension> getDimensions(String projectId, String domainId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling getAllFromDomain");
		}

		// verify the required parameter 'domainId' is set
		if (domainId == null) {
			throw new ApiException(400, "Missing the required parameter 'domainId' when calling getAllFromDomain");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/domains/{domainId}/dimensions".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId
				.toString())).replaceAll("\\{" + "domainId" + "\\}", getApiClient().escapeString(domainId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<List<Dimension>>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<List<Dimension>> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Gets a dimension
	 *
	 * @param projectId
	 * @param domainId
	 * @param dimensionId
	 * @param deepread
	 * @return Dimension
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Dimension getDimension(String projectId, String domainId, String dimensionId, Boolean deepread) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling getDimension");
		}

		// verify the required parameter 'domainId' is set
		if (domainId == null) {
			throw new ApiException(400, "Missing the required parameter 'domainId' when calling getDimension");
		}

		// verify the required parameter 'dimensionId' is set
		if (dimensionId == null) {
			throw new ApiException(400, "Missing the required parameter 'dimensionId' when calling getDimension");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/domains/{domainId}/dimensions/{dimensionId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient()
				.escapeString(projectId.toString())).replaceAll("\\{" + "domainId" + "\\}", getApiClient().escapeString(domainId.toString())).replaceAll("\\{" + "dimensionId" + "\\}", getApiClient()
						.escapeString(dimensionId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "deepread", deepread));
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Dimension>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Dimension> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Updates a dimension
	 *
	 * @param body the dimension to update
	 * @return Dimension
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Dimension updateDimension(Dimension body) throws ApiException {
		Object localVarPostBody = body;

		// verify the required parameter 'projectId' is set
		if (body.getId().getProjectId() == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling updateAttribute");
		}

		// verify the required parameter 'domainId' is set
		if (body.getId().getDomainId() == null) {
			throw new ApiException(400, "Missing the required parameter 'domainId' when calling updateAttribute");
		}

		// verify the required parameter 'dimensionId' is set
		if (body.getId().getDimensionId() == null) {
			throw new ApiException(400, "Missing the required parameter 'dimensionId' when calling updateAttribute");
		}

		// verify the required attribute oid us set as the id
		if (body.getId().getDimensionId().equals(body.getOid()) == false) {
			throw new ApiException(400, "Object id differs from object oid");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/domains/{domainId}/dimensions/{dimensionId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient()
				.escapeString(body.getId().getProjectId().toString())).replaceAll("\\{" + "domainId" + "\\}", getApiClient().escapeString(body.getId().getDomainId().toString())).replaceAll("\\{" + "dimensionId" + "\\}", getApiClient()
						.escapeString(body.getId().getDimensionId().toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Dimension>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Dimension> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Creates a dimension, if dimension's oid is set, it will be created under this id
	 *
	 * @param projectId
	 * @param domainId
	 * @param body
	 * @return Dimension
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Dimension setDimension(String projectId, String domainId, Dimension body) throws ApiException {
		Object localVarPostBody = body;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling setDimension");
		}

		// verify the required parameter 'domainId' is set
		if (domainId == null) {
			throw new ApiException(400, "Missing the required parameter 'domainId' when calling setDimension");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/domains/{domainId}/dimensions".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient()
				.escapeString(projectId.toString())).replaceAll("\\{" + "domainId" + "\\}", getApiClient().escapeString(domainId.toString()));
		if (body.getOid() != null) {
			localVarPath += "/" + getApiClient().escapeString(body.getOid());
		}

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Dimension>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Dimension> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Deletes a dimension
	 *
	 * @param projectId
	 * @param domainId
	 * @param dimensionId
	 * @return Boolean
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Boolean deleteDimension(String projectId, String domainId, String dimensionId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling deleteDimension");
		}

		// verify the required parameter 'domainId' is set
		if (domainId == null) {
			throw new ApiException(400, "Missing the required parameter 'domainId' when calling deleteDimension");
		}

		// verify the required parameter 'dimensionId' is set
		if (dimensionId == null) {
			throw new ApiException(400, "Missing the required parameter 'dimensionId' when calling deleteDimension");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/domains/{domainId}/dimensions/{dimensionId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient()
				.escapeString(projectId.toString())).replaceAll("\\{" + "domainId" + "\\}", getApiClient().escapeString(domainId.toString())).replaceAll("\\{" + "dimensionId" + "\\}", getApiClient()
						.escapeString(dimensionId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Boolean>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Boolean> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Gets all Attribute
	 *
	 * @param projectId
	 * @param domainId
	 * @param dimensionId
	 * @return List<InlineResponse200>
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public List<Attribute> getAttributes(String projectId, String domainId, String dimensionId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling getAttributes");
		}

		// verify the required parameter 'domainId' is set
		if (domainId == null) {
			throw new ApiException(400, "Missing the required parameter 'domainId' when calling getAttributes");
		}

		// verify the required parameter 'dimensionId' is set
		if (dimensionId == null) {
			throw new ApiException(400, "Missing the required parameter 'dimensionId' when calling getAttributes");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/domains/{domainId}/dimensions/{dimensionId}/attributes".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient()
				.escapeString(projectId.toString())).replaceAll("\\{" + "domainId" + "\\}", getApiClient().escapeString(domainId.toString())).replaceAll("\\{" + "dimensionId" + "\\}", getApiClient()
						.escapeString(dimensionId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<List<Attribute>>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<List<Attribute>> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Gets an Attribute
	 *
	 * @param projectId
	 * @param domainId
	 * @param dimensionId
	 * @param attributeId
	 * @return Attribute
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Attribute getAttribute(String projectId, String domainId, String dimensionId, String attributeId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling getAttribute");
		}

		// verify the required parameter 'domainId' is set
		if (domainId == null) {
			throw new ApiException(400, "Missing the required parameter 'domainId' when calling getAttribute");
		}

		// verify the required parameter 'dimensionId' is set
		if (dimensionId == null) {
			throw new ApiException(400, "Missing the required parameter 'dimensionId' when calling getAttribute");
		}

		// verify the required parameter 'attributeId' is set
		if (attributeId == null) {
			throw new ApiException(400, "Missing the required parameter 'attributeId' when calling getAttribute");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/domains/{domainId}/dimensions/{dimensionId}/attributes/{attributeId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId"
				+ "\\}", getApiClient().escapeString(projectId.toString())).replaceAll("\\{" + "domainId" + "\\}", getApiClient().escapeString(domainId.toString())).replaceAll("\\{" + "dimensionId" + "\\}", getApiClient()
						.escapeString(dimensionId.toString())).replaceAll("\\{" + "attributeId" + "\\}", getApiClient().escapeString(attributeId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Attribute>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Attribute> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Updates an Attribute
	 *
-   * @param body the atrtibute to update
	 * @return Attribute
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Attribute updateAttribute(Attribute body) throws ApiException {
		Object localVarPostBody = body;

		// verify the required parameter 'projectId' is set
		if (body.getId().getProjectId() == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling updateAttribute");
		}

		// verify the required parameter 'domainId' is set
		if (body.getId().getDomainId() == null) {
			throw new ApiException(400, "Missing the required parameter 'domainId' when calling updateAttribute");
		}

		// verify the required parameter 'dimensionId' is set
		if (body.getId().getDimensionId() == null) {
			throw new ApiException(400, "Missing the required parameter 'dimensionId' when calling updateAttribute");
		}

		// verify the required parameter 'attributeId' is set
		if (body.getId().getAttributeId() == null ) {
			throw new ApiException(400, "Missing the required parameter 'attributeId' when calling updateAttribute");
		}

		// verify the required attribute oid us set as the id
		if (body.getId().getAttributeId().equals(body.getOid()) == false) {
			throw new ApiException(400, "Object id differs from object oid");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/domains/{domainId}/dimensions/{dimensionId}/attributes/{attributeId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId"
				+ "\\}", getApiClient().escapeString((body.getId().getProjectId().toString())).replaceAll("\\{" + "domainId" + "\\}", getApiClient().escapeString(body.getId().getDomainId().toString())).replaceAll("\\{" + "dimensionId" + "\\}", getApiClient()
						.escapeString(body.getId().getDimensionId().toString())).replaceAll("\\{" + "attributeId" + "\\}", getApiClient().escapeString(body.getId().getAttributeId().toString())));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Attribute>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Attribute> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Creates an Attribute, if attribute's oid is set, it will be created under this id
	 *
	 * @param projectId
	 * @param domainId
	 * @param dimensionId
	 * @param attributeId
	 * @param body
	 * @return Attribute
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Attribute setAttribute(String projectId, String domainId, String dimensionId, Attribute body) throws ApiException {
		Object localVarPostBody = body;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling setAttribute");
		}

		// verify the required parameter 'domainId' is set
		if (domainId == null) {
			throw new ApiException(400, "Missing the required parameter 'domainId' when calling setAttribute");
		}

		// verify the required parameter 'dimensionId' is set
		if (dimensionId == null) {
			throw new ApiException(400, "Missing the required parameter 'dimensionId' when calling setAttribute");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/domains/{domainId}/dimensions/{dimensionId}/attributes".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId"
				+ "\\}", getApiClient().escapeString(projectId.toString())).replaceAll("\\{" + "domainId" + "\\}", getApiClient().escapeString(domainId.toString())).replaceAll("\\{" + "dimensionId" + "\\}", getApiClient()
						.escapeString(dimensionId.toString()));

		if (body.getOid() != null) {
			localVarPath += "/" + getApiClient().escapeString(body.getOid());
		}
		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Attribute>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Attribute> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Deletes an Attribute
	 *
	 * @param projectId
	 * @param domainId
	 * @param dimensionId
	 * @param attributeId
	 * @return Boolean
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Boolean deleteAttribute(String projectId, String domainId, String dimensionId, String attributeId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling deleteAttribute");
		}

		// verify the required parameter 'domainId' is set
		if (domainId == null) {
			throw new ApiException(400, "Missing the required parameter 'domainId' when calling deleteAttribute");
		}

		// verify the required parameter 'dimensionId' is set
		if (dimensionId == null) {
			throw new ApiException(400, "Missing the required parameter 'dimensionId' when calling deleteAttribute");
		}

		// verify the required parameter 'attributeId' is set
		if (attributeId == null) {
			throw new ApiException(400, "Missing the required parameter 'attributeId' when calling deleteAttribute");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/domains/{domainId}/dimensions/{dimensionId}/attributes/{attributeId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId"
				+ "\\}", getApiClient().escapeString(projectId.toString())).replaceAll("\\{" + "domainId" + "\\}", getApiClient().escapeString(domainId.toString())).replaceAll("\\{" + "dimensionId" + "\\}", getApiClient()
						.escapeString(dimensionId.toString())).replaceAll("\\{" + "attributeId" + "\\}", getApiClient().escapeString(attributeId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Boolean>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Boolean> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Gets all DimensionOption
	 *
	 * @param projectId
	 * @param domainId
	 * @param dimensionId
	 * @return List<InlineResponse200>
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public List<DimensionOption> getDimensionOptions(String projectId, String domainId, String dimensionId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling getDimensionOptions");
		}

		// verify the required parameter 'domainId' is set
		if (domainId == null) {
			throw new ApiException(400, "Missing the required parameter 'domainId' when calling getDimensionOptions");
		}

		// verify the required parameter 'dimensionId' is set
		if (dimensionId == null) {
			throw new ApiException(400, "Missing the required parameter 'dimensionId' when calling getDimensionOptions");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/domains/{domainId}/dimensions/{dimensionId}/options".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient()
				.escapeString(projectId.toString())).replaceAll("\\{" + "domainId" + "\\}", getApiClient().escapeString(domainId.toString())).replaceAll("\\{" + "dimensionId" + "\\}", getApiClient()
						.escapeString(dimensionId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<List<DimensionOption>>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<List<DimensionOption>> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Gets an DimensionOption
	 *
	 * @param projectId
	 * @param domainId
	 * @param dimensionId
	 * @param optionId
	 * @return DimensionOption
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public DimensionOption getDimensionOption(String projectId, String domainId, String dimensionId, String optionId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling getDimensionOption");
		}

		// verify the required parameter 'domainId' is set
		if (domainId == null) {
			throw new ApiException(400, "Missing the required parameter 'domainId' when calling getDimensionOption");
		}

		// verify the required parameter 'dimensionId' is set
		if (dimensionId == null) {
			throw new ApiException(400, "Missing the required parameter 'dimensionId' when calling getDimensionOption");
		}

		// verify the required parameter 'optionId' is set
		if (optionId == null) {
			throw new ApiException(400, "Missing the required parameter 'optionId' when calling getDimensionOption");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/domains/{domainId}/dimensions/{dimensionId}/options/{optionId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId"
				+ "\\}", getApiClient().escapeString(projectId.toString())).replaceAll("\\{" + "domainId" + "\\}", getApiClient().escapeString(domainId.toString())).replaceAll("\\{" + "dimensionId" + "\\}", getApiClient()
						.escapeString(dimensionId.toString())).replaceAll("\\{" + "optionId" + "\\}", getApiClient().escapeString(optionId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<DimensionOption>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<DimensionOption> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Updates an DimensionOption
	 *
  -   * @param body the atrtibute to update
	 * @return DimensionOption
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public DimensionOption updateDimensionOption(DimensionOption body) throws ApiException {
		Object localVarPostBody = body;

		// verify the required parameter 'projectId' is set
		if (body.getId().getProjectId() == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling updateDimensionOption");
		}

		// verify the required parameter 'domainId' is set
		if (body.getId().getDomainId() == null) {
			throw new ApiException(400, "Missing the required parameter 'domainId' when calling updateDimensionOption");
		}

		// verify the required parameter 'dimensionId' is set
		if (body.getId().getDimensionId() == null) {
			throw new ApiException(400, "Missing the required parameter 'dimensionId' when calling updateDimensionOption");
		}

		// verify the required parameter 'optionId' is set
		if (body.getId().getOptionId() == null ) {
			throw new ApiException(400, "Missing the required parameter 'optionId' when calling updateDimensionOption");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/domains/{domainId}/dimensions/{dimensionId}/options/{optionId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId"
				+ "\\}", getApiClient().escapeString((body.getId().getProjectId().toString())).replaceAll("\\{" + "domainId" + "\\}", getApiClient().escapeString(body.getId().getDomainId().toString())).replaceAll("\\{" + "dimensionId" + "\\}", getApiClient()
						.escapeString(body.getId().getDimensionId().toString())).replaceAll("\\{" + "optionId" + "\\}", getApiClient().escapeString(body.getId().getOptionId().toString())));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<DimensionOption>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<DimensionOption> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Creates an DimensionOption, if attribute's oid is set, it will be created under this id
	 *
	 * @param projectId
	 * @param domainId
	 * @param dimensionId
	 * @param optionId
	 * @param body
	 * @return DimensionOption
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public DimensionOption setDimensionOption(String projectId, String domainId, String dimensionId, DimensionOption body) throws ApiException {
		Object localVarPostBody = body;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling setDimensionOption");
		}

		// verify the required parameter 'domainId' is set
		if (domainId == null) {
			throw new ApiException(400, "Missing the required parameter 'domainId' when calling setDimensionOption");
		}

		// verify the required parameter 'dimensionId' is set
		if (dimensionId == null) {
			throw new ApiException(400, "Missing the required parameter 'dimensionId' when calling setDimensionOption");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/domains/{domainId}/dimensions/{dimensionId}/options".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId"
				+ "\\}", getApiClient().escapeString(projectId.toString())).replaceAll("\\{" + "domainId" + "\\}", getApiClient().escapeString(domainId.toString())).replaceAll("\\{" + "dimensionId" + "\\}", getApiClient()
						.escapeString(dimensionId.toString()));

		if (body.getId().getOptionId() != null) {
			localVarPath += "/" + getApiClient().escapeString(body.getId().getOptionId());
		}
		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<DimensionOption>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<DimensionOption> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Deletes an DimensionOption
	 *
	 * @param projectId
	 * @param domainId
	 * @param dimensionId
	 * @param optionId
	 * @return Boolean
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Boolean deleteDimensionOption(String projectId, String domainId, String dimensionId, String optionId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling deleteDimensionOption");
		}

		// verify the required parameter 'domainId' is set
		if (domainId == null) {
			throw new ApiException(400, "Missing the required parameter 'domainId' when calling deleteDimensionOption");
		}

		// verify the required parameter 'dimensionId' is set
		if (dimensionId == null) {
			throw new ApiException(400, "Missing the required parameter 'dimensionId' when calling deleteDimensionOption");
		}

		// verify the required parameter 'optionId' is set
		if (optionId == null) {
			throw new ApiException(400, "Missing the required parameter 'optionId' when calling deleteDimensionOption");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/domains/{domainId}/dimensions/{dimensionId}/options/{optionId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId"
				+ "\\}", getApiClient().escapeString(projectId.toString())).replaceAll("\\{" + "domainId" + "\\}", getApiClient().escapeString(domainId.toString())).replaceAll("\\{" + "dimensionId" + "\\}", getApiClient()
						.escapeString(dimensionId.toString())).replaceAll("\\{" + "optionId" + "\\}", getApiClient().escapeString(optionId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Boolean>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Boolean> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Gets the SubDimensions
	 *
	 * @param projectId
	 * @param domainId
	 * @param dimensionId
	 * @return List<InlineResponse200>
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public List<Dimension> getSubDimensions(String projectId, String domainId, String dimensionId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling getSubDimensions");
		}

		// verify the required parameter 'domainId' is set
		if (domainId == null) {
			throw new ApiException(400, "Missing the required parameter 'domainId' when calling getSubDimensions");
		}

		// verify the required parameter 'dimensionId' is set
		if (dimensionId == null) {
			throw new ApiException(400, "Missing the required parameter 'dimensionId' when calling getSubDimensions");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/domains/{domainId}/dimensions/{dimensionId}/subdimensions".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient()
				.escapeString(projectId.toString())).replaceAll("\\{" + "domainId" + "\\}", getApiClient().escapeString(domainId.toString())).replaceAll("\\{" + "dimensionId" + "\\}", getApiClient()
						.escapeString(dimensionId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<List<Dimension>>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<List<Dimension>> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Gets All Metrics
	 *
	 * @param projectId
	 * @param domainId
	 * @return List<InlineResponse200>
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public List<Metric> getMetrics(String projectId, String domainId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling getMetrics");
		}

		// verify the required parameter 'domainId' is set
		if (domainId == null) {
			throw new ApiException(400, "Missing the required parameter 'domainId' when calling getMetrics");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/domains/{domainId}/metrics".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId.toString()))
				.replaceAll("\\{" + "domainId" + "\\}", getApiClient().escapeString(domainId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<List<Metric>>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<List<Metric>> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Gets a Metric
	 *
	 * @param projectId
	 * @param domainId
	 * @param metricId
	 * @param deepread
	 * @return Metric
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Metric getMetric(String projectId, String domainId, String metricId, Boolean deepread) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling getMetric");
		}

		// verify the required parameter 'domainId' is set
		if (domainId == null) {
			throw new ApiException(400, "Missing the required parameter 'domainId' when calling getMetric");
		}

		// verify the required parameter 'metricId' is set
		if (metricId == null) {
			throw new ApiException(400, "Missing the required parameter 'metricId' when calling getMetric");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/domains/{domainId}/metrics/{metricId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId
				.toString())).replaceAll("\\{" + "domainId" + "\\}", getApiClient().escapeString(domainId.toString())).replaceAll("\\{" + "metricId" + "\\}", getApiClient().escapeString(metricId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "deepread", deepread));
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Metric>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Metric> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Updates a Metric
	 *
	 * @param body the metric to update
	 * @return Metric
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Metric updateMetric(Metric body) throws ApiException {
		Object localVarPostBody = body;

		// verify the required parameter 'projectId' is set
		if (body.getId().getProjectId() == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling updateMetric");
		}

		// verify the required parameter 'domainId' is set
		if (body.getId().getDomainId() == null) {
			throw new ApiException(400, "Missing the required parameter 'domainId' when calling updateMetric");
		}

		// verify the required parameter 'metricId' is set
		if (body.getId().getMetricId() == null) {
			throw new ApiException(400, "Missing the required parameter 'metricId' when calling updateMetric");
		}

		// verify the required attribute oid us set as the id
		if (body.getId().getMetricId().equals(body.getOid()) == false) {
			throw new ApiException(400, "Object id differs from object oid");
		}
		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/domains/{domainId}/metrics/{metricId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(body.getId().getProjectId()
				.toString())).replaceAll("\\{" + "domainId" + "\\}", getApiClient().escapeString(body.getId().getDomainId().toString())).replaceAll("\\{" + "metricId" + "\\}", getApiClient().escapeString(body.getId().getMetricId().toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Metric>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Metric> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Creates a Metric, if metric's oid is set, it will be created under this id
	 *
	 * @param projectId
	 * @param domainId
	 * @param body
	 * @return Metric
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Metric setMetric(String projectId, String domainId, Metric body) throws ApiException {
		Object localVarPostBody = body;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling setMetric");
		}

		// verify the required parameter 'domainId' is set
		if (domainId == null) {
			throw new ApiException(400, "Missing the required parameter 'domainId' when calling setMetric");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/domains/{domainId}/metrics".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId
				.toString())).replaceAll("\\{" + "domainId" + "\\}", getApiClient().escapeString(domainId.toString()));
		if (body.getOid() != null) {
			localVarPath += "/" + getApiClient().escapeString(body.getOid());
		}

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Metric>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Metric> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Deletes a Metric
	 *
	 * @param projectId
	 * @param domainId
	 * @param metricId
	 * @return Boolean
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Boolean deleteMetric(String projectId, String domainId, String metricId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling deleteMetric");
		}

		// verify the required parameter 'domainId' is set
		if (domainId == null) {
			throw new ApiException(400, "Missing the required parameter 'domainId' when calling deleteMetric");
		}

		// verify the required parameter 'metricId' is set
		if (metricId == null) {
			throw new ApiException(400, "Missing the required parameter 'metricId' when calling deleteMetric");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/domains/{domainId}/metrics/{metricId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId
				.toString())).replaceAll("\\{" + "domainId" + "\\}", getApiClient().escapeString(domainId.toString())).replaceAll("\\{" + "metricId" + "\\}", getApiClient().escapeString(metricId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Boolean>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Boolean> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Get all Relations for the Domain.
	 *
	 * @param projectId
	 * @param domainId
	 * @return List<InlineResponse200>
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public List<Relation> getRelations(String projectId, String domainId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling getAllRelationsFromDomain");
		}

		// verify the required parameter 'domainId' is set
		if (domainId == null) {
			throw new ApiException(400, "Missing the required parameter 'domainId' when calling getAllRelationsFromDomain");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/domains/{domainId}/relations".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId
				.toString())).replaceAll("\\{" + "domainId" + "\\}", getApiClient().escapeString(domainId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<List<Relation>>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<List<Relation>> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Get new default relation for the Domain.
	 *
	 * @param projectId
	 * @param domainId
	 * @return Relation
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Relation getNewRelation(String projectId, String domainId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling setNewRelationInDomain");
		}

		// verify the required parameter 'domainId' is set
		if (domainId == null) {
			throw new ApiException(400, "Missing the required parameter 'domainId' when calling setNewRelationInDomain");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/domains/{domainId}/relations/new".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId
				.toString())).replaceAll("\\{" + "domainId" + "\\}", getApiClient().escapeString(domainId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Relation>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Relation> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Gets all FacetJobs
	 *
	 * @param projectId
	 * @return List<InlineResponse200>
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public List<ProjectFacetJob> getFacetJobs(String projectId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling getFacetJobs");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/facetjobs".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<List<ProjectFacetJob>>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<List<ProjectFacetJob>> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Create, update and/or re-compute a FacetJob
	 *
	 * @param projectId
	 * @param body
	 * @param timeout
	 * @return ProjectFacetJob
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public ProjectFacetJob putFacetJob(String projectId, ProjectFacetJob body, Integer timeout) throws ApiException {
		Object localVarPostBody = body;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling putFacetJob");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/facetjobs".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "timeout", timeout));
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<ProjectFacetJob>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<ProjectFacetJob> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Create, update and/or re-compute a FacetJob
	 *
	 * @param projectId
	 * @param body
	 * @param timeout
	 * @return ProjectFacetJob
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public ProjectFacetJob postFacetJob(String projectId, ProjectFacetJob body, Integer timeout) throws ApiException {
		Object localVarPostBody = body;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling postFacetJob");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/facetjobs".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "timeout", timeout));
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<ProjectFacetJob>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<ProjectFacetJob> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * JSONP specific method which supports both get operation and set operation using GET
	 *
	 * @param projectId
	 * @param jobId
	 * @param facetJob
	 * @param timeout
	 * @return ProjectFacetJob
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public ProjectFacetJob getFacetJob(String projectId, String jobId, String facetJob, Integer timeout) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling getFacetJob");
		}

		// verify the required parameter 'jobId' is set
		if (jobId == null) {
			throw new ApiException(400, "Missing the required parameter 'jobId' when calling getFacetJob");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/facetjobs/{jobId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId.toString()))
				.replaceAll("\\{" + "jobId" + "\\}", getApiClient().escapeString(jobId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "facetJob", facetJob));

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "timeout", timeout));
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<ProjectFacetJob>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<ProjectFacetJob> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Deletes a FacetJob
	 *
	 * @param projectId
	 * @param jobId
	 * @return Boolean
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Boolean deleteFacetJob(String projectId, String jobId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling deleteFacetJob");
		}

		// verify the required parameter 'jobId' is set
		if (jobId == null) {
			throw new ApiException(400, "Missing the required parameter 'jobId' when calling deleteFacetJob");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/facetjobs/{jobId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId.toString()))
				.replaceAll("\\{" + "jobId" + "\\}", getApiClient().escapeString(jobId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Boolean>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Boolean> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Gets FacetJob&#39; results as a FacetSelection
	 *
	 * @param projectId
	 * @param jobId
	 * @param timeout
	 * @param maxResults
	 * @param startIndex
	 * @param format
	 * @param compression
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public FacetSelection getFacetJobResults(String projectId, String jobId, Integer timeout, Integer maxResults, Integer startIndex, String format, String compression) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling getFacetJobResults");
		}

		// verify the required parameter 'jobId' is set
		if (jobId == null) {
			throw new ApiException(400, "Missing the required parameter 'jobId' when calling getFacetJobResults");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/facetjobs/{jobId}/results".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId.toString()))
				.replaceAll("\\{" + "jobId" + "\\}", getApiClient().escapeString(jobId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "timeout", timeout));

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "maxResults", maxResults));

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "startIndex", startIndex));

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "format", format));

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "compression", compression));
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<FacetSelection>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<FacetSelection> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Gets a Facet
	 *
	 * @param projectId
	 * @param jobId
	 * @param facetId
	 * @param filter
	 * @param timeout
	 * @param maxResults
	 * @param startIndex
	 * @return Facet
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Facet getFacet(String projectId, String jobId, String facetId, String filter, Integer timeout, Integer maxResults, Integer startIndex) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling getFacet");
		}

		// verify the required parameter 'jobId' is set
		if (jobId == null) {
			throw new ApiException(400, "Missing the required parameter 'jobId' when calling getFacet");
		}

		// verify the required parameter 'facetId' is set
		if (facetId == null) {
			throw new ApiException(400, "Missing the required parameter 'facetId' when calling getFacet");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/facetjobs/{jobId}/results/{facetId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId
				.toString())).replaceAll("\\{" + "jobId" + "\\}", getApiClient().escapeString(jobId.toString())).replaceAll("\\{" + "facetId" + "\\}", getApiClient().escapeString(facetId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "filter", filter));

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "timeout", timeout));

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "maxResults", maxResults));

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "startIndex", startIndex));
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Facet>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Facet> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Release caches including database metadata on which the project relies
	 *
	 * @param projectId
	 * @return Boolean
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Boolean releaseAllCaches(String projectId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling releaseAllCaches");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/refreshDatabase".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Boolean>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Boolean> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Drop project related caches (project, analyses, facets)
	 *
	 * @param projectId
	 * @return Boolean
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public CacheInfo releaseProjectCache(String projectId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling releaseProjectCache");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/cache/refresh".replaceAll("\\{format\\}","json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<CacheInfo>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<CacheInfo> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * refresh database table metadata cache, usefull when a new column is added, to avoid to release the full project (see releaseAllCaches)
	 *
	 * @param projectId
	 * @return the reloaded table object
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Object refreshTableCache(String projectId, String schemaName, String tableName) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling refreshDatabase");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/database/schemas/{schemaName}/tables/{tableName}/refresh".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient()
				.escapeString(projectId.toString())).replaceAll("\\{" + "schemaName" + "\\}", getApiClient().escapeString(schemaName.toString())).replaceAll("\\{" + "tableName" + "\\}", getApiClient()
						.escapeString(tableName.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Object>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Object> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Gets All Relations
	 *
	 * @param projectId
	 * @return all relations
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public List<Relation> getRelations(String projectId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling getAllRelationsFromProject");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/relations".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<List<Relation>>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<List<Relation>> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Gets suggestions for Relations
	 *
	 * @param projectId
	 * @param leftDomainId
	 * @param rightDomainId
	 * @param expression
	 * @param offset
	 * @return ExpressionSuggestion
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public ExpressionSuggestion getRelationSuggestion(String projectId, String leftDomainId, String rightDomainId, String expression, Integer offset) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling getRelationSuggestion");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/relations-suggestion".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "leftDomainId", leftDomainId));

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "rightDomainId", rightDomainId));

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "expression", expression));

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "offset", offset));
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<ExpressionSuggestion>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<ExpressionSuggestion> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Gets a Relation
	 *
	 * @param projectId
	 * @param relationId
	 * @return Relation
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Relation getRelation(String projectId, String relationId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling getRelation");
		}

		// verify the required parameter 'relationId' is set
		if (relationId == null) {
			throw new ApiException(400, "Missing the required parameter 'relationId' when calling getRelation");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/relations/{relationId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId.toString()))
				.replaceAll("\\{" + "relationId" + "\\}", getApiClient().escapeString(relationId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Relation>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Relation> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Updates a Relation
	 *
	 * @param body the relation to update
	 * @return Relation
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Relation updateRelation(Relation body) throws ApiException {
		Object localVarPostBody = body;

		// verify the required parameter 'projectId' is set
		if (body.getId().getProjectId() == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling updateRelation");
		}

		// verify the required parameter 'relationId' is set
		if (body.getId().getRelationId() == null) {
			throw new ApiException(400, "Missing the required parameter 'relationId' when calling updateRelation");
		}

		// verify the required attribute oid us set as the id
		if (body.getId().getRelationId().equals(body.getOid()) == false) {
			throw new ApiException(400, "Object id differs from object oid");
		}
		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/relations/{relationId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(body.getId().getProjectId().toString()))
				.replaceAll("\\{" + "relationId" + "\\}", getApiClient().escapeString(body.getId().getRelationId().toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Relation>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Relation> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Creates a Relation, if relation's oid is set, it will be created under this id
	 *
	 * @param projectId
	 * @param body
	 * @return Relation
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Relation setRelation(String projectId, Relation body) throws ApiException {
		Object localVarPostBody = body;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling setRelation");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/relations".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId.toString()));
		if (body.getOid() != null) {
			localVarPath += "/" + getApiClient().escapeString(body.getOid());
		}

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Relation>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Relation> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Deletes a Relation
	 *
	 * @param projectId
	 * @param relationId
	 * @return Boolean
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Boolean deleteRelation(String projectId, String relationId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling deleteRelation");
		}

		// verify the required parameter 'relationId' is set
		if (relationId == null) {
			throw new ApiException(400, "Missing the required parameter 'relationId' when calling deleteRelation");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/relations/{relationId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId.toString()))
				.replaceAll("\\{" + "relationId" + "\\}", getApiClient().escapeString(relationId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Boolean>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Boolean> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Gets suggestions for DB Schemas
	 *
	 * @param projectId
	 * @return ExpressionSuggestion
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public ExpressionSuggestion getSchemaSuggestion(String projectId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling getSchemaSuggestion");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/schemas-suggestion".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<ExpressionSuggestion>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<ExpressionSuggestion> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Validate the Project connection
	 *
	 * @param projectId
	 * @return Boolean
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Boolean validateProjectConnection(String projectId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling validateProjectConnection");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/validate".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Boolean>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Boolean> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Gets all non-temporary states
	 *
	 * @return List<InlineResponse200>
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public List<State> getStates() throws ApiException {
		Object localVarPostBody = null;

		// create path and map variables
		String localVarPath = "/rs/states".replaceAll("\\{format\\}", "json");

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<List<State>>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<List<State>> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Creates a state
	 *
	 * @param body
	 * @return State
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public State addState(State body) throws ApiException {
		Object localVarPostBody = body;

		// create path and map variables
		String localVarPath = "/rs/states".replaceAll("\\{format\\}", "json");

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<State>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<State> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Gets a state
	 *
	 * @param stateId
	 * @return State
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public State getState(String stateId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'stateId' is set
		if (stateId == null) {
			throw new ApiException(400, "Missing the required parameter 'stateId' when calling getState");
		}

		// create path and map variables
		String localVarPath = "/rs/states/{stateId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "stateId" + "\\}", getApiClient().escapeString(stateId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<State>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<State> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Gets the ACLs
	 *
	 * @param stateId
	 * @return List<InlineResponse200>
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public List<AccessRight> getAccessRightFromState(String stateId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'stateId' is set
		if (stateId == null) {
			throw new ApiException(400, "Missing the required parameter 'stateId' when calling getAccessRightFromState");
		}

		// create path and map variables
		String localVarPath = "/rs/states/{stateId}/access".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "stateId" + "\\}", getApiClient().escapeString(stateId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<List<AccessRight>>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<List<AccessRight>> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Get the platform build version.
	 *
	 * @return String
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public String status() throws ApiException {
		Object localVarPostBody = null;

		// create path and map variables
		String localVarPath = "/rs/status".replaceAll("\\{format\\}", "json");

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<String>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<String> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Retrieve an AccessToken given an AuthCode or a Refresh Token or a JWT
	 *
	 * @param grantType
	 * @param code
	 * @param refreshToken
	 * @param clientId
	 * @param clientSecret
	 * @param redirectUri
	 * @param assertion
	 * @return AccessToken
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public AccessToken authToken(String grantType, String code, String refreshToken, String clientId, String clientSecret, String redirectUri, String assertion) throws ApiException {
		Object localVarPostBody = null;

		// create path and map variables
		String localVarPath = "/rs/token".replaceAll("\\{format\\}", "json");

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		if (grantType != null) {
			localVarFormParams.put("grant_type", grantType);
		}
		if (code != null) {
			localVarFormParams.put("code", code);
		}
		if (refreshToken != null) {
			localVarFormParams.put("refresh_token", refreshToken);
		}
		if (clientId != null) {
			localVarFormParams.put("client_id", clientId);
		}
		if (clientSecret != null) {
			localVarFormParams.put("client_secret", clientSecret);
		}
		if (redirectUri != null) {
			localVarFormParams.put("redirect_uri", redirectUri);
		}
		if (assertion != null) {
			localVarFormParams.put("assertion", assertion);
		}
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<AccessToken>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<AccessToken> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Deletes a token
	 *
	 * @param tokenId
	 * @return Boolean
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Boolean deleteToken(String tokenId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'tokenId' is set
		if (tokenId == null) {
			throw new ApiException(400, "Missing the required parameter 'tokenId' when calling deleteToken");
		}

		// create path and map variables
		String localVarPath = "/rs/token/{tokenId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "tokenId" + "\\}", getApiClient().escapeString(tokenId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Boolean>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Boolean> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Token Validation. Tokens received via OAuth 2.0 Client-Side flow must be explicitly validated.
	 *
	 * @return AccessToken
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public AccessToken getTokenInfo() throws ApiException {
		Object localVarPostBody = null;

		// create path and map variables
		String localVarPath = "/rs/tokeninfo".replaceAll("\\{format\\}", "json");

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<AccessToken>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<AccessToken> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Get the current User (identified by the AccessToken)
	 *
	 * @return User
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public User getContextUser() throws ApiException {
		Object localVarPostBody = null;

		// create path and map variables
		String localVarPath = "/rs/user".replaceAll("\\{format\\}", "json");

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<User>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<User> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Gets All UserGroups
	 *
	 * @return List<InlineResponse200>
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public List<UserGroup> getUserGroups() throws ApiException {
		Object localVarPostBody = null;

		// create path and map variables
		String localVarPath = "/rs/usergroups".replaceAll("\\{format\\}", "json");

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<List<UserGroup>>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<List<UserGroup>> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Gets a UserGroup
	 *
	 * @param userGroupId
	 * @return UserGroup
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public UserGroup getUserGroup(String userGroupId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'userGroupId' is set
		if (userGroupId == null) {
			throw new ApiException(400, "Missing the required parameter 'userGroupId' when calling getUserGroup");
		}

		// create path and map variables
		String localVarPath = "/rs/usergroups/{userGroupId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "userGroupId" + "\\}", getApiClient().escapeString(userGroupId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<UserGroup>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<UserGroup> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Updates a UserGroup
	 *
	 * @param body the user group to update
	 * @return UserGroup
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public UserGroup updateUserGroup(UserGroup body) throws ApiException {
		Object localVarPostBody = body;

		// verify the required parameter 'userGroupId' is set
		if (body.getId().getUserGroupId() == null) {
			throw new ApiException(400, "Missing the required parameter 'userGroupId' when calling updateUserGroup");
		}

		// create path and map variables
		String localVarPath = "/rs/usergroups/{userGroupId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "userGroupId" + "\\}", getApiClient().escapeString(body.getId().getUserGroupId().toString()));

		// verify the required attribute oid us set as the id
		if (body.getId().getUserGroupId().equals(body.getOid()) == false) {
			throw new ApiException(400, "Object id differs from object oid");
		}

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<UserGroup>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<UserGroup> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Creates a UserGroup, if usergroup's oid is set, it will be created under this id
	 *
	 * @param body
	 * @return UserGroup
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public UserGroup setUserGroup(UserGroup body) throws ApiException {
		Object localVarPostBody = body;

		// create path and map variables
		String localVarPath = "/rs/usergroups".replaceAll("\\{format\\}", "json");
		if (body.getOid() != null) {
			localVarPath += "/" + getApiClient().escapeString(body.getOid());
		}

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<UserGroup>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<UserGroup> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Deletes a UserGroup
	 *
	 * @param userGroupId
	 * @return Boolean
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Boolean deleteUserGroup(String userGroupId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'userGroupId' is set
		if (userGroupId == null) {
			throw new ApiException(400, "Missing the required parameter 'userGroupId' when calling deleteUserGroup");
		}

		// create path and map variables
		String localVarPath = "/rs/usergroups/{userGroupId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "userGroupId" + "\\}", getApiClient().escapeString(userGroupId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Boolean>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Boolean> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Gets all Users
	 *
	 * @return List<InlineResponse200>
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public List<User> getUsers() throws ApiException {
		Object localVarPostBody = null;

		// create path and map variables
		String localVarPath = "/rs/users".replaceAll("\\{format\\}", "json");

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<List<User>>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<List<User>> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Gets a User
	 *
	 * @param userId
	 * @return User
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public User getUser(String userId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'userId' is set
		if (userId == null) {
			throw new ApiException(400, "Missing the required parameter 'userId' when calling getUser");
		}

		// create path and map variables
		String localVarPath = "/rs/users/{userId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "userId" + "\\}", getApiClient().escapeString(userId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<User>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<User> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Updates a User
	 *
	 * @param body the user to update
	 * @return User
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public User updateUser(User body) throws ApiException {
		Object localVarPostBody = body;

		// verify the required parameter 'userId' is set
		if (body.getId().getUserId() == null) {
			throw new ApiException(400, "Missing the required parameter 'userId' when calling updateUser");
		}

		// verify the required attribute oid us set as the id
		if (body.getId().getUserId().equals(body.getOid()) == false) {
			throw new ApiException(400, "Object id differs from object oid");
		}

		// create path and map variables
		String localVarPath = "/rs/users/{userId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "userId" + "\\}", getApiClient().escapeString(body.getId().getUserId().toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<User>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<User> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Creates a User, if user's oid is set, it will be created under this id
	 *
	 * @param body
	 * @return User
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public User setUser(User body) throws ApiException {
		Object localVarPostBody = body;

		// create path and map variables
		String localVarPath = "/rs/users".replaceAll("\\{format\\}", "json");
		if (body.getOid() != null) {
			localVarPath += "/" + getApiClient().escapeString(body.getOid());
		}

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<User>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<User> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Deletes a User
	 *
	 * @param userId
	 * @return Boolean
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Boolean deleteUser(String userId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'userId' is set
		if (userId == null) {
			throw new ApiException(400, "Missing the required parameter 'userId' when calling deleteUser");
		}

		// create path and map variables
		String localVarPath = "/rs/users/{userId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "userId" + "\\}", getApiClient().escapeString(userId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Boolean>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Boolean> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Start the reset-password process. Create a new &#39;reset_pwd&#39; AccessToken for the user having the passed email address.
	 *
	 * @param customerId
	 * @param clientId
	 * @param email
	 *        the email of the user account requesting a password reset
	 * @param lang
	 * @param linkUrl
	 *        the link url base used to build the link enclosed in the email (ie. http://api.squisolutions.com/release/api/reset_email?access_token={access_token}). The url must match the Client authorized urls
	 * @return String
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public String resetUserPassword(String customerId, String clientId, String email, String lang, String linkUrl) throws ApiException {
		Object localVarPostBody = null;

		// create path and map variables
		String localVarPath = "/rs/reset-user-pwd".replaceAll("\\{format\\}", "json");

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "customerId", customerId));
		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "clientId", clientId));
		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "email", email));
		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "lang", lang));
		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "link_url", linkUrl));

		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<String>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<String> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();
	}

	/**
	 * Start the reset-password process. Create a new &#39;reset_pwd&#39; AccessToken for the user having the passed email address.
	 *
	 * @param customerId
	 * @param clientId
	 * @param email
	 *        the email of the user account requesting a password reset
	 * @param lang
	 * @param linkUrl
	 *        the link url base used to build the link enclosed in the email (ie. http://api.squisolutions.com/release/api/reset_email?access_token={access_token}). The url must match the Client authorized urls
	 * @return String
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public String setUserPassword(String customerId, String clientId, String email, String lang, String linkUrl) throws ApiException {
		Object localVarPostBody = null;

		// create path and map variables
		String localVarPath = "/rs/set-user-pwd".replaceAll("\\{format\\}", "json");

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "customerId", customerId));
		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "clientId", clientId));
		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "email", email));
		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "lang", lang));
		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "link_url", linkUrl));

		final String[] localVarAccepts = { "application/json" };
		getApiClient().selectHeaderAccept(localVarAccepts);

		final String[] localVarContentTypes = {

		};
		getApiClient().selectHeaderContentType(localVarContentTypes);

		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<String>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<String> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Deletes a bookmark
	 *
	 * @param internalJobId
	 * @return Boolean
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Boolean deleteBookmark(String internalJobId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'internalJobId' is set
		if (internalJobId == null) {
			throw new ApiException(400, "Missing the required parameter 'internalJobId' when calling deleteBookmark");
		}

		// create path and map variables
		String localVarPath = "/rs/internalanalysisjobs/{internalJobId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "internalJobId" + "\\}", getApiClient().escapeString(internalJobId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Boolean>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Boolean> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Gets a bookmark
	 *
	 * @param projectId
	 * @param bookmarkId
	 * @param deepread
	 * @return Bookmark
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Bookmark getBookmark(String projectId, String bookmarkId, Boolean deepread) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling getBookmark");
		}

		// verify the required parameter 'bookmarkId' is set
		if (bookmarkId == null) {
			throw new ApiException(400, "Missing the required parameter 'bookmarkId' when calling getBookmark");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/bookmarks/{bookmarkId}".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId.toString()))
				.replaceAll("\\{" + "bookmarkId" + "\\}", getApiClient().escapeString(bookmarkId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();

		localVarQueryParams.addAll(getApiClient().parameterToPairs("", "deepread", deepread));
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Bookmark>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Bookmark> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Updates a bookmark
	 *
	 * @param body the bookmark to update
	 * @return Bookmark
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Bookmark updateBookmark(Bookmark body) throws ApiException {
		return getApiClient().callApi(ApiClient.Method.GET, body.getId().getApiUri(false), body);
	}

	/**
	 * Get all Bookmarks for the Project
	 *
	 * @param projectId
	 * @return List<InlineResponse200>
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public List<Bookmark> getBookmarks(String projectId) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'projectId' is set
		if (projectId == null) {
			throw new ApiException(400, "Missing the required parameter 'projectId' when calling getBookmarks");
		}

		// create path and map variables
		String localVarPath = "/rs/projects/{projectId}/bookmarks".replaceAll("\\{format\\}", "json").replaceAll("\\{" + "projectId" + "\\}", getApiClient().escapeString(projectId.toString()));

		// query params
		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		Map<String, String> localVarHeaderParams = new HashMap<String, String>();
		Map<String, Object> localVarFormParams = new HashMap<String, Object>();
		String[] localVarAuthNames = new String[] { "kraken_auth" };
		Type localVarReturnType = new TypeToken<List<Bookmark>>() {}.getType();

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<List<Bookmark>> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();

	}

	/**
	 * Creates a bookmark, if bookmark's oid is set, it will be created under this id
	 *
	 * @param projectId
	 * @param bookmarkId
	 * @param body
	 * @return Bookmark
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Bookmark setBookmark(String projectId, Bookmark body) throws ApiException {
		return getApiClient().callApi(ApiClient.Method.POST, body.getId().getApiUri(false), body);
	}

	/**
	 * Deletes a bookmark
	 *
	 * @param projectId
	 * @param bookmarkId
	 * @return Boolean
	 * @throws ApiException
	 *         if fails to make API call
	 */
	public Boolean deleteBookmark(BookmarkPK id) throws ApiException {
		return getApiClient().callApi(ApiClient.Method.DELETE, id.getApiUri(true), null);

	}


}

