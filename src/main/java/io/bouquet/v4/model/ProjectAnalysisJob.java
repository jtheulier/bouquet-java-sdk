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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * ProjectAnalysisJob
 */

public class ProjectAnalysisJob extends VersionedBase  {
	@SerializedName("id")
	private ProjectAnalysisJobPK id = null;

	@SerializedName("accessRights")
	private List<AccessRight> accessRights = new ArrayList<AccessRight>();

	/**
	 * Gets or Sets status
	 */
	public enum StatusEnum {
		@SerializedName("PENDING")
		PENDING("PENDING"),

		@SerializedName("RUNNING")
		RUNNING("RUNNING"),

		@SerializedName("DONE")
		DONE("DONE");

		private String value;

		StatusEnum(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}

	@SerializedName("status")
	private StatusEnum status = null;

	@SerializedName("error")
	private Error error = null;

	@SerializedName("statistics")
	private Statistics statistics = null;

	@SerializedName("resultsSize")
	private Long resultsSize = null;

	@SerializedName("temporary")
	private Boolean temporary = false;

	@SerializedName("autoRun")
	private Boolean autoRun = false;

	@SerializedName("creationTime")
	private Long creationTime = null;

	@SerializedName("domains")
	private List<DomainPK> domains = new ArrayList<DomainPK>();

	@SerializedName("dimensions")
	private List<DimensionPK> dimensions = new ArrayList<DimensionPK>();

	@SerializedName("metrics")
	private List<MetricPK> metrics = new ArrayList<MetricPK>();

	@SerializedName("metricList")
	private List<Metric> metricList = new ArrayList<Metric>();

	@SerializedName("facets")
	private List<Expression> facets = new ArrayList<Expression>();

	@SerializedName("rollups")
	private List<RollUp> rollups = new ArrayList<RollUp>();

	@SerializedName("selection")
	private FacetSelection selection = null;

	@SerializedName("orderBy")
	private List<OrderBy> orderBy = new ArrayList<OrderBy>();

	@SerializedName("offset")
	private Long offset = null;

	@SerializedName("limit")
	private Long limit = null;

	@SerializedName("beyondLimit")
	private List<Index> beyondLimit = new ArrayList<Index>();

	@SerializedName("optionKeys")
	private Map<String, Object> optionKeys = new HashMap<String, Object>();

	@SerializedName("results")
	private DataTable results = null;

	@SerializedName("oid")
	private String oid = null;

	@SerializedName("objectType")
	private String objectType = null;


	public ProjectAnalysisJob id(ProjectAnalysisJobPK id) {
		this.id = id;
		return this;
	}

	/**
	 * The object Composite Id (Primary Key)
	 * @return id
	 **/
	@ApiModelProperty(example = "null", value = "The object Composite Id (Primary Key)")
	public ProjectAnalysisJobPK getId() {
		return id;
	}

	public void setId(ProjectAnalysisJobPK id) {
		this.id = id;
	}

	public ProjectAnalysisJob accessRights(List<AccessRight> accessRights) {
		this.accessRights = accessRights;
		return this;
	}

