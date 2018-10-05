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
package io.bouquet.v4;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiException extends Exception {
	/**
	 * 
	 */
	static public enum ApiError {
	DUPLICATE_LOGIN, DUPLICATE_EMAIL, PASSWORD_REQUIRED, PASSWORD_INVALID_SIZE, PASSWORD_INVALID_CHAR, PASSWORD_INVALID_RULES, COMPUTING_IN_PROGRESS, COMPUTING_FAILED, NOT_IN_CACHE, CONCURRENT_MODIFICATION
	};

	private ApiError apiError;

	private static final long serialVersionUID = 331264493464766708L;

	@JsonProperty("code")
	private int statusCode = 400;

	private String type = null;

	private String redirectURL = null;

	private String clientId = null;

	public ApiException() {
	}

	public ApiException(int statusCode, String message) {
		super(message);
		this.statusCode = statusCode;
	}

	public ApiException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApiException(int statusCode, String message, Throwable cause) {
		super(message, cause);
		this.statusCode = statusCode;
	}

	public ApiException(String message) {
		super(message);
	}

	public ApiException(Throwable cause) {
		super(cause);
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int code) {
		this.statusCode = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRedirectURL() {
		return redirectURL;
	}

	public void setRedirectURL(String redirectURL) {
		this.redirectURL = redirectURL;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public ApiError getApiError() {
		return apiError;
	}

	public void setApiError(ApiError apiError) {
		this.apiError = apiError;
	}

}
