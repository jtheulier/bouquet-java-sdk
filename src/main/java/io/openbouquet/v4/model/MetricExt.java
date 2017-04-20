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

import java.beans.Expression;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * MetricExt
 */

public class MetricExt extends VersionedBase  {
	@SerializedName("id")
	private MetricPK id = null;

	@SerializedName("accessRights")
	private List<AccessRight> accessRights = new ArrayList<AccessRight>();

	@SerializedName("description")
	private String description = null;

	@SerializedName("expression")
	private Expression expression = null;

	@SerializedName("definition")
	private String definition = null;

	@SerializedName("visible")
	private Boolean visible = false;

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

	@SerializedName("dynamic")
	private Boolean dynamic = false;

	@SerializedName("oid")
	private String oid = null;

	@SerializedName("objectType")
	private String objectType = null;

	@SerializedName("name")
	private String name = null;

	public MetricExt id(MetricPK id) {
		this.id = id;
		return this;
	}

	/**
	 * The object Composite Id (Primary Key)
	 * @return id
	 **/
	@ApiModelProperty(example = "null", value = "The object Composite Id (Primary Key)")
	public MetricPK getId() {
		return id;
	}

	public void setId(MetricPK id) {
		this.id = id;
	}

	public MetricExt accessRights(List<AccessRight> accessRights) {
		this.accessRights = accessRights;
		return this;
	}

	public MetricExt addAccessRightsItem(AccessRight accessRightsItem) {
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

	public MetricExt description(String description) {
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

	public MetricExt expression(Expression expression) {
		this.expression = expression;
		return this;
	}

	/**
	 * Get expression
	 * @return expression
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	public MetricExt definition(String definition) {
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

	public MetricExt visible(Boolean visible) {
		this.visible = visible;
		return this;
	}

	/**
	 * Get visible
	 * @return visible
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Boolean isVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public MetricExt valueType(ValueTypeEnum valueType) {
		this.valueType = valueType;
		return this;
	}

	/**
	 * Get valueType
	 * @return valueType
	 **/
	@ApiModelProperty(example = "null", value = "")
	public ValueTypeEnum getValueType() {
		return valueType;
	}

	public void setValueType(ValueTypeEnum valueType) {
		this.valueType = valueType;
	}

	public MetricExt dynamic(Boolean dynamic) {
		this.dynamic = dynamic;
		return this;
	}

	/**
	 * indicates if the object is automatically generated. This property can be updated.
	 * @return dynamic
	 **/
	@ApiModelProperty(example = "null", value = "indicates if the object is automatically generated. This property can be updated.")
	public Boolean isDynamic() {
		return dynamic;
	}

	public void setDynamic(Boolean dynamic) {
		this.dynamic = dynamic;
	}

	/**
	 * The Object Id
	 * @return oid
	 **/
	@ApiModelProperty(example = "null", value = "The Object Id")
	public String getOid() {
		return oid;
	}

	/**
	 * Get objectType
	 * @return objectType
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getObjectType() {
		return objectType;
	}

	public MetricExt name(String name) {
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

