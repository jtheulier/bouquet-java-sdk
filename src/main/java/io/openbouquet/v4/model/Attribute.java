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
 * Attribute
 */

public class Attribute extends Base  {
	@SerializedName("id")
	private AttributePK id = null;

	@SerializedName("accessRights")
	private List<AccessRight> accessRights = new ArrayList<AccessRight>();

	@SerializedName("description")
	private String description = null;

	@SerializedName("expression")
	private Expression expression = null;

	@SerializedName("oid")
	private String oid = null;

	@SerializedName("objectType")
	private String objectType = null;

	/**
	 * The role of the current User (passed in the context) over this object
	 */
	public enum RoleEnum {
		@SerializedName("NONE")
		NONE("NONE"),

		@SerializedName("EXECUTE")
		EXECUTE("EXECUTE"),

		@SerializedName("READ")
		READ("READ"),

		@SerializedName("WRITE")
		WRITE("WRITE"),

		@SerializedName("OWNER")
		OWNER("OWNER");

		private String value;

		RoleEnum(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}

	@SerializedName("_role")
	private RoleEnum role = null;

	@SerializedName("_vctrl")
	private Integer vctrl = null;

	@SerializedName("name")
	private String name = null;

	public Attribute id(AttributePK id) {
		this.id = id;
		return this;
	}

	/**
	 * The object Composite Id (Primary Key)
	 * @return id
	 **/
	@ApiModelProperty(example = "null", value = "The object Composite Id (Primary Key)")
	public AttributePK getId() {
		return id;
	}

	public void setId(AttributePK id) {
		this.id = id;
	}

	public Attribute accessRights(List<AccessRight> accessRights) {
		this.accessRights = accessRights;
		return this;
	}

	public Attribute addAccessRightsItem(AccessRight accessRightsItem) {
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

	public Attribute description(String description) {
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

	public Attribute expression(Expression expression) {
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

	/**
	 * The role of the current User (passed in the context) over this object
	 * @return role
	 **/
	@ApiModelProperty(example = "null", value = "The role of the current User (passed in the context) over this object")
	public RoleEnum getRole() {
		return role;
	}

	public Attribute vctrl(Integer vctrl) {
		this.vctrl = vctrl;
		return this;
	}

	/**
	 * Internal version control value. (used by optimistic-locking mechanism)
	 * @return vctrl
	 **/
	@ApiModelProperty(example = "null", value = "Internal version control value. (used by optimistic-locking mechanism)")
	public Integer getVctrl() {
		return vctrl;
	}

	public void setVctrl(Integer vctrl) {
		this.vctrl = vctrl;
	}

	public Attribute name(String name) {
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

