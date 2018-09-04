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

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * FacetMemberString
 */

@JsonTypeName("v")
public class FacetMemberString extends FacetMember  {
	@SerializedName("id")
	private String id = null;

	@SerializedName("value")
	private String value = null;

	@SerializedName("attributes")
	private Map<String, String> attributes = new HashMap<String, String>();

	public FacetMemberString id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * @return id
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public FacetMemberString value(String value) {
		this.value = value;
		return this;
	}

	/**
	 * Get value
	 * @return value
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public FacetMemberString attributes(Map<String, String> attributes) {
		this.attributes = attributes;
		return this;
	}

	public FacetMemberString putAttributesItem(String key, String attributesItem) {
		this.attributes.put(key, attributesItem);
		return this;
	}

	/**
	 * Get attributes
	 * @return attributes
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}
}

