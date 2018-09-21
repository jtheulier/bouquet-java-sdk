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
 * Domain
 */

public class Domain extends DynamicObject {
	@SerializedName("id")
	private DomainPK id = null;

	@SerializedName("accessRights")
	private List<AccessRight> accessRights = new ArrayList<AccessRight>();

	@SerializedName("description")
	private String description = null;

	@SerializedName("subject")
	private Expression subject = null;

	@SerializedName("internalVersion")
	private Integer internalVersion = null;

	@SerializedName("options")
	private DomainOption options = null;

	@SerializedName("metrics")
	private List<Metric> metrics = new ArrayList<Metric>();

	@SerializedName("dimensions")
	private List<Dimension> dimensions = new ArrayList<Dimension>();

	@SerializedName("oid")
	private String oid = null;

	@SerializedName("objectType")
	private String objectType = null;

	@SerializedName("_children")
	@JsonProperty("_children")
	private List<String> children = new ArrayList<String>();

	@SerializedName("name")
	private String name = null;

	public Domain id(DomainPK id) {
		this.id = id;
		return this;
	}

	/**
	 * The object Composite Id (Primary Key)
	 * 
	 * @return id
	 **/
	@ApiModelProperty(example = "null", value = "The object Composite Id (Primary Key)")
	public DomainPK getId() {
		return id;
	}

	public void setId(DomainPK id) {
		this.id = id;
	}

	public Domain accessRights(List<AccessRight> accessRights) {
		this.accessRights = accessRights;
		return this;
	}

	public Domain addAccessRightsItem(AccessRight accessRightsItem) {
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

	public Domain description(String description) {
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

	public Domain subject(Expression subject) {
		this.subject = subject;
		return this;
	}

	/**
	 * Get subject
	 * 
	 * @return subject
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Expression getSubject() {
		return subject;
	}

	public void setSubject(Expression subject) {
		this.subject = subject;
	}

	public Domain internalVersion(Integer internalVersion) {
		this.internalVersion = internalVersion;
		return this;
	}

	/**
	 * Get internalVersion
	 * 
	 * @return internalVersion
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Integer getInternalVersion() {
		return internalVersion;
	}

	public void setInternalVersion(Integer internalVersion) {
		this.internalVersion = internalVersion;
	}

	public Domain options(DomainOption options) {
		this.options = options;
		return this;
	}

	/**
	 * Get options
	 * 
	 * @return options
	 **/
	@ApiModelProperty(example = "null", value = "")
	public DomainOption getOptions() {
		return options;
	}

	public void setOptions(DomainOption options) {
		this.options = options;
	}

	public Domain metrics(List<Metric> metrics) {
		this.metrics = metrics;
		return this;
	}

	public Domain addMetricsItem(Metric metricsItem) {
		this.metrics.add(metricsItem);
		return this;
	}

	/**
	 * Get metrics
	 * 
	 * @return metrics
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<Metric> getMetrics() {
		return metrics;
	}

	public void setMetrics(List<Metric> metrics) {
		this.metrics = metrics;
	}

	public Domain dimensions(List<Dimension> dimensions) {
		this.dimensions = dimensions;
		return this;
	}

	public Domain addDimensionsItem(Dimension dimensionsItem) {
		this.dimensions.add(dimensionsItem);
		return this;
	}

	/**
	 * Get dimensions
	 * 
	 * @return dimensions
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<Dimension> getDimensions() {
		return dimensions;
	}

	public void setDimensions(List<Dimension> dimensions) {
		this.dimensions = dimensions;
	}

	/**
	 * The Object Id
	 * 
	 * @return oid
	 **/
	@ApiModelProperty(example = "null", value = "The Object Id")
	public String getOid() {
		return oid;
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

	public Domain children(List<String> children) {
		this.children = children;
		return this;
	}

	public Domain addChildrenItem(String childrenItem) {
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

	public Domain name(String name) {
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

}
