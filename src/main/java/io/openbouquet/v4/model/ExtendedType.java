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
package io.openbouquet.v4.model;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * ExtendedType
 */

public class ExtendedType extends Base  {
	@SerializedName("name")
	private String name = null;

	@SerializedName("dataType")
	private Integer dataType = null;

	@SerializedName("scale")
	private Integer scale = null;

	@SerializedName("size")
	private Integer size = null;

	public ExtendedType name(String name) {
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

	public ExtendedType dataType(Integer dataType) {
		this.dataType = dataType;
		return this;
	}

	/**
	 * Get dataType
	 * @return dataType
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Integer getDataType() {
		return dataType;
	}

	public void setDataType(Integer dataType) {
		this.dataType = dataType;
	}

	public ExtendedType scale(Integer scale) {
		this.scale = scale;
		return this;
	}

	/**
	 * Get scale
	 * @return scale
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Integer getScale() {
		return scale;
	}

	public void setScale(Integer scale) {
		this.scale = scale;
	}

	public ExtendedType size(Integer size) {
		this.size = size;
		return this;
	}

	/**
	 * Get size
	 * @return size
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}
}

