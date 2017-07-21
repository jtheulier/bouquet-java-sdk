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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;


public class BookmarkConfig extends Base {

	Integer limit;
	Integer startIndex;
	Integer maxResults;
	String currentAnalysis;
	FacetSelection selection;
	String customer;
	String domain;
	Period period;
	List<String> chosenDimensions;
	List<ChosenMetric> chosenMetrics;
	FolderState bookmarkFolderState;
	Boolean tourSeen;
	List<OrderBy> orderBy;
	List<RollUp> rollUps;
	Boolean automaticTrigger;

	private Map<String, Object> other = new HashMap<String, Object>();

	String project;
	String selectedMetric;
	String selectedDimension;
	String orderByDirection;

	List<String> availableDimensions;
	List<String> availableMetrics;

	public BookmarkConfig() {
	}

	public class FolderState {
		private String bookmarkId;
		private String stateId;
		private Map<String, String> other = new HashMap<String, String>();

		public FolderState() {

		}

		public String getBookmarkId() {
			return bookmarkId;
		}

		public void setBookmarkId(String bookmarkId) {
			this.bookmarkId = bookmarkId;
		}

		public String getStateId() {
			return stateId;
		}

		public void setStateId(String stateId) {
			this.stateId = stateId;
		}

		@JsonAnyGetter
		public Map<String, String> any() {
			return other;
		}

		@JsonAnySetter
		public void set(String name, String value) {
			other.put(name, value);
		}
	}



	public class Period {
		String domainId;
		String dimensionId;
		private Map<String, String> other = new HashMap<String, String>();

		public Period() {

		}

		public String getDomainId() {
			return domainId;
		}

		public void setDomainId(String domainId) {
			this.domainId = domainId;
		}

		public String getDimensionId() {
			return dimensionId;
		}

		public void setDimensionId(String dimensionId) {
			this.dimensionId = dimensionId;
		}

		@JsonAnyGetter
		public Map<String, String> any() {
			return other;
		}

		@JsonAnySetter
		public void set(String name, String value) {
			other.put(name, value);
		}
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public Integer getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(Integer maxResults) {
		this.maxResults = maxResults;
	}

	public String getCurrentAnalysis() {
		return currentAnalysis;
	}

	public void setCurrentAnalysis(String currentAnalysis) {
		this.currentAnalysis = currentAnalysis;
	}

	public FacetSelection getSelection() {
		return selection;
	}

	public void setSelection(FacetSelection selection) {
		this.selection = selection;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public List<String> getChosenDimensions() {
		return chosenDimensions;
	}

	public void setChosenDimensions(List<String> chosenDimensions) {

		this.chosenDimensions = chosenDimensions;
	}

	public List<ChosenMetric> getChosenMetrics() {
		return chosenMetrics;
	}

	public void setChosenMetrics(List<ChosenMetric> chosenMetrics) {
		this.chosenMetrics = chosenMetrics;
	}

	public FolderState getBookmarkFolderState() {
		return bookmarkFolderState;
	}

	public void setBookmarkFolderState(FolderState bookmarkFolderState) {
		this.bookmarkFolderState = bookmarkFolderState;
	}

	public Boolean isTourSeen() {
		return tourSeen;
	}

	public void setTourSeen(Boolean tourSeen) {
		this.tourSeen = tourSeen;
	}

	public List<OrderBy> getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(List<OrderBy> orderBy) {
		this.orderBy = orderBy;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("rollups")
	public List<RollUp> getRollUps() {
		return rollUps;
	}

	public void setRollUps(List<RollUp> rollUps) {
		this.rollUps = rollUps;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getSelectedMetric() {
		return selectedMetric;
	}

	public void setSelectedMetric(String selectedMetric) {
		this.selectedMetric = selectedMetric;
	}

	public String getSelectedDimension() {
		return selectedDimension;
	}

	public void setSelectedDimension(String selectedDimension) {
		this.selectedDimension = selectedDimension;
	}

	public String getOrderByDirection() {
		return orderByDirection;
	}

	public void setOrderByDirection(String orderByDirection) {
		this.orderByDirection = orderByDirection;
	}

	@JsonAnyGetter
	public Map<String, Object> any() {
		return other;
	}

	@JsonAnySetter
	public void set(String name, Object value) {
		other.put(name, value);
	}

	public Boolean isAutomaticTrigger() {
		return automaticTrigger;
	}

	public void setAutomaticTrigger(Boolean automaticTrigger) {
		this.automaticTrigger = automaticTrigger;
	}

	public List<String> getAvailableDimensions() {
		return availableDimensions;
	}

	public void setAvailableDimensions(List<String> availableDimensions) {
		this.availableDimensions = availableDimensions;
	}

	public List<String> getAvailableMetrics() {
		return availableMetrics;
	}

	public void setAvailableMetrics(List<String> availableMetrics) {
		this.availableMetrics = availableMetrics;
	}
}
