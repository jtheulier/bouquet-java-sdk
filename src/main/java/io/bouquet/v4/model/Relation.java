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

import java.beans.Expression;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * Relation
 */

public class Relation extends DynamicObject  {
	@SerializedName("id")
	private RelationPK id = null;

	@SerializedName("accessRights")
	private List<AccessRight> accessRights = new ArrayList<AccessRight>();

	@SerializedName("description")
	private String description = null;

	@SerializedName("leftId")
	private DomainPK leftId = null;

	/**
	 * Gets or Sets leftCardinality
	 */
	public enum LeftCardinalityEnum {
		@SerializedName("ZERO_OR_ONE")
		ZERO_OR_ONE("ZERO_OR_ONE"),

		@SerializedName("ONE")
		ONE("ONE"),

		@SerializedName("MANY")
		MANY("MANY");

		private String value;

		LeftCardinalityEnum(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}

	@SerializedName("leftCardinality")
	private LeftCardinalityEnum leftCardinality = null;

	@SerializedName("rightId")
	private DomainPK rightId = null;

	/**
	 * Gets or Sets rightCardinality
	 */
	public enum RightCardinalityEnum {
		@SerializedName("ZERO_OR_ONE")
		ZERO_OR_ONE("ZERO_OR_ONE"),

		@SerializedName("ONE")
		ONE("ONE"),

		@SerializedName("MANY")
		MANY("MANY");

		private String value;

		RightCardinalityEnum(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}

	@SerializedName("rightCardinality")
	private RightCardinalityEnum rightCardinality = null;

	@SerializedName("leftName")
	private String leftName = null;

	@SerializedName("rightName")
	private String rightName = null;

	@SerializedName("joinExpression")
	private Expression joinExpression = null;

	@SerializedName("oid")
	private String oid = null;

	@SerializedName("objectType")
	private String objectType = null;


	@SerializedName("name")
	private String name = null;

	public Relation id(RelationPK id) {
		this.id = id;
		return this;
	}

	/**
	 * The object Composite Id (Primary Key)
	 * @return id
	 **/
	@ApiModelProperty(example = "null", value = "The object Composite Id (Primary Key)")
	public RelationPK getId() {
		return id;
	}

	public void setId(RelationPK id) {
		this.id = id;
	}

	public Relation accessRights(List<AccessRight> accessRights) {
		this.accessRights = accessRights;
		return this;
	}

	public Relation addAccessRightsItem(AccessRight accessRightsItem) {
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

	public Relation description(String description) {
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

	public Relation leftId(DomainPK leftId) {
		this.leftId = leftId;
		return this;
	}

	/**
	 * Get leftId
	 * @return leftId
	 **/
	@ApiModelProperty(example = "null", value = "")
	public DomainPK getLeftId() {
		return leftId;
	}

	public void setLeftId(DomainPK leftId) {
		this.leftId = leftId;
	}

	public Relation leftCardinality(LeftCardinalityEnum leftCardinality) {
		this.leftCardinality = leftCardinality;
		return this;
	}

	/**
	 * Get leftCardinality
	 * @return leftCardinality
	 **/
	@ApiModelProperty(example = "null", value = "")
	public LeftCardinalityEnum getLeftCardinality() {
		return leftCardinality;
	}

	public void setLeftCardinality(LeftCardinalityEnum leftCardinality) {
		this.leftCardinality = leftCardinality;
	}

	public Relation rightId(DomainPK rightId) {
		this.rightId = rightId;
		return this;
	}

	/**
	 * Get rightId
	 * @return rightId
	 **/
	@ApiModelProperty(example = "null", value = "")
	public DomainPK getRightId() {
		return rightId;
	}

	public void setRightId(DomainPK rightId) {
		this.rightId = rightId;
	}

	public Relation rightCardinality(RightCardinalityEnum rightCardinality) {
		this.rightCardinality = rightCardinality;
		return this;
	}

	/**
	 * Get rightCardinality
	 * @return rightCardinality
	 **/
	@ApiModelProperty(example = "null", value = "")
	public RightCardinalityEnum getRightCardinality() {
		return rightCardinality;
	}

	public void setRightCardinality(RightCardinalityEnum rightCardinality) {
		this.rightCardinality = rightCardinality;
	}

	public Relation leftName(String leftName) {
		this.leftName = leftName;
		return this;
	}

	/**
	 * Get leftName
	 * @return leftName
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getLeftName() {
		return leftName;
	}

	public void setLeftName(String leftName) {
		this.leftName = leftName;
	}

	public Relation rightName(String rightName) {
		this.rightName = rightName;
		return this;
	}

	/**
	 * Get rightName
	 * @return rightName
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getRightName() {
		return rightName;
	}

	public void setRightName(String rightName) {
		this.rightName = rightName;
	}

	public Relation joinExpression(Expression joinExpression) {
		this.joinExpression = joinExpression;
		return this;
	}

	/**
	 * Get joinExpression
	 * @return joinExpression
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Expression getJoinExpression() {
		return joinExpression;
	}

	public void setJoinExpression(Expression joinExpression) {
		this.joinExpression = joinExpression;
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

	public Relation name(String name) {
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

