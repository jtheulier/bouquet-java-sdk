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
import java.util.List;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * AnalyticsQuery
 */

public class AnalyticsQuery extends Base  {
	@SerializedName("bookmarkId")
	private String bookmarkId = null;

	@SerializedName("bbid")
	private String bbid = null;

	@SerializedName("rollups")
	private List<RollUp> rollups = new ArrayList<RollUp>();

	/**
	 * Gets or Sets style
	 */
	public enum StyleEnum {
		@SerializedName("HUMAN")
		HUMAN("HUMAN"),

		@SerializedName("LEGACY")
		LEGACY("LEGACY"),

		@SerializedName("ROBOT")
		ROBOT("ROBOT"),

		@SerializedName("HTML")
		HTML("HTML");

		private String value;

		StyleEnum(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}

	@SerializedName("style")
	private StyleEnum style = null;

	@SerializedName("lazy")
	private String lazy = null;

	@SerializedName("startIndex")
	private Integer startIndex = null;

	@SerializedName("maxResults")
	private Integer maxResults = null;

	@SerializedName("queryID")
	private String queryID = null;

	@SerializedName("problems")
	private List<Problem> problems = new ArrayList<Problem>();

	@SerializedName("offset")
	private Long offset = null;

	@SerializedName("limit")
	private Long limit = null;

	@SerializedName("domain")
	private String domain = null;

	@SerializedName("groupBy")
	private List<String> groupBy = new ArrayList<String>();

	@SerializedName("metrics")
	private List<String> metrics = new ArrayList<String>();

	@SerializedName("orderBy")
	private List<String> orderBy = new ArrayList<String>();

	@SerializedName("beyondLimit")
	private List<String> beyondLimit = new ArrayList<String>();

	@SerializedName("filters")
	private List<String> filters = new ArrayList<String>();

	@SerializedName("period")
	private String period = null;

	@SerializedName("timeframe")
	private List<String> timeframe = new ArrayList<String>();

	@SerializedName("compareTo")
	private List<String> compareTo = new ArrayList<String>();

	public AnalyticsQuery bookmarkId(String bookmarkId) {
		this.bookmarkId = bookmarkId;
		return this;
	}

	/**
	 * Get bookmarkId
	 * @return bookmarkId
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getBookmarkId() {
		return bookmarkId;
	}

	public void setBookmarkId(String bookmarkId) {
		this.bookmarkId = bookmarkId;
	}

	public AnalyticsQuery bbid(String bbid) {
		this.bbid = bbid;
		return this;
	}

	/**
	 * Get bbid
	 * @return bbid
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getBbid() {
		return bbid;
	}

	public void setBbid(String bbid) {
		this.bbid = bbid;
	}

	public AnalyticsQuery rollups(List<RollUp> rollups) {
		this.rollups = rollups;
		return this;
	}

	public AnalyticsQuery addRollupsItem(RollUp rollupsItem) {
		this.rollups.add(rollupsItem);
		return this;
	}

	/**
	 * Get rollups
	 * @return rollups
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<RollUp> getRollups() {
		return rollups;
	}

	public void setRollups(List<RollUp> rollups) {
		this.rollups = rollups;
	}

	public AnalyticsQuery style(StyleEnum style) {
		this.style = style;
		return this;
	}

	/**
	 * Get style
	 * @return style
	 **/
	@ApiModelProperty(example = "null", value = "")
	public StyleEnum getStyle() {
		return style;
	}

	public void setStyle(StyleEnum style) {
		this.style = style;
	}

	public AnalyticsQuery lazy(String lazy) {
		this.lazy = lazy;
		return this;
	}

