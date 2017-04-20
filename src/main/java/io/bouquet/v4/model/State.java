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

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class State extends VersionedBase  {

	private StatePK id = null;
	private List<AccessRight> accessRights = new ArrayList<AccessRight>();
	private Long creationTime = null;
	private String shortcutId = null;
	private String config = null;
	private String oid = null;
	private String objectType = null;

	/**
	 * The object Composite Id (Primary Key)
	 **/
	public State id(StatePK id) {
		this.id = id;
		return this;
	}

	@ApiModelProperty(example = "null", value = "The object Composite Id (Primary Key)")
	@JsonProperty("id")
	public StatePK getId() {
		return id;
	}
	public void setId(StatePK id) {
		this.id = id;
	}


	/**
	 * The ACL for this object
	 **/
	public State accessRights(List<AccessRight> accessRights) {
		this.accessRights = accessRights;
		return this;
	}

	@ApiModelProperty(example = "null", value = "The ACL for this object")
	@JsonProperty("accessRights")
	public List<AccessRight> getAccessRights() {
		return accessRights;
	}
	public void setAccessRights(List<AccessRight> accessRights) {
		this.accessRights = accessRights;
	}


	/**
	 **/
	public State creationTime(Long creationTime) {
		this.creationTime = creationTime;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("creationTime")
	public Long getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Long creationTime) {
		this.creationTime = creationTime;
	}


	/**
	 **/
	public State shortcutId(String shortcutId) {
		this.shortcutId = shortcutId;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("shortcutId")
	public String getShortcutId() {
		return shortcutId;
	}
	public void setShortcutId(String shortcutId) {
		this.shortcutId = shortcutId;
	}


	/**
	 **/
	public State config(String config) {
		this.config = config;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("config")
	public String getConfig() {
		return config;
	}
	public void setConfig(String config) {
		this.config = config;
	}


	@ApiModelProperty(example = "null", value = "The Object Id")
	@JsonProperty("oid")
	public String getOid() {
		return oid;
	}


	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("objectType")
	public String getObjectType() {
		return objectType;
	}

}

