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
package io.openbouquet.v4.api;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Call;

import io.openbouquet.v4.ApiCallback;
import io.openbouquet.v4.ApiClient;
import io.openbouquet.v4.ApiException;
import io.openbouquet.v4.ApiResponse;
import io.openbouquet.v4.Pair;
import io.openbouquet.v4.ProgressRequestBody;
import io.openbouquet.v4.ProgressResponseBody;
import io.openbouquet.v4.client.LoginConfiguration;
import io.openbouquet.v4.client.JWTConfiguration;
import io.openbouquet.v4.model.AnalyticsQuery;
import io.openbouquet.v4.model.Bookmark;
import io.openbouquet.v4.model.Facet;
import io.openbouquet.v4.model.QueryWorkerJobStatus;

public class AnalyticsApi extends BaseApi {


	public AnalyticsApi(ApiClient apiClient, LoginConfiguration configuration)
			throws ApiException {
		super(apiClient, configuration);
	}


	public AnalyticsApi(ApiClient apiClient, JWTConfiguration configuration)
			throws ApiException {
		super(apiClient, configuration);
	}

	public AnalyticsApi(ApiClient apiClient, String clientId, String jwt) throws ApiException {
		super(apiClient, clientId, jwt);
	}

	/**
	 * cancel the execution of the analysis identified by its QueryID
	 *
	 * @param QUERYID this is the AnalysisQuery QueryID (required)
	 * @return Boolean
	 * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
	 */
	public Boolean cancelQuery(String QUERYID) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'QUERYID' is set
		if (QUERYID == null) {
			throw new ApiException("Missing the required parameter 'QUERYID' when calling cancelQuery(Async)");
		}