	/**
	 * Get lazy
	 * @return lazy
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getLazy() {
		return lazy;
	}

	public void setLazy(String lazy) {
		this.lazy = lazy;
	}

	public AnalyticsQuery startIndex(Integer startIndex) {
		this.startIndex = startIndex;
		return this;
	}

	/**
	 * Get startIndex
	 * @return startIndex
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public AnalyticsQuery maxResults(Integer maxResults) {
		this.maxResults = maxResults;
		return this;
	}

	/**
	 * Get maxResults
	 * @return maxResults
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Integer getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(Integer maxResults) {
		this.maxResults = maxResults;
	}

	public AnalyticsQuery queryID(String queryID) {
		this.queryID = queryID;
		return this;
	}

	/**
	 * Get queryID
	 * @return queryID
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getQueryID() {
		return queryID;
	}

	public void setQueryID(String queryID) {
		this.queryID = queryID;
	}

	public AnalyticsQuery problems(List<Problem> problems) {
		this.problems = problems;
		return this;
	}

	public AnalyticsQuery addProblemsItem(Problem problemsItem) {
		this.problems.add(problemsItem);
		return this;
	}

	/**
	 * Get problems
	 * @return problems
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<Problem> getProblems() {
		return problems;
	}

	public void setProblems(List<Problem> problems) {
		this.problems = problems;
	}

	public AnalyticsQuery offset(Long offset) {
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

	public AnalyticsQuery limit(Long limit) {
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

	public AnalyticsQuery domain(String domain) {
		this.domain = domain;
		return this;
	}

	/**
	 * Get domain
	 * @return domain
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public AnalyticsQuery groupBy(List<String> groupBy) {
		this.groupBy = groupBy;
		return this;
	}

	public AnalyticsQuery addGroupByItem(String groupByItem) {
		this.groupBy.add(groupByItem);
		return this;
	}

	/**
	 * Get groupBy
	 * @return groupBy
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<String> getGroupBy() {
		return groupBy;
	}

	public void setGroupBy(List<String> groupBy) {
		this.groupBy = groupBy;
	}

	public AnalyticsQuery metrics(List<String> metrics) {
		this.metrics = metrics;
		return this;
	}

	public AnalyticsQuery addMetricsItem(String metricsItem) {
		this.metrics.add(metricsItem);
		return this;
	}

	/**
	 * Get metrics
	 * @return metrics
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<String> getMetrics() {
		return metrics;
	}

	public void setMetrics(List<String> metrics) {
		this.metrics = metrics;
	}

	public AnalyticsQuery orderBy(List<String> orderBy) {
		this.orderBy = orderBy;
		return this;
	}

	public AnalyticsQuery addOrderByItem(String orderByItem) {
		this.orderBy.add(orderByItem);
		return this;
	}

	/**
	 * Get orderBy
	 * @return orderBy
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<String> getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(List<String> orderBy) {
		this.orderBy = orderBy;
	}

	public AnalyticsQuery beyondLimit(List<String> beyondLimit) {
		this.beyondLimit = beyondLimit;
		return this;
	}

	public AnalyticsQuery addBeyondLimitItem(String beyondLimitItem) {
		this.beyondLimit.add(beyondLimitItem);
		return this;
	}

	/**
	 * Get beyondLimit
	 * @return beyondLimit
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<String> getBeyondLimit() {
		return beyondLimit;
	}

	public void setBeyondLimit(List<String> beyondLimit) {
		this.beyondLimit = beyondLimit;
	}

	public AnalyticsQuery filters(List<String> filters) {
		this.filters = filters;
		return this;
	}

	public AnalyticsQuery addFiltersItem(String filtersItem) {
		this.filters.add(filtersItem);
		return this;
	}

	/**
	 * Get filters
	 * @return filters
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<String> getFilters() {
		return filters;
	}

	public void setFilters(List<String> filters) {
		this.filters = filters;
	}

	public AnalyticsQuery period(String period) {
		this.period = period;
		return this;
	}

	/**
	 * Get period
	 * @return period
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public AnalyticsQuery timeframe(List<String> timeframe) {
		this.timeframe = timeframe;
		return this;
	}

	public AnalyticsQuery addTimeframeItem(String timeframeItem) {
		this.timeframe.add(timeframeItem);
		return this;
	}

	/**
	 * Get timeframe
	 * @return timeframe
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<String> getTimeframe() {
		return timeframe;
	}

	public void setTimeframe(List<String> timeframe) {
		this.timeframe = timeframe;
	}

	public AnalyticsQuery compareTo(List<String> compareTo) {
		this.compareTo = compareTo;
		return this;
	}

	public AnalyticsQuery addCompareToItem(String compareToItem) {
		this.compareTo.add(compareToItem);
		return this;
	}

	/**
	 * Get compareTo
	 * @return compareTo
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<String> getCompareTo() {
		return compareTo;
	}

	public void setCompareTo(List<String> compareTo) {
		this.compareTo = compareTo;
	}

}

