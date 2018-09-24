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
package com.squid.kraken.v4.model;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class ApiKey extends ModelBase<ApiKeyPK> {

	private List<AccessRight> accessRights = new ArrayList<AccessRight>();

	private String objectType = null;
	private String clientId;
	private String userId;
	private String assertion;
	private String tokenUrl;
	private long expirationDateMillis;
	private long lastUsedDate;
	private long createdDate;

	/**
	 * The ACL for this object
	 **/
	public ApiKey accessRights(List<AccessRight> accessRights) {
		this.accessRights = accessRights;
		return this;
	}

	@ApiModelProperty(example = "null", value = "The ACL for this object")
	public List<AccessRight> getAccessRights() {
		return accessRights;
	}

	public void setAccessRights(List<AccessRight> accessRights) {
		this.accessRights = accessRights;
	}

	/**
	 **/
	public ApiKey clientId(String clientId) {
		this.clientId = clientId;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 **/
	public ApiKey assertion(String assertion) {
		this.assertion = assertion;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	public String getAssertion() {
		return assertion;
	}

	public void setAssertion(String assertion) {
		this.assertion = assertion;
	}

	/**
	 **/
	public ApiKey tokenUrl(String tokenUrl) {
		this.tokenUrl = tokenUrl;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	public String getTokenUrl() {
		return tokenUrl;
	}

	public void setTokenUrl(String tokenUrl) {
		this.tokenUrl = tokenUrl;
	}

	/**
	 **/
	public ApiKey expirationDateMillis(long expirationDateMillis) {
		this.expirationDateMillis = expirationDateMillis;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	public long getExpirationDateMillis() {
		return expirationDateMillis;
	}

	public void setExpirationDateMillis(long expirationDateMillis) {
		this.expirationDateMillis = expirationDateMillis;
	}

	/**
	 **/
	public ApiKey lastUsedDate(long lastUsedDate) {
		this.lastUsedDate = lastUsedDate;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	public long getLastUsedDate() {
		return lastUsedDate;
	}

	public void setLastUsedDate(long lastUsedDate) {
		this.lastUsedDate = lastUsedDate;
	}

	@ApiModelProperty(example = "null", value = "")
	public String getObjectType() {
		return objectType;
	}

	/**
	 **/
	public ApiKey createdDate(long createdDate) {
		this.createdDate = createdDate;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	public long getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(long createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 **/
	public ApiKey userId(String userId) {
		this.userId = userId;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	/**
	 * Returns the SSO definition auserIdciated with a client
	 * 
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
