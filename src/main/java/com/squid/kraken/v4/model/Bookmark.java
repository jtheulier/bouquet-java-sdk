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

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * Bookmark
 */

public class Bookmark extends DynamicObject<BookmarkPK> {

	@SerializedName("accessRights")
	private List<AccessRight> accessRights = new ArrayList<AccessRight>();

	@SerializedName("description")
	private String description = null;

	@SerializedName("path")
	private String path = null;

	@SerializedName("config")
	private BookmarkConfig config = null;

	@SerializedName("reference")
	private String reference = null;

	@SerializedName("objectType")
	private String objectType = null;

	@SerializedName("name")
	private String name = null;

	public Bookmark accessRights(List<AccessRight> accessRights) {
		this.accessRights = accessRights;
		return this;
	}

	public Bookmark addAccessRightsItem(AccessRight accessRightsItem) {
		this.accessRights.add(accessRightsItem);
		return this;
	}

	/**
	 * The ACL for this object
	 * @return accessRights
	 **/
	@ApiModelProperty(example = "null", value = "The ACL for this object")
	public List<AccessRight> getAccessRights() {
		return accessRights;
	}

	public void setAccessRights(List<AccessRight> accessRights) {
		this.accessRights = accessRights;
	}

	public Bookmark description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Get description
	 * @return description
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Bookmark path(String path) {
		this.path = path;
		return this;
	}

	/**
	 * Get path
	 * @return path
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Bookmark config(BookmarkConfig config) {
		this.config = config;
		return this;
	}

	/**
	 * Get config
	 * @return config
	 **/
	@ApiModelProperty(example = "null", value = "")
	public BookmarkConfig getConfig() {
		return config;
	}

	public void setConfig(BookmarkConfig config) {
		this.config = config;
	}

	public Bookmark reference(String reference) {
		this.reference = reference;
		return this;
	}

	/**
	 * Get reference
	 * @return reference
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * Get objectType
	 * @return objectType
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getObjectType() {
		return objectType;
	}

	public Bookmark name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Get name
	 * @return name
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

