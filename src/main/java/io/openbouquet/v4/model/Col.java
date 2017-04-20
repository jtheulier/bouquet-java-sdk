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
 * Col
 */

public class Col extends VersionedBase  {

	@SerializedName("name")
	private String name = null;

	@SerializedName("definition")
	private String definition = null;

	@SerializedName("extendedType")
	private ExtendedType extendedType = null;

	/**
	 * Gets or Sets originType
	 */
	public enum OriginTypeEnum {
		@SerializedName("USER")
		USER("USER"),

		@SerializedName("ROLLUP")
		ROLLUP("ROLLUP"),

		@SerializedName("COMPARETO")
		COMPARETO("COMPARETO"),

		@SerializedName("GROWTH")
		GROWTH("GROWTH");

		private String value;

		OriginTypeEnum(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}

	@SerializedName("originType")
	private OriginTypeEnum originType = null;

	@SerializedName("description")
	private String description = null;

	@SerializedName("format")
	private String format = null;

	@SerializedName("pos")
	private Integer pos = null;

	@SerializedName("lname")
	private String lname = null;

	@SerializedName("id")
	private String id = null;

	public Col name(String name) {
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

	public Col definition(String definition) {
		this.definition = definition;
		return this;
	}

	/**
	 * Get definition
	 * @return definition
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public Col extendedType(ExtendedType extendedType) {
		this.extendedType = extendedType;
		return this;
	}

	/**
	 * Get extendedType
	 * @return extendedType
	 **/
	@ApiModelProperty(example = "null", value = "")
	public ExtendedType getExtendedType() {
		return extendedType;
	}

	public void setExtendedType(ExtendedType extendedType) {
		this.extendedType = extendedType;
	}

	public Col originType(OriginTypeEnum originType) {
		this.originType = originType;
		return this;
	}

	/**
	 * Get originType
	 * @return originType
	 **/
	@ApiModelProperty(example = "null", value = "")
	public OriginTypeEnum getOriginType() {
		return originType;
	}

	public void setOriginType(OriginTypeEnum originType) {
		this.originType = originType;
	}

	public Col description(String description) {
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

	public Col format(String format) {
		this.format = format;
		return this;
	}

	/**
	 * Get format
	 * @return format
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public Col pos(Integer pos) {
		this.pos = pos;
		return this;
	}

	/**
	 * Get pos
	 * @return pos
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Integer getPos() {
		return pos;
	}

	public void setPos(Integer pos) {
		this.pos = pos;
	}

	public Col lname(String lname) {
		this.lname = lname;
		return this;
	}

	/**
	 * Get lname
	 * @return lname
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Col id(String id) {
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
}