		// create path and map variables
		String localVarPath = "/status/{QUERYID}/cancel".replaceAll("\\{format\\}","json")
				.replaceAll("\\{" + "QUERYID" + "\\}", getApiClient().escapeString(QUERYID.toString()));

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
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Boolean>(){}.getType();
		Call call =  getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Boolean> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();
	}

	/**
	 * create a new bookmark
	 *
	 * @param body the analysis query definition (required)
	 * @param REFERENCE  (required)
	 * @param name the new bookmark name (required)
	 * @param parent the new bookmark folder, can be /MYBOOKMARKS, /MYBOOKMARKS/any/folders or /SHARED/any/folders (optional)
	 * @return Bookmark
	 * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
	 */
	public Bookmark createBookmark(AnalyticsQuery body, String REFERENCE, String name, String parent) throws ApiException {
		Object localVarPostBody = body;

		// verify the required parameter 'body' is set
		if (body == null) {
			throw new ApiException("Missing the required parameter 'body' when calling createBookmark(Async)");
		}

		// verify the required parameter 'REFERENCE' is set
		if (REFERENCE == null) {
			throw new ApiException("Missing the required parameter 'REFERENCE' when calling createBookmark(Async)");
		}

		// verify the required parameter 'name' is set
		if (name == null) {
			throw new ApiException("Missing the required parameter 'name' when calling createBookmark(Async)");
		}


		// create path and map variables
		String localVarPath = "/analytics/{REFERENCE}".replaceAll("\\{format\\}","json")
				.replaceAll("\\{" + "REFERENCE" + "\\}", getApiClient().escapeString(REFERENCE.toString()));

		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		if (name != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "name", name));
		if (parent != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "parent", parent));

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
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Bookmark>(){}.getType();
		Call call = getApiClient().buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Bookmark> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();
	}

	/**
	 * Export an analysis results
	 *
	 * @param REFERENCE  (required)
	 * @param filename  (required)
	 * @param groupBy Define the facets to group by the results. Facet can be defined using it&#39;s ID or any valid expression. If empty, the subject default parameters will apply. You can use the * token to extend the subject default parameters. (optional)
	 * @param metrics Define the metrics to compute. Metric can be defined using it&#39;s ID or any valid expression. If empty, the subject default parameters will apply. You can use the * token to extend the subject default parameters. (optional)
	 * @param filters Define the filters to apply to results. A filter must be a valid conditional expression. If no filter is defined, the subject default filters will be applied. You can use the * token to extend the subject default filters instead of replacing. (optional)
	 * @param period the period defines a dimension or expression of a type date that is used to restrict the timeframe. You can use the __PERIOD expression as a alias to it in other parameters (e.g.: groupBy,orderBy...). (optional)
	 * @param timeframe the timeframe defines the period range to filter. You can use an array of two dates for lower/upper bounds (inclusive). Or some alias like __ALL, __LAST_DAY, __LAST_7_DAYS, __CURRENT_MONTH, __PREVIOUS_MONTH, __CURRENT_YEAR, __PREVIOOUS_YEAR (optional)
	 * @param compareTo Activate and define the compare to period. You can use an array of two dates for lower/upper bounds (inclusive). Or some alias like __COMPARE_TO_PREVIOUS_PERIOD, __COMPARE_TO_PREVIOUS_MONTH, __COMPARE_TO_PREVIOOUS_YEAR (optional)
	 * @param orderBy Define how to sort the results. You can specify a column neither by it&#39;s index (starting at zero by groupBy, then metrics), or using an expression. Use the function DESC() and ASC() to modify the sort order. The expression must be a column, or at least a hierarchical parent of a column (in that case a groupBy may be added automatically to the query). (optional)
	 * @param rollup Optionaly you can compute rollup for any groupBy column. It must be a valid indexe of a groupBy column or the expression FIRST(N) or LAST(N) to set the rollup position. Index starts at zero. Special value of -1 can be used to compute a grand total. (optional)
	 * @param limit limit the resultset size as computed by the database. Note that this is independent from the paging size defined by maxResults. (optional)
	 * @param offset offset the resultset first row - usually used with limit to paginate the database. Note that this is independent from the paging defined by startIndex. (optional)
	 * @param beyondLimit exclude some dimensions from the limit (optional)
	 * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
	 */
	public ApiResponse<Void> exportAnalysis(String REFERENCE, String filename, List<String> groupBy, List<String> metrics, List<String> filters, String period, List<String> timeframe, List<String> compareTo, List<String> orderBy, List<String> rollup, Long limit, Long offset, List<String> beyondLimit) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'REFERENCE' is set
		if (REFERENCE == null) {
			throw new ApiException("Missing the required parameter 'REFERENCE' when calling exportAnalysis(Async)");
		}

		// verify the required parameter 'filename' is set
		if (filename == null) {
			throw new ApiException("Missing the required parameter 'filename' when calling exportAnalysis(Async)");
		}


		// create path and map variables
		String localVarPath = "/analytics/{REFERENCE}/export/{filename}".replaceAll("\\{format\\}","json")
				.replaceAll("\\{" + "REFERENCE" + "\\}", getApiClient().escapeString(REFERENCE.toString()))
				.replaceAll("\\{" + "filename" + "\\}", getApiClient().escapeString(filename.toString()));

		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		if (groupBy != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("multi", "groupBy", groupBy));
		if (metrics != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("multi", "metrics", metrics));
		if (filters != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("multi", "filters", filters));
		if (period != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "period", period));
		if (timeframe != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("multi", "timeframe", timeframe));
		if (compareTo != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("multi", "compareTo", compareTo));
		if (orderBy != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("multi", "orderBy", orderBy));
		if (rollup != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("multi", "rollup", rollup));
		if (limit != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "limit", limit));
		if (offset != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "offset", offset));
		if (beyondLimit != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("multi", "beyondLimit", beyondLimit));

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

		String[] localVarAuthNames = new String[] { "kraken_auth" };
		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);

		return getApiClient().execute(call);
	}

	/**
	 * Get facet content using the default BB selection
	 *
	 * @param REFERENCE  (required)
	 * @param FACETID  (required)
	 * @param q search the facet values using a list of tokens (optional)
	 * @param filters Define the filters to apply to results. A filter must be a valid conditional expression. If empty, the subject default parameters will apply. You can use the * token to extend the subject default parameters. (optional)
	 * @param maxResults maximum number of items to return per page (optional)
	 * @param startIndex index of the first item to start the page (optional)
	 * @param timeout optional timeout in milliseconds (optional)
	 * @return Facet
	 * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
	 */
	public Facet getFacet(String REFERENCE, String FACETID, String q, List<String> filters, Integer maxResults, Integer startIndex, Integer timeout) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'REFERENCE' is set
		if (REFERENCE == null) {
			throw new ApiException("Missing the required parameter 'REFERENCE' when calling getFacet(Async)");
		}

		// verify the required parameter 'FACETID' is set
		if (FACETID == null) {
			throw new ApiException("Missing the required parameter 'FACETID' when calling getFacet(Async)");
		}


		// create path and map variables
		String localVarPath = "/analytics/{REFERENCE}/facets/{FACETID}".replaceAll("\\{format\\}","json")
				.replaceAll("\\{" + "REFERENCE" + "\\}", getApiClient().escapeString(REFERENCE.toString()))
				.replaceAll("\\{" + "FACETID" + "\\}", getApiClient().escapeString(FACETID.toString()));

		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		if (q != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "q", q));
		if (filters != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("multi", "filters", filters));
		if (maxResults != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "maxResults", maxResults));
		if (startIndex != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "startIndex", startIndex));
		if (timeout != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "timeout", timeout));

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
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Facet>(){}.getType();
		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Facet> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();
	}

	/**
	 * Get an item, can be a Domain or a Bookmark
	 *
	 * @param REFERENCE  (required)
	 * @return Object
	 * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
	 */
	public Object getItem(String REFERENCE) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'REFERENCE' is set
		if (REFERENCE == null) {
			throw new ApiException("Missing the required parameter 'REFERENCE' when calling getItem(Async)");
		}


		// create path and map variables
		String localVarPath = "/analytics/{REFERENCE}".replaceAll("\\{format\\}","json")
				.replaceAll("\\{" + "REFERENCE" + "\\}", getApiClient().escapeString(REFERENCE.toString()));

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
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		Type localVarReturnType = new TypeToken<Object>(){}.getType();
		ApiResponse<Object> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();
	}

	/**
	 * get the ongoing status of the analysis identified by its QueryID
	 *
	 * @param QUERYID this is the AnalysisQuery QueryID (required)
	 * @return List&lt;QueryWorkerJobStatus&gt;
	 * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
	 */
	public List<QueryWorkerJobStatus> getStatus(String QUERYID) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'QUERYID' is set
		if (QUERYID == null) {
			throw new ApiException("Missing the required parameter 'QUERYID' when calling getStatus(Async)");
		}


		// create path and map variables
		String localVarPath = "/status/{QUERYID}".replaceAll("\\{format\\}","json")
				.replaceAll("\\{" + "QUERYID" + "\\}", getApiClient().escapeString(QUERYID.toString()));

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
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<List<QueryWorkerJobStatus>>(){}.getType();
		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<List<QueryWorkerJobStatus>> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();
	}

	/**
	 * List available content
	 * It provides a comprehensive view including projects, domains, folders and bookmarks.You can use it to navigate the entire available content, or access a specific content by defining the parent parameter.The root parents are /PROJECTS for listing projects and domains, /MYBOOKMARKS to list the user bookmarks and folders, and /SHARED to list the shared bookmarks and folders.By default it lists ony the content directly under the parent, but you can set the hierarchy parameter to view content recursively.
	 * @param parent filter the content under the parent path (optional)
	 * @param q filter the content by name; q can be a multi-token search string separated by comma (optional)
	 * @param hierarchy define the hierarchy mode. FLAT mode return the hierarchy as a flat list, whereas TREE returns it as a folded structure (NIY) (optional)
	 * @param visibility filter the result depending on the object visibility (optional, default to VISIBLE)
	 * @param style define the result style. If HUMAN, the API will try to use natural reference for objects, like &#39;My First Project&#39;, &#39;Account&#39;, &#39;Total Sales&#39;... If ROBOT the API will use canonical references that are invariant, e.g. @&#39;5603ca63c531d744b50823a3bis&#39;. If LEGACY the API will also provide internal compound key to lookup objects in the management API. (optional, default to HUMAN)
	 * @param envelope define the result envelope (optional)
	 * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
	 */
	public Void listContent(String parent, String q, String hierarchy, String visibility, String style, String envelope) throws ApiException {
		Object localVarPostBody = null;


		// create path and map variables
		String localVarPath = "/analytics".replaceAll("\\{format\\}","json");

		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		if (parent != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "parent", parent));
		if (q != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "q", q));
		if (hierarchy != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "hierarchy", hierarchy));
		if (visibility != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "visibility", visibility));
		if (style != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "style", style));
		if (envelope != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "envelope", envelope));

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
		String[] localVarAuthNames = new String[] { "kraken_auth" };

		Type localVarReturnType = new TypeToken<Void>(){}.getType();
		Call call = getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, null);
		ApiResponse<Void> resp = getApiClient().execute(call, localVarReturnType);
		return resp.getData();
	}

	/* Build call for postAnalysis */
	private Call postAnalysisCall(AnalyticsQuery body, String REFERENCE, String data, Boolean applyFormatting, String envelope, Integer timeout, String state, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		Object localVarPostBody = body;

		// verify the required parameter 'body' is set
		if (body == null) {
			throw new ApiException("Missing the required parameter 'body' when calling postAnalysis(Async)");
		}

		// verify the required parameter 'REFERENCE' is set
		if (REFERENCE == null) {
			throw new ApiException("Missing the required parameter 'REFERENCE' when calling postAnalysis(Async)");
		}


		// create path and map variables
		String localVarPath = "/analytics/{REFERENCE}/query".replaceAll("\\{format\\}","json")
				.replaceAll("\\{" + "REFERENCE" + "\\}", getApiClient().escapeString(REFERENCE.toString()));

		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		if (data != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "data", data));
		if (applyFormatting != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "applyFormatting", applyFormatting));
		if (envelope != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "envelope", envelope));
		if (timeout != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "timeout", timeout));
		if (state != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "state", state));

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
		return getApiClient().buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
	}

	/**
	 * Run a new Analysis based on the Bookmark scope
	 *
	 * @param body the analysis query definition (required)
	 * @param REFERENCE  (required)
	 * @param data define the analysis data format. (optional)
	 * @param applyFormatting apply formatting to the output data (optional)
	 * @param envelope define the result envelope (optional)
	 * @param timeout response timeout in milliseconds. If no timeout set, the method will return according to current job status. (optional)
	 * @param state  (optional)
	 * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
	 */
	public void postAnalysis(AnalyticsQuery body, String REFERENCE, String data, Boolean applyFormatting, String envelope, Integer timeout, String state) throws ApiException {
		postAnalysisWithHttpInfo(body, REFERENCE, data, applyFormatting, envelope, timeout, state);
	}

	/**
	 * Run a new Analysis based on the Bookmark scope
	 *
	 * @param body the analysis query definition (required)
	 * @param REFERENCE  (required)
	 * @param data define the analysis data format. (optional)
	 * @param applyFormatting apply formatting to the output data (optional)
	 * @param envelope define the result envelope (optional)
	 * @param timeout response timeout in milliseconds. If no timeout set, the method will return according to current job status. (optional)
	 * @param state  (optional)
	 * @return ApiResponse&lt;Void&gt;
	 * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
	 */
	public ApiResponse<Void> postAnalysisWithHttpInfo(AnalyticsQuery body, String REFERENCE, String data, Boolean applyFormatting, String envelope, Integer timeout, String state) throws ApiException {
		Call call = postAnalysisCall(body, REFERENCE, data, applyFormatting, envelope, timeout, state, null, null);
		return getApiClient().execute(call);
	}

	/**
	 * Run a new Analysis based on the Bookmark scope (asynchronously)
	 *
	 * @param body the analysis query definition (required)
	 * @param REFERENCE  (required)
	 * @param data define the analysis data format. (optional)
	 * @param applyFormatting apply formatting to the output data (optional)
	 * @param envelope define the result envelope (optional)
	 * @param timeout response timeout in milliseconds. If no timeout set, the method will return according to current job status. (optional)
	 * @param state  (optional)
	 * @param callback The callback to be executed when the API call finishes
	 * @return The request call
	 * @throws ApiException If fail to process the API call, e.g. serializing the request body object
	 */
	public Call postAnalysisAsync(AnalyticsQuery body, String REFERENCE, String data, Boolean applyFormatting, String envelope, Integer timeout, String state, final ApiCallback<Void> callback) throws ApiException {

		ProgressResponseBody.ProgressListener progressListener = null;
		ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

		if (callback != null) {
			progressListener = new ProgressResponseBody.ProgressListener() {
				@Override
				public void update(long bytesRead, long contentLength, boolean done) {
					callback.onDownloadProgress(bytesRead, contentLength, done);
				}
			};

			progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
				@Override
				public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
					callback.onUploadProgress(bytesWritten, contentLength, done);
				}
			};
		}

		Call call = postAnalysisCall(body, REFERENCE, data, applyFormatting, envelope, timeout, state, progressListener, progressRequestListener);
		getApiClient().executeAsync(call, callback);
		return call;
	}
	/* Build call for runAnalysis */
	private Call runAnalysisCall(String REFERENCE, List<String> groupBy, List<String> metrics, List<String> filters, String period, List<String> timeframe, List<String> compareTo, List<String> orderBy, List<String> rollup, Long limit, Long offset, List<String> beyondLimit, Integer maxResults, Integer startIndex, String lazy, String data, Boolean applyFormatting, String style, String envelope, Integer timeout, String state, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'REFERENCE' is set
		if (REFERENCE == null) {
			throw new ApiException("Missing the required parameter 'REFERENCE' when calling runAnalysis(Async)");
		}


		// create path and map variables
		String localVarPath = "/analytics/{REFERENCE}/query".replaceAll("\\{format\\}","json")
				.replaceAll("\\{" + "REFERENCE" + "\\}", getApiClient().escapeString(REFERENCE.toString()));

		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		if (groupBy != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("multi", "groupBy", groupBy));
		if (metrics != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("multi", "metrics", metrics));
		if (filters != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("multi", "filters", filters));
		if (period != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "period", period));
		if (timeframe != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("multi", "timeframe", timeframe));
		if (compareTo != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("multi", "compareTo", compareTo));
		if (orderBy != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("multi", "orderBy", orderBy));
		if (rollup != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("multi", "rollup", rollup));
		if (limit != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "limit", limit));
		if (offset != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "offset", offset));
		if (beyondLimit != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("multi", "beyondLimit", beyondLimit));
		if (maxResults != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "maxResults", maxResults));
		if (startIndex != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "startIndex", startIndex));
		if (lazy != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "lazy", lazy));
		if (data != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "data", data));
		if (applyFormatting != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "applyFormatting", applyFormatting));
		if (style != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "style", style));
		if (envelope != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "envelope", envelope));
		if (timeout != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "timeout", timeout));
		if (state != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "state", state));

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
		return getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
	}

	/**
	 * Compute an analysis for the subject
	 *
	 * @param REFERENCE  (required)
	 * @param groupBy Define the facets to group by the results. Facet can be defined using it&#39;s ID or any valid expression. If empty, the subject default parameters will apply. You can use the * token to extend the subject default parameters. (optional)
	 * @param metrics Define the metrics to compute. Metric can be defined using it&#39;s ID or any valid expression. If empty, the subject default parameters will apply. You can use the * token to extend the subject default parameters. (optional)
	 * @param filters Define the filters to apply to results. A filter must be a valid conditional expression. If no filter is defined, the subject default filters will be applied. You can use the * token to extend the subject default filters instead of replacing. (optional)
	 * @param period the period defines a dimension or expression of a type date that is used to restrict the timeframe. You can use the __PERIOD expression as a alias to it in other parameters (e.g.: groupBy,orderBy...). (optional)
	 * @param timeframe the timeframe defines the period range to filter. You can use an array of two dates for lower/upper bounds (inclusive). Or some alias like __ALL, __LAST_DAY, __LAST_7_DAYS, __CURRENT_MONTH, __PREVIOUS_MONTH, __CURRENT_YEAR, __PREVIOOUS_YEAR (optional)
	 * @param compareTo Activate and define the compare to period. You can use an array of two dates for lower/upper bounds (inclusive). Or some alias like __COMPARE_TO_PREVIOUS_PERIOD, __COMPARE_TO_PREVIOUS_MONTH, __COMPARE_TO_PREVIOOUS_YEAR (optional)
	 * @param orderBy Define how to sort the results. You can specify a column neither by it&#39;s index (starting at zero by groupBy, then metrics), or using an expression. Use the function DESC() and ASC() to modify the sort order. The expression must be a column, or at least a hierarchical parent of a column (in that case a groupBy may be added automatically to the query). (optional)
	 * @param rollup Optionaly you can compute rollup for any groupBy column. It must be a valid indexe of a groupBy column or the expression FIRST(N) or LAST(N) to set the rollup position. Index starts at zero. Special value of -1 can be used to compute a grand total. (optional)
	 * @param limit limit the resultset size as computed by the database. Note that this is independent from the paging size defined by maxResults. (optional)
	 * @param offset offset the resultset first row - usually used with limit to paginate the database. Note that this is independent from the paging defined by startIndex. (optional)
	 * @param beyondLimit exclude some dimensions from the limit (optional)
	 * @param maxResults Define the pagination size. (optional)
	 * @param startIndex Pagination starting index. Index is zero-based, so use the #count of the last row to view the next page. (optional)
	 * @param lazy if true, get the analysis only if already in cache, else throw a NotInCacheException; if noError returns a null result if the analysis is not in cache ; else regular analysis (optional, default to false)
	 * @param data define the analysis data output format. (optional)
	 * @param applyFormatting apply formatting to the output data (optional)
	 * @param style define the response style. If HUMAN, the API will try to use natural reference for objects, like &#39;My First Project&#39;, &#39;Account&#39;, &#39;Total Sales&#39;... If MACHINE the API will use canonical references that are invariant, e.g. @&#39;5603ca63c531d744b50823a3bis&#39;. If LEGACY the API will also provide internal compound key to lookup objects in the management API. (optional, default to HUMAN)
	 * @param envelope define the result envelope (optional)
	 * @param timeout response timeout in milliseconds. If no timeout set, the method will return according to current job status. (optional)
	 * @param state  (optional)
	 * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
	 */
	public void runAnalysis(String REFERENCE, List<String> groupBy, List<String> metrics, List<String> filters, String period, List<String> timeframe, List<String> compareTo, List<String> orderBy, List<String> rollup, Long limit, Long offset, List<String> beyondLimit, Integer maxResults, Integer startIndex, String lazy, String data, Boolean applyFormatting, String style, String envelope, Integer timeout, String state) throws ApiException {
		runAnalysisWithHttpInfo(REFERENCE, groupBy, metrics, filters, period, timeframe, compareTo, orderBy, rollup, limit, offset, beyondLimit, maxResults, startIndex, lazy, data, applyFormatting, style, envelope, timeout, state);
	}

	/**
	 * Compute an analysis for the subject
	 *
	 * @param REFERENCE  (required)
	 * @param groupBy Define the facets to group by the results. Facet can be defined using it&#39;s ID or any valid expression. If empty, the subject default parameters will apply. You can use the * token to extend the subject default parameters. (optional)
	 * @param metrics Define the metrics to compute. Metric can be defined using it&#39;s ID or any valid expression. If empty, the subject default parameters will apply. You can use the * token to extend the subject default parameters. (optional)
	 * @param filters Define the filters to apply to results. A filter must be a valid conditional expression. If no filter is defined, the subject default filters will be applied. You can use the * token to extend the subject default filters instead of replacing. (optional)
	 * @param period the period defines a dimension or expression of a type date that is used to restrict the timeframe. You can use the __PERIOD expression as a alias to it in other parameters (e.g.: groupBy,orderBy...). (optional)
	 * @param timeframe the timeframe defines the period range to filter. You can use an array of two dates for lower/upper bounds (inclusive). Or some alias like __ALL, __LAST_DAY, __LAST_7_DAYS, __CURRENT_MONTH, __PREVIOUS_MONTH, __CURRENT_YEAR, __PREVIOOUS_YEAR (optional)
	 * @param compareTo Activate and define the compare to period. You can use an array of two dates for lower/upper bounds (inclusive). Or some alias like __COMPARE_TO_PREVIOUS_PERIOD, __COMPARE_TO_PREVIOUS_MONTH, __COMPARE_TO_PREVIOOUS_YEAR (optional)
	 * @param orderBy Define how to sort the results. You can specify a column neither by it&#39;s index (starting at zero by groupBy, then metrics), or using an expression. Use the function DESC() and ASC() to modify the sort order. The expression must be a column, or at least a hierarchical parent of a column (in that case a groupBy may be added automatically to the query). (optional)
	 * @param rollup Optionaly you can compute rollup for any groupBy column. It must be a valid indexe of a groupBy column or the expression FIRST(N) or LAST(N) to set the rollup position. Index starts at zero. Special value of -1 can be used to compute a grand total. (optional)
	 * @param limit limit the resultset size as computed by the database. Note that this is independent from the paging size defined by maxResults. (optional)
	 * @param offset offset the resultset first row - usually used with limit to paginate the database. Note that this is independent from the paging defined by startIndex. (optional)
	 * @param beyondLimit exclude some dimensions from the limit (optional)
	 * @param maxResults Define the pagination size. (optional)
	 * @param startIndex Pagination starting index. Index is zero-based, so use the #count of the last row to view the next page. (optional)
	 * @param lazy if true, get the analysis only if already in cache, else throw a NotInCacheException; if noError returns a null result if the analysis is not in cache ; else regular analysis (optional, default to false)
	 * @param data define the analysis data output format. (optional)
	 * @param applyFormatting apply formatting to the output data (optional)
	 * @param style define the response style. If HUMAN, the API will try to use natural reference for objects, like &#39;My First Project&#39;, &#39;Account&#39;, &#39;Total Sales&#39;... If MACHINE the API will use canonical references that are invariant, e.g. @&#39;5603ca63c531d744b50823a3bis&#39;. If LEGACY the API will also provide internal compound key to lookup objects in the management API. (optional, default to HUMAN)
	 * @param envelope define the result envelope (optional)
	 * @param timeout response timeout in milliseconds. If no timeout set, the method will return according to current job status. (optional)
	 * @param state  (optional)
	 * @return ApiResponse&lt;Void&gt;
	 * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
	 */
	public ApiResponse<Void> runAnalysisWithHttpInfo(String REFERENCE, List<String> groupBy, List<String> metrics, List<String> filters, String period, List<String> timeframe, List<String> compareTo, List<String> orderBy, List<String> rollup, Long limit, Long offset, List<String> beyondLimit, Integer maxResults, Integer startIndex, String lazy, String data, Boolean applyFormatting, String style, String envelope, Integer timeout, String state) throws ApiException {
		Call call = runAnalysisCall(REFERENCE, groupBy, metrics, filters, period, timeframe, compareTo, orderBy, rollup, limit, offset, beyondLimit, maxResults, startIndex, lazy, data, applyFormatting, style, envelope, timeout, state, null, null);
		return getApiClient().execute(call);
	}

	/**
	 * Compute an analysis for the subject (asynchronously)
	 *
	 * @param REFERENCE  (required)
	 * @param groupBy Define the facets to group by the results. Facet can be defined using it&#39;s ID or any valid expression. If empty, the subject default parameters will apply. You can use the * token to extend the subject default parameters. (optional)
	 * @param metrics Define the metrics to compute. Metric can be defined using it&#39;s ID or any valid expression. If empty, the subject default parameters will apply. You can use the * token to extend the subject default parameters. (optional)
	 * @param filters Define the filters to apply to results. A filter must be a valid conditional expression. If no filter is defined, the subject default filters will be applied. You can use the * token to extend the subject default filters instead of replacing. (optional)
	 * @param period the period defines a dimension or expression of a type date that is used to restrict the timeframe. You can use the __PERIOD expression as a alias to it in other parameters (e.g.: groupBy,orderBy...). (optional)
	 * @param timeframe the timeframe defines the period range to filter. You can use an array of two dates for lower/upper bounds (inclusive). Or some alias like __ALL, __LAST_DAY, __LAST_7_DAYS, __CURRENT_MONTH, __PREVIOUS_MONTH, __CURRENT_YEAR, __PREVIOOUS_YEAR (optional)
	 * @param compareTo Activate and define the compare to period. You can use an array of two dates for lower/upper bounds (inclusive). Or some alias like __COMPARE_TO_PREVIOUS_PERIOD, __COMPARE_TO_PREVIOUS_MONTH, __COMPARE_TO_PREVIOOUS_YEAR (optional)
	 * @param orderBy Define how to sort the results. You can specify a column neither by it&#39;s index (starting at zero by groupBy, then metrics), or using an expression. Use the function DESC() and ASC() to modify the sort order. The expression must be a column, or at least a hierarchical parent of a column (in that case a groupBy may be added automatically to the query). (optional)
	 * @param rollup Optionaly you can compute rollup for any groupBy column. It must be a valid indexe of a groupBy column or the expression FIRST(N) or LAST(N) to set the rollup position. Index starts at zero. Special value of -1 can be used to compute a grand total. (optional)
	 * @param limit limit the resultset size as computed by the database. Note that this is independent from the paging size defined by maxResults. (optional)
	 * @param offset offset the resultset first row - usually used with limit to paginate the database. Note that this is independent from the paging defined by startIndex. (optional)
	 * @param beyondLimit exclude some dimensions from the limit (optional)
	 * @param maxResults Define the pagination size. (optional)
	 * @param startIndex Pagination starting index. Index is zero-based, so use the #count of the last row to view the next page. (optional)
	 * @param lazy if true, get the analysis only if already in cache, else throw a NotInCacheException; if noError returns a null result if the analysis is not in cache ; else regular analysis (optional, default to false)
	 * @param data define the analysis data output format. (optional)
	 * @param applyFormatting apply formatting to the output data (optional)
	 * @param style define the response style. If HUMAN, the API will try to use natural reference for objects, like &#39;My First Project&#39;, &#39;Account&#39;, &#39;Total Sales&#39;... If MACHINE the API will use canonical references that are invariant, e.g. @&#39;5603ca63c531d744b50823a3bis&#39;. If LEGACY the API will also provide internal compound key to lookup objects in the management API. (optional, default to HUMAN)
	 * @param envelope define the result envelope (optional)
	 * @param timeout response timeout in milliseconds. If no timeout set, the method will return according to current job status. (optional)
	 * @param state  (optional)
	 * @param callback The callback to be executed when the API call finishes
	 * @return The request call
	 * @throws ApiException If fail to process the API call, e.g. serializing the request body object
	 */
	public Call runAnalysisAsync(String REFERENCE, List<String> groupBy, List<String> metrics, List<String> filters, String period, List<String> timeframe, List<String> compareTo, List<String> orderBy, List<String> rollup, Long limit, Long offset, List<String> beyondLimit, Integer maxResults, Integer startIndex, String lazy, String data, Boolean applyFormatting, String style, String envelope, Integer timeout, String state, final ApiCallback<Void> callback) throws ApiException {

		ProgressResponseBody.ProgressListener progressListener = null;
		ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

		if (callback != null) {
			progressListener = new ProgressResponseBody.ProgressListener() {
				@Override
				public void update(long bytesRead, long contentLength, boolean done) {
					callback.onDownloadProgress(bytesRead, contentLength, done);
				}
			};

			progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
				@Override
				public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
					callback.onUploadProgress(bytesWritten, contentLength, done);
				}
			};
		}

		Call call = runAnalysisCall(REFERENCE, groupBy, metrics, filters, period, timeframe, compareTo, orderBy, rollup, limit, offset, beyondLimit, maxResults, startIndex, lazy, data, applyFormatting, style, envelope, timeout, state, progressListener, progressRequestListener);
		getApiClient().executeAsync(call, callback);
		return call;
	}
	/* Build call for scopeAnalysis */
	private Call scopeAnalysisCall(String REFERENCE, String value, Integer offset, List<String> types, List<String> values, String style, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'REFERENCE' is set
		if (REFERENCE == null) {
			throw new ApiException("Missing the required parameter 'REFERENCE' when calling scopeAnalysis(Async)");
		}


		// create path and map variables
		String localVarPath = "/analytics/{REFERENCE}/scope".replaceAll("\\{format\\}","json")
				.replaceAll("\\{" + "REFERENCE" + "\\}", getApiClient().escapeString(REFERENCE.toString()));

		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		if (value != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "value", value));
		if (offset != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "offset", offset));
		if (types != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("multi", "types", types));
		if (values != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("multi", "values", values));
		if (style != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "style", style));

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
		return getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
	}

	/**
	 * Provide information about the expressions available in the bookmark scope
	 * It also allows to check if a given expression is valid in the scope, and further explore the scope if the expression is an object. Using the offset parameter you can get suggestion at the caret position instead of the complete expression value.
	 * @param REFERENCE  (required)
	 * @param value (optional) the expression to check and get suggestion for, or null in order to get scope level suggestions (optional)
	 * @param offset (optionnal) caret position in the expression value in order to provide relevant suggestions based on the caret position. By default the suggestion are based on the full expression if provided, or else the entire bookmark scope. (optional)
	 * @param types (optional) the expression type to filter the suggestions. If undefined all valid expression in the context are returned.  (optional)
	 * @param values (optional) the expression value to filter the suggestions. If undefined all valid expression in the context are returned.  (optional)
	 * @param style define the response style. If HUMAN, the API will try to use natural reference for objects, like &#39;My First Project&#39;, &#39;Account&#39;, &#39;Total Sales&#39;... If MACHINE the API will use canonical references that are invariant, e.g. @&#39;5603ca63c531d744b50823a3bis&#39;. If LEGACY the API will also provide internal compound key to lookup objects in the management API. (optional, default to HUMAN)
	 * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
	 */
	public void scopeAnalysis(String REFERENCE, String value, Integer offset, List<String> types, List<String> values, String style) throws ApiException {
		scopeAnalysisWithHttpInfo(REFERENCE, value, offset, types, values, style);
	}

	/**
	 * Provide information about the expressions available in the bookmark scope
	 * It also allows to check if a given expression is valid in the scope, and further explore the scope if the expression is an object. Using the offset parameter you can get suggestion at the caret position instead of the complete expression value.
	 * @param REFERENCE  (required)
	 * @param value (optional) the expression to check and get suggestion for, or null in order to get scope level suggestions (optional)
	 * @param offset (optionnal) caret position in the expression value in order to provide relevant suggestions based on the caret position. By default the suggestion are based on the full expression if provided, or else the entire bookmark scope. (optional)
	 * @param types (optional) the expression type to filter the suggestions. If undefined all valid expression in the context are returned.  (optional)
	 * @param values (optional) the expression value to filter the suggestions. If undefined all valid expression in the context are returned.  (optional)
	 * @param style define the response style. If HUMAN, the API will try to use natural reference for objects, like &#39;My First Project&#39;, &#39;Account&#39;, &#39;Total Sales&#39;... If MACHINE the API will use canonical references that are invariant, e.g. @&#39;5603ca63c531d744b50823a3bis&#39;. If LEGACY the API will also provide internal compound key to lookup objects in the management API. (optional, default to HUMAN)
	 * @return ApiResponse&lt;Void&gt;
	 * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
	 */
	public ApiResponse<Void> scopeAnalysisWithHttpInfo(String REFERENCE, String value, Integer offset, List<String> types, List<String> values, String style) throws ApiException {
		Call call = scopeAnalysisCall(REFERENCE, value, offset, types, values, style, null, null);
		return getApiClient().execute(call);
	}

	/**
	 * Provide information about the expressions available in the bookmark scope (asynchronously)
	 * It also allows to check if a given expression is valid in the scope, and further explore the scope if the expression is an object. Using the offset parameter you can get suggestion at the caret position instead of the complete expression value.
	 * @param REFERENCE  (required)
	 * @param value (optional) the expression to check and get suggestion for, or null in order to get scope level suggestions (optional)
	 * @param offset (optionnal) caret position in the expression value in order to provide relevant suggestions based on the caret position. By default the suggestion are based on the full expression if provided, or else the entire bookmark scope. (optional)
	 * @param types (optional) the expression type to filter the suggestions. If undefined all valid expression in the context are returned.  (optional)
	 * @param values (optional) the expression value to filter the suggestions. If undefined all valid expression in the context are returned.  (optional)
	 * @param style define the response style. If HUMAN, the API will try to use natural reference for objects, like &#39;My First Project&#39;, &#39;Account&#39;, &#39;Total Sales&#39;... If MACHINE the API will use canonical references that are invariant, e.g. @&#39;5603ca63c531d744b50823a3bis&#39;. If LEGACY the API will also provide internal compound key to lookup objects in the management API. (optional, default to HUMAN)
	 * @param callback The callback to be executed when the API call finishes
	 * @return The request call
	 * @throws ApiException If fail to process the API call, e.g. serializing the request body object
	 */
	public Call scopeAnalysisAsync(String REFERENCE, String value, Integer offset, List<String> types, List<String> values, String style, final ApiCallback<Void> callback) throws ApiException {

		ProgressResponseBody.ProgressListener progressListener = null;
		ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

		if (callback != null) {
			progressListener = new ProgressResponseBody.ProgressListener() {
				@Override
				public void update(long bytesRead, long contentLength, boolean done) {
					callback.onDownloadProgress(bytesRead, contentLength, done);
				}
			};

			progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
				@Override
				public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
					callback.onUploadProgress(bytesWritten, contentLength, done);
				}
			};
		}

		Call call = scopeAnalysisCall(REFERENCE, value, offset, types, values, style, progressListener, progressRequestListener);
		getApiClient().executeAsync(call, callback);
		return call;
	}
	/* Build call for viewAnalysis */
	private Call viewAnalysisCall(String REFERENCE, String x, String y, String color, String size, String column, String row, List<String> groupBy, List<String> metrics, List<String> filters, String period, List<String> timeframe, List<String> compareTo, List<String> orderBy, Long limit, Long offset, List<String> beyondLimit, Integer maxResults, Integer startIndex, String data, String style, String envelope, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
		Object localVarPostBody = null;

		// verify the required parameter 'REFERENCE' is set
		if (REFERENCE == null) {
			throw new ApiException("Missing the required parameter 'REFERENCE' when calling viewAnalysis(Async)");
		}


		// create path and map variables
		String localVarPath = "/analytics/{REFERENCE}/view".replaceAll("\\{format\\}","json")
				.replaceAll("\\{" + "REFERENCE" + "\\}", getApiClient().escapeString(REFERENCE.toString()));

		List<Pair> localVarQueryParams = new ArrayList<Pair>();
		if (x != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "x", x));
		if (y != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "y", y));
		if (color != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "color", color));
		if (size != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "size", size));
		if (column != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "column", column));
		if (row != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "row", row));
		if (groupBy != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("multi", "groupBy", groupBy));
		if (metrics != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("multi", "metrics", metrics));
		if (filters != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("multi", "filters", filters));
		if (period != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "period", period));
		if (timeframe != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("multi", "timeframe", timeframe));
		if (compareTo != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("multi", "compareTo", compareTo));
		if (orderBy != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("multi", "orderBy", orderBy));
		if (limit != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "limit", limit));
		if (offset != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "offset", offset));
		if (beyondLimit != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("multi", "beyondLimit", beyondLimit));
		if (maxResults != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "maxResults", maxResults));
		if (startIndex != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "startIndex", startIndex));
		if (data != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "data", data));
		if (style != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "style", style));
		if (envelope != null)
			localVarQueryParams.addAll(getApiClient().parameterToPairs("", "envelope", envelope));

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
		return getApiClient().buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
	}

	/**
	 * Generate a dataviz specs from a query
	 *
	 * @param REFERENCE  (required)
	 * @param x set the x axis channel. This must be a valid expression or the special alias __PERIOD to refer to the main period. (optional)
	 * @param y set the y axis channel. This must be a valid expression. (optional)
	 * @param color set a series channel, displayed using a color palette. This must be a valid expression. (optional)
	 * @param size set a series channel, displayed using the marker size. This must be a valid expression. (optional)
	 * @param column set a facetted channel, displayed as columns. This must be a valid expression. (optional)
	 * @param row set a facetted channel, displayed as rows. This must be a valid expression. (optional)
	 * @param groupBy Define the facets to group by the results. Facet can be defined using it&#39;s ID or any valid expression. If empty, the subject default parameters will apply. You can use the * token to extend the subject default parameters. (optional)
	 * @param metrics Define the metrics to compute. Metric can be defined using it&#39;s ID or any valid expression. If empty, the subject default parameters will apply. You can use the * token to extend the subject default parameters. (optional)
	 * @param filters Define the filters to apply to results. A filter must be a valid conditional expression. If no filter is defined, the subject default filters will be applied. You can use the * token to extend the subject default filters instead of replacing. (optional)
	 * @param period the period defines a dimension or expression of a type date that is used to restrict the timeframe. You can use the __PERIOD expression as a alias to it in other parameters (e.g.: groupBy,orderBy...). (optional)
	 * @param timeframe the timeframe defines the period range to filter. You can use an array of two dates for lower/upper bounds (inclusive). Or some alias like __ALL, __LAST_DAY, __LAST_7_DAYS, __CURRENT_MONTH, __PREVIOUS_MONTH, __CURRENT_YEAR, __PREVIOOUS_YEAR (optional)
	 * @param compareTo Activate and define the compare to period. You can use an array of two dates for lower/upper bounds (inclusive). Or some alias like __COMPARE_TO_PREVIOUS_PERIOD, __COMPARE_TO_PREVIOUS_MONTH, __COMPARE_TO_PREVIOOUS_YEAR (optional)
	 * @param orderBy Define how to sort the results. You can specify a column neither by it&#39;s index (starting at zero by groupBy, then metrics), or using an expression. Use the function DESC() and ASC() to modify the sort order. The expression must be a column, or at least a hierarchical parent of a column (in that case a groupBy may be added automatically to the query). (optional)
	 * @param limit limit the resultset size as computed by the database. Note that this is independent from the paging size defined by maxResults. (optional)
	 * @param offset offset the resultset first row - usually used with limit to paginate the database. Note that this is independent from the paging defined by startIndex. (optional)
	 * @param beyondLimit exclude some dimensions from the limit (optional)
	 * @param maxResults paging size (optional)
	 * @param startIndex paging start index (optional)
	 * @param data define how to provide the data, either EMBEDED or through an URL (optional, default to EMBEDED)
	 * @param style define the response style. If HUMAN, the API will try to use natural reference for objects, like &#39;My First Project&#39;, &#39;Account&#39;, &#39;Total Sales&#39;... If MACHINE the API will use canonical references that are invariant, e.g. @&#39;5603ca63c531d744b50823a3bis&#39;. If LEGACY the API will also provide internal compound key to lookup objects in the management API. (optional, default to HUMAN)
	 * @param envelope define the result envelope (optional)
	 * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
	 */
	public void viewAnalysis(String REFERENCE, String x, String y, String color, String size, String column, String row, List<String> groupBy, List<String> metrics, List<String> filters, String period, List<String> timeframe, List<String> compareTo, List<String> orderBy, Long limit, Long offset, List<String> beyondLimit, Integer maxResults, Integer startIndex, String data, String style, String envelope) throws ApiException {
		viewAnalysisWithHttpInfo(REFERENCE, x, y, color, size, column, row, groupBy, metrics, filters, period, timeframe, compareTo, orderBy, limit, offset, beyondLimit, maxResults, startIndex, data, style, envelope);
	}

	/**
	 * Generate a dataviz specs from a query
	 *
	 * @param REFERENCE  (required)
	 * @param x set the x axis channel. This must be a valid expression or the special alias __PERIOD to refer to the main period. (optional)
	 * @param y set the y axis channel. This must be a valid expression. (optional)
	 * @param color set a series channel, displayed using a color palette. This must be a valid expression. (optional)
	 * @param size set a series channel, displayed using the marker size. This must be a valid expression. (optional)
	 * @param column set a facetted channel, displayed as columns. This must be a valid expression. (optional)
	 * @param row set a facetted channel, displayed as rows. This must be a valid expression. (optional)
	 * @param groupBy Define the facets to group by the results. Facet can be defined using it&#39;s ID or any valid expression. If empty, the subject default parameters will apply. You can use the * token to extend the subject default parameters. (optional)
	 * @param metrics Define the metrics to compute. Metric can be defined using it&#39;s ID or any valid expression. If empty, the subject default parameters will apply. You can use the * token to extend the subject default parameters. (optional)
	 * @param filters Define the filters to apply to results. A filter must be a valid conditional expression. If no filter is defined, the subject default filters will be applied. You can use the * token to extend the subject default filters instead of replacing. (optional)
	 * @param period the period defines a dimension or expression of a type date that is used to restrict the timeframe. You can use the __PERIOD expression as a alias to it in other parameters (e.g.: groupBy,orderBy...). (optional)
	 * @param timeframe the timeframe defines the period range to filter. You can use an array of two dates for lower/upper bounds (inclusive). Or some alias like __ALL, __LAST_DAY, __LAST_7_DAYS, __CURRENT_MONTH, __PREVIOUS_MONTH, __CURRENT_YEAR, __PREVIOOUS_YEAR (optional)
	 * @param compareTo Activate and define the compare to period. You can use an array of two dates for lower/upper bounds (inclusive). Or some alias like __COMPARE_TO_PREVIOUS_PERIOD, __COMPARE_TO_PREVIOUS_MONTH, __COMPARE_TO_PREVIOOUS_YEAR (optional)
	 * @param orderBy Define how to sort the results. You can specify a column neither by it&#39;s index (starting at zero by groupBy, then metrics), or using an expression. Use the function DESC() and ASC() to modify the sort order. The expression must be a column, or at least a hierarchical parent of a column (in that case a groupBy may be added automatically to the query). (optional)
	 * @param limit limit the resultset size as computed by the database. Note that this is independent from the paging size defined by maxResults. (optional)
	 * @param offset offset the resultset first row - usually used with limit to paginate the database. Note that this is independent from the paging defined by startIndex. (optional)
	 * @param beyondLimit exclude some dimensions from the limit (optional)
	 * @param maxResults paging size (optional)
	 * @param startIndex paging start index (optional)
	 * @param data define how to provide the data, either EMBEDED or through an URL (optional, default to EMBEDED)
	 * @param style define the response style. If HUMAN, the API will try to use natural reference for objects, like &#39;My First Project&#39;, &#39;Account&#39;, &#39;Total Sales&#39;... If MACHINE the API will use canonical references that are invariant, e.g. @&#39;5603ca63c531d744b50823a3bis&#39;. If LEGACY the API will also provide internal compound key to lookup objects in the management API. (optional, default to HUMAN)
	 * @param envelope define the result envelope (optional)
	 * @return ApiResponse&lt;Void&gt;
	 * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
	 */
	public ApiResponse<Void> viewAnalysisWithHttpInfo(String REFERENCE, String x, String y, String color, String size, String column, String row, List<String> groupBy, List<String> metrics, List<String> filters, String period, List<String> timeframe, List<String> compareTo, List<String> orderBy, Long limit, Long offset, List<String> beyondLimit, Integer maxResults, Integer startIndex, String data, String style, String envelope) throws ApiException {
		Call call = viewAnalysisCall(REFERENCE, x, y, color, size, column, row, groupBy, metrics, filters, period, timeframe, compareTo, orderBy, limit, offset, beyondLimit, maxResults, startIndex, data, style, envelope, null, null);
		return getApiClient().execute(call);
	}

	/**
	 * Generate a dataviz specs from a query (asynchronously)
	 *
	 * @param REFERENCE  (required)
	 * @param x set the x axis channel. This must be a valid expression or the special alias __PERIOD to refer to the main period. (optional)
	 * @param y set the y axis channel. This must be a valid expression. (optional)
	 * @param color set a series channel, displayed using a color palette. This must be a valid expression. (optional)
	 * @param size set a series channel, displayed using the marker size. This must be a valid expression. (optional)
	 * @param column set a facetted channel, displayed as columns. This must be a valid expression. (optional)
	 * @param row set a facetted channel, displayed as rows. This must be a valid expression. (optional)
	 * @param groupBy Define the facets to group by the results. Facet can be defined using it&#39;s ID or any valid expression. If empty, the subject default parameters will apply. You can use the * token to extend the subject default parameters. (optional)
	 * @param metrics Define the metrics to compute. Metric can be defined using it&#39;s ID or any valid expression. If empty, the subject default parameters will apply. You can use the * token to extend the subject default parameters. (optional)
	 * @param filters Define the filters to apply to results. A filter must be a valid conditional expression. If no filter is defined, the subject default filters will be applied. You can use the * token to extend the subject default filters instead of replacing. (optional)
	 * @param period the period defines a dimension or expression of a type date that is used to restrict the timeframe. You can use the __PERIOD expression as a alias to it in other parameters (e.g.: groupBy,orderBy...). (optional)
	 * @param timeframe the timeframe defines the period range to filter. You can use an array of two dates for lower/upper bounds (inclusive). Or some alias like __ALL, __LAST_DAY, __LAST_7_DAYS, __CURRENT_MONTH, __PREVIOUS_MONTH, __CURRENT_YEAR, __PREVIOOUS_YEAR (optional)
	 * @param compareTo Activate and define the compare to period. You can use an array of two dates for lower/upper bounds (inclusive). Or some alias like __COMPARE_TO_PREVIOUS_PERIOD, __COMPARE_TO_PREVIOUS_MONTH, __COMPARE_TO_PREVIOOUS_YEAR (optional)
	 * @param orderBy Define how to sort the results. You can specify a column neither by it&#39;s index (starting at zero by groupBy, then metrics), or using an expression. Use the function DESC() and ASC() to modify the sort order. The expression must be a column, or at least a hierarchical parent of a column (in that case a groupBy may be added automatically to the query). (optional)
	 * @param limit limit the resultset size as computed by the database. Note that this is independent from the paging size defined by maxResults. (optional)
	 * @param offset offset the resultset first row - usually used with limit to paginate the database. Note that this is independent from the paging defined by startIndex. (optional)
	 * @param beyondLimit exclude some dimensions from the limit (optional)
	 * @param maxResults paging size (optional)
	 * @param startIndex paging start index (optional)
	 * @param data define how to provide the data, either EMBEDED or through an URL (optional, default to EMBEDED)
	 * @param style define the response style. If HUMAN, the API will try to use natural reference for objects, like &#39;My First Project&#39;, &#39;Account&#39;, &#39;Total Sales&#39;... If MACHINE the API will use canonical references that are invariant, e.g. @&#39;5603ca63c531d744b50823a3bis&#39;. If LEGACY the API will also provide internal compound key to lookup objects in the management API. (optional, default to HUMAN)
	 * @param envelope define the result envelope (optional)
	 * @param callback The callback to be executed when the API call finishes
	 * @return The request call
	 * @throws ApiException If fail to process the API call, e.g. serializing the request body object
	 */
	public Call viewAnalysisAsync(String REFERENCE, String x, String y, String color, String size, String column, String row, List<String> groupBy, List<String> metrics, List<String> filters, String period, List<String> timeframe, List<String> compareTo, List<String> orderBy, Long limit, Long offset, List<String> beyondLimit, Integer maxResults, Integer startIndex, String data, String style, String envelope, final ApiCallback<Void> callback) throws ApiException {

		ProgressResponseBody.ProgressListener progressListener = null;
		ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

		if (callback != null) {
			progressListener = new ProgressResponseBody.ProgressListener() {
				@Override
				public void update(long bytesRead, long contentLength, boolean done) {
					callback.onDownloadProgress(bytesRead, contentLength, done);
				}
			};

			progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
				@Override
				public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
					callback.onUploadProgress(bytesWritten, contentLength, done);
				}
			};
		}

		Call call = viewAnalysisCall(REFERENCE, x, y, color, size, column, row, groupBy, metrics, filters, period, timeframe, compareTo, orderBy, limit, offset, beyondLimit, maxResults, startIndex, data, style, envelope, progressListener, progressRequestListener);
		getApiClient().executeAsync(call, callback);
		return call;
	}
}
