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

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * There is a custom deserializer in Jackson Factory if you have to add new fields
 * Col
 */
public class Col {

	public static enum Role {
		DOMAIN, DATA
	};

	/**
	 * Gets or Sets originType
	 */
	public static enum OriginType {
		@SerializedName("USER")
		USER("USER"),

		@SerializedName("ROLLUP")
		ROLLUP("ROLLUP"),

		@SerializedName("COMPARETO")
		COMPARETO("COMPARETO"),

		@SerializedName("GROWTH")
		GROWTH("GROWTH");

		private String value;

		OriginType(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}

	@SerializedName("name")
	private String name = null;

	@SerializedName("definition")
	private String definition = null;

	@SerializedName("extendedType")
	private ExtendedType extendedType = null;

	private BasePK pk;

	@SerializedName("originType")
	private OriginType originType = null;

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

	@SerializedName("role")
	private Role role;

	/**
	 * There is a custom deserializer in Jackson Factory if you have to add new fields
	 */
	public Col() {

	}

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

	public Col originType(OriginType originType) {
		this.originType = originType;
		return this;
	}

	/**
	 * Get originType
	 * @return originType
	 **/
	@ApiModelProperty(example = "null", value = "")
	public OriginType getOriginType() {
		return originType;
	}

	public void setOriginType(OriginType originType) {
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

	public BasePK getPk() {
		return pk;
	}

	public void setPk(BasePK pk) {
		this.pk = pk;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
