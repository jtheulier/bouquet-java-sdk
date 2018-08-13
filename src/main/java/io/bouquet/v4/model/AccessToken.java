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
package io.bouquet.v4.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

public class AccessToken extends Base  {



	public enum TypeEnum {
		NORMAL("NORMAL"),
		RESET_PWD("RESET_PWD"),
		CODE("CODE"),
		REFRESH("REFRESH");

		private String value;

		TypeEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return value;
		}
	}

	private TypeEnum type = null;
	private Long expirationDateMillis = null;
	private AccessTokenPK id = null;
	private String customerId = null;
	private String userId = null;
	private String clientId = null;
	private String refreshToken = null;
	private String oid = null;
	private String objectType = null;

	@SerializedName("access_token")
	private String accessToken;

	/**
	 **/
	public AccessToken type(TypeEnum type) {
		this.type = type;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("type")
	public TypeEnum getType() {
		return type;
	}
	public void setType(TypeEnum type) {
		this.type = type;
	}


	/**
	 **/
	public AccessToken expirationDateMillis(Long expirationDateMillis) {
		this.expirationDateMillis = expirationDateMillis;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("expirationDateMillis")
	public Long getExpirationDateMillis() {
		return expirationDateMillis;
	}
	public void setExpirationDateMillis(Long expirationDateMillis) {
		this.expirationDateMillis = expirationDateMillis;
	}


	/**
	 * The object Composite Id (Primary Key)
	 **/
	public AccessToken id(AccessTokenPK id) {
		this.id = id;
		return this;
	}

	@ApiModelProperty(example = "null", value = "The object Composite Id (Primary Key)")
	@JsonProperty("id")
	public AccessTokenPK getId() {
		return id;
	}
	public void setId(AccessTokenPK id) {
		this.id = id;
	}


	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("customerId")
	public String getCustomerId() {
		return customerId;
	}


	/**
	 **/
	public AccessToken userId(String userId) {
		this.userId = userId;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("userId")
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}


	/**
	 **/
	public AccessToken clientId(String clientId) {
		this.clientId = clientId;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("clientId")
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}


	/**
	 **/
	public AccessToken refreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("refreshToken")
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}


	/**
	 * The Object Id
	 **/
	public AccessToken oid(String oid) {
		this.oid = oid;
		return this;
	}

	@ApiModelProperty(example = "null", value = "The Object Id")
	@JsonProperty("oid")
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}


	/**
	 **/
	public AccessToken objectType(String objectType) {
		this.objectType = objectType;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("objectType")
	public String getObjectType() {
		return objectType;
	}
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	/**
	 **/
	public AccessToken acccessToken(String accessToken) {
		this.accessToken = accessToken;
		return this;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
}