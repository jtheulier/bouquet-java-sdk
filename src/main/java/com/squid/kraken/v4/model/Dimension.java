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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * Dimension
 */

public class Dimension extends DynamicObject<DimensionPK> {

	@SerializedName("accessRights")
	private List<AccessRight> accessRights = new ArrayList<AccessRight>();

	@SerializedName("description")
	private String description = null;

	@SerializedName("displayFormat")
	private String displayFormat = null;

	/**
	 * Gets or Sets type
	 */
	public enum TypeEnum {
		@SerializedName("CATEGORICAL")
		CATEGORICAL("CATEGORICAL"),

		@SerializedName("CONTINUOUS")
		CONTINUOUS("CONTINUOUS"),

		@SerializedName("INDEX")
		INDEX("INDEX"),

		@SerializedName("SEGMENTS")
		SEGMENTS("SEGMENTS");

		private String value;

		TypeEnum(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}

	@SerializedName("type")
	private TypeEnum type = null;

	@SerializedName("expression")
	private Expression expression = null;

	@SerializedName("parentId")
	private DimensionPK parentId = null;

	@SerializedName("options")
	private List<DimensionOption> options = new ArrayList<DimensionOption>();

	@SerializedName("visible")
	private Boolean visible = false;

	@SerializedName("attributes")
	private List<Attribute> attributes = new ArrayList<Attribute>();

	/**
	 * Gets or Sets valueType
	 */
	public enum ValueTypeEnum {
		@SerializedName("OBJECT")
		OBJECT("OBJECT"),

		@SerializedName("NUMERIC")
		NUMERIC("NUMERIC"),

		@SerializedName("AGGREGATE")
		AGGREGATE("AGGREGATE"),

		@SerializedName("DATE")
		DATE("DATE"),

		@SerializedName("STRING")
		STRING("STRING"),

		@SerializedName("CONDITION")
		CONDITION("CONDITION"),

		@SerializedName("LINK")
		LINK("LINK"),

		@SerializedName("TABLE")
		TABLE("TABLE"),

		@SerializedName("VIEW")
		VIEW("VIEW"),

		@SerializedName("DOMAIN")
		DOMAIN("DOMAIN"),

		@SerializedName("OTHER")
		OTHER("OTHER"),

		@SerializedName("ERROR")
		ERROR("ERROR");

		private String value;

		ValueTypeEnum(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}

	@SerializedName("valueType")
	private ValueTypeEnum valueType = null;

	@SerializedName("objectType")
	private String objectType = null;

	@SerializedName("_children")
	@JsonProperty("_children")
	private List<String> children = new ArrayList<String>();

	@SerializedName("name")
	private String name = null;

	public Dimension accessRights(List<AccessRight> accessRights) {
		this.accessRights = accessRights;
		return this;
	}

	public Dimension addAccessRightsItem(AccessRight accessRightsItem) {
		this.accessRights.add(accessRightsItem);
		return this;
	}

	/**
	 * The ACL for this object
	 *
	 * @return accessRights
	 **/
	@ApiModelProperty(example = "null", value = "The ACL for this object")
	public List<AccessRight> getAccessRights() {
		return accessRights;
	}

	public void setAccessRights(List<AccessRight> accessRights) {
		this.accessRights = accessRights;
	}

	public Dimension description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Get description
	 *
	 * @return description
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Dimension type(TypeEnum type) {
		this.type = type;
		return this;
	}

	/**
	 * Get type
	 *
	 * @return type
	 **/
	@ApiModelProperty(example = "null", value = "")
	public TypeEnum getType() {
		return type;
	}

	public void setType(TypeEnum type) {
		this.type = type;
	}

	public Dimension expression(Expression expression) {
		this.expression = expression;
		return this;
	}

	/**
	 * Get expression
	 *
	 * @return expression
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	public Dimension parentId(DimensionPK parentId) {
		this.parentId = parentId;
		return this;
	}

	/**
	 * Get parentId
	 *
	 * @return parentId
	 **/
	@ApiModelProperty(example = "null", value = "")
	public DimensionPK getParentId() {
		return parentId;
	}

	public void setParentId(DimensionPK parentId) {
		this.parentId = parentId;
	}

	public Dimension options(List<DimensionOption> options) {
		this.options = options;
		return this;
	}

	public Dimension addOptionsItem(DimensionOption optionsItem) {
		this.options.add(optionsItem);
		return this;
	}

	/**
	 * Get options
	 *
	 * @return options
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<DimensionOption> getOptions() {
		return options;
	}

	public void setOptions(List<DimensionOption> options) {
		this.options = options;
	}

	public Dimension visible(Boolean visible) {
		this.visible = visible;
		return this;
	}

	/**
	 * Get visible
	 *
	 * @return visible
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Boolean isVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public Dimension attributes(List<Attribute> attributes) {
		this.attributes = attributes;
		return this;
	}

	public Dimension addAttributesItem(Attribute attributesItem) {
		this.attributes.add(attributesItem);
		return this;
	}

	/**
	 * Get attributes
	 *
	 * @return attributes
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}

	public Dimension valueType(ValueTypeEnum valueType) {
		this.valueType = valueType;
		return this;
	}

	/**
	 * Get valueType
	 *
	 * @return valueType
	 **/
	@ApiModelProperty(example = "null", value = "")
	public ValueTypeEnum getValueType() {
		return valueType;
	}

	public void setValueType(ValueTypeEnum valueType) {
		this.valueType = valueType;
	}

	/**
	 * Get objectType
	 *
	 * @return objectType
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getObjectType() {
		return objectType;
	}

	public Dimension children(List<String> children) {
		this.children = children;
		return this;
	}

	public Dimension addChildrenItem(String childrenItem) {
		this.children.add(childrenItem);
		return this;
	}

	/**
	 * Get children
	 *
	 * @return children
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<String> getChildren() {
		return children;
	}

	public void setChildren(List<String> children) {
		this.children = children;
	}

	public Dimension name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Get name
	 *
	 * @return name
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayFormat() {
		return displayFormat;
	}

	public void setDisplayFormat(String displayFormat) {
		this.displayFormat = displayFormat;
	}
}