	public ProjectAnalysisJob addAccessRightsItem(AccessRight accessRightsItem) {
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

	/**
	 * Get status
	 * @return status
	 **/
	@ApiModelProperty(example = "null", value = "")
	public StatusEnum getStatus() {
		return status;
	}

	public ProjectAnalysisJob error(Error error) {
		this.error = error;
		return this;
	}

	/**
	 * Get error
	 * @return error
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Error getError() {
		return error;
	}

	public void setError(Error error) {
		this.error = error;
	}

	public ProjectAnalysisJob statistics(Statistics statistics) {
		this.statistics = statistics;
		return this;
	}

	/**
	 * Get statistics
	 * @return statistics
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Statistics getStatistics() {
		return statistics;
	}

	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}

	/**
	 * Get resultsSize
	 * @return resultsSize
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Long getResultsSize() {
		return resultsSize;
	}

	public ProjectAnalysisJob temporary(Boolean temporary) {
		this.temporary = temporary;
		return this;
	}

	/**
	 * Get temporary
	 * @return temporary
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Boolean isTemporary() {
		return temporary;
	}

	public void setTemporary(Boolean temporary) {
		this.temporary = temporary;
	}

	public ProjectAnalysisJob autoRun(Boolean autoRun) {
		this.autoRun = autoRun;
		return this;
	}

	/**
	 * Get autoRun
	 * @return autoRun
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Boolean isAutoRun() {
		return autoRun;
	}

	public void setAutoRun(Boolean autoRun) {
		this.autoRun = autoRun;
	}

	/**
	 * Get creationTime
	 * @return creationTime
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Long getCreationTime() {
		return creationTime;
	}

	public ProjectAnalysisJob domains(List<DomainPK> domains) {
		this.domains = domains;
		return this;
	}

	public ProjectAnalysisJob addDomainsItem(DomainPK domainsItem) {
		this.domains.add(domainsItem);
		return this;
	}

	/**
	 * Get domains
	 * @return domains
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<DomainPK> getDomains() {
		return domains;
	}

	public void setDomains(List<DomainPK> domains) {
		this.domains = domains;
	}

	public ProjectAnalysisJob dimensions(List<DimensionPK> dimensions) {
		this.dimensions = dimensions;
		return this;
	}

	public ProjectAnalysisJob addDimensionsItem(DimensionPK dimensionsItem) {
		this.dimensions.add(dimensionsItem);
		return this;
	}

	/**
	 * Get dimensions
	 * @return dimensions
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<DimensionPK> getDimensions() {
		return dimensions;
	}

	public void setDimensions(List<DimensionPK> dimensions) {
		this.dimensions = dimensions;
	}

	public ProjectAnalysisJob metrics(List<MetricPK> metrics) {
		this.metrics = metrics;
		return this;
	}

	public ProjectAnalysisJob addMetricsItem(MetricPK metricsItem) {
		this.metrics.add(metricsItem);
		return this;
	}

	/**
	 * Get metrics
	 * @return metrics
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<MetricPK> getMetrics() {
		return metrics;
	}

	public void setMetrics(List<MetricPK> metrics) {
		this.metrics = metrics;
	}

	public ProjectAnalysisJob metricList(List<Metric> metricList) {
		this.metricList = metricList;
		return this;
	}

	public ProjectAnalysisJob addMetricListItem(Metric metricListItem) {
		this.metricList.add(metricListItem);
		return this;
	}

	/**
	 * Get metricList
	 * @return metricList
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<Metric> getMetricList() {
		return metricList;
	}

	public void setMetricList(List<Metric> metricList) {
		this.metricList = metricList;
	}

	public ProjectAnalysisJob facets(List<Expression> facets) {
		this.facets = facets;
		return this;
	}

	public ProjectAnalysisJob addFacetsItem(Expression facetsItem) {
		this.facets.add(facetsItem);
		return this;
	}

	/**
	 * Get facets
	 * @return facets
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<Expression> getFacets() {
		return facets;
	}

	public void setFacets(List<Expression> facets) {
		this.facets = facets;
	}

	public ProjectAnalysisJob rollups(List<RollUp> rollups) {
		this.rollups = rollups;
		return this;
	}

	public ProjectAnalysisJob addRollupsItem(RollUp rollupsItem) {
		this.rollups.add(rollupsItem);
		return this;
	}

	/**
	 * compute rollup on the given dimensions. It is a list of indices that references the dimension in either dimensions or facets list. In order to compute a grand-total, use id=-1 (it should be the first in the list). If several levels are defined, the analysis will compute sub-total for: (level0), then (level0,level1)... If a rollup is specified, the resulting DataTable will have a new column 'GROUPING_ID' in first position that will return 0 if the row is the grand-total, 1 for the first level sub-total, ... and null if it is not a rollup row.
	 * @return rollups
	 **/
	@ApiModelProperty(example = "null", value = "compute rollup on the given dimensions. It is a list of indices that references the dimension in either dimensions or facets list. In order to compute a grand-total, use id=-1 (it should be the first in the list). If several levels are defined, the analysis will compute sub-total for: (level0), then (level0,level1)... If a rollup is specified, the resulting DataTable will have a new column 'GROUPING_ID' in first position that will return 0 if the row is the grand-total, 1 for the first level sub-total, ... and null if it is not a rollup row.")
	public List<RollUp> getRollups() {
		return rollups;
	}

	public void setRollups(List<RollUp> rollups) {
		this.rollups = rollups;
	}

	public ProjectAnalysisJob selection(FacetSelection selection) {
		this.selection = selection;
		return this;
	}

	/**
	 * Get selection
	 * @return selection
	 **/
	@ApiModelProperty(example = "null", value = "")
	public FacetSelection getSelection() {
		return selection;
	}

	public void setSelection(FacetSelection selection) {
		this.selection = selection;
	}

	public ProjectAnalysisJob orderBy(List<OrderBy> orderBy) {
		this.orderBy = orderBy;
		return this;
	}

	public ProjectAnalysisJob addOrderByItem(OrderBy orderByItem) {
		this.orderBy.add(orderByItem);
		return this;
	}

	/**
	 * Get orderBy
	 * @return orderBy
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<OrderBy> getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(List<OrderBy> orderBy) {
		this.orderBy = orderBy;
	}

	public ProjectAnalysisJob offset(Long offset) {
		this.offset = offset;
		return this;
	}

	/**
	 * Get offset
	 * @return offset
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Long getOffset() {
		return offset;
	}

	public void setOffset(Long offset) {
		this.offset = offset;
	}

	public ProjectAnalysisJob limit(Long limit) {
		this.limit = limit;
		return this;
	}

	/**
	 * Get limit
	 * @return limit
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Long getLimit() {
		return limit;
	}

	public void setLimit(Long limit) {
		this.limit = limit;
	}

	public ProjectAnalysisJob beyondLimit(List<Index> beyondLimit) {
		this.beyondLimit = beyondLimit;
		return this;
	}

	public ProjectAnalysisJob addBeyondLimitItem(Index beyondLimitItem) {
		this.beyondLimit.add(beyondLimitItem);
		return this;
	}

	/**
	 * Get beyondLimit
	 * @return beyondLimit
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<Index> getBeyondLimit() {
		return beyondLimit;
	}

	public void setBeyondLimit(List<Index> beyondLimit) {
		this.beyondLimit = beyondLimit;
	}

	public ProjectAnalysisJob optionKeys(Map<String, Object> optionKeys) {
		this.optionKeys = optionKeys;
		return this;
	}

	public ProjectAnalysisJob putOptionKeysItem(String key, Object optionKeysItem) {
		this.optionKeys.put(key, optionKeysItem);
		return this;
	}

	/**
	 * Get optionKeys
	 * @return optionKeys
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Map<String, Object> getOptionKeys() {
		return optionKeys;
	}

	public void setOptionKeys(Map<String, Object> optionKeys) {
		this.optionKeys = optionKeys;
	}

	public ProjectAnalysisJob results(DataTable results) {
		this.results = results;
		return this;
	}

	/**
	 * Get results
	 * @return results
	 **/
	@ApiModelProperty(example = "null", value = "")
	public DataTable getResults() {
		return results;
	}

	public void setResults(DataTable results) {
		this.results = results;
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

}

