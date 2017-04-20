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

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import io.swagger.annotations.ApiModelProperty;

public class ProjectFacetJob extends VersionedBase  {

	private ProjectFacetJobPK id = null;
	private List<AccessRight> accessRights = new ArrayList<AccessRight>();


	public enum StatusEnum {
		PENDING("PENDING"),
		RUNNING("RUNNING"),
		DONE("DONE");

		private String value;

		StatusEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return value;
		}
	}

	private StatusEnum status = null;
	private Error error = null;
	private Statistics statistics = null;
	private Long resultsSize = null;
	private Boolean temporary = null;
	private Boolean autoRun = null;
	private Long creationTime = null;
	private List<DomainPK> domains = new ArrayList<DomainPK>();
	private FacetSelection selection = null;
	private Integer engineVersion = null;
	private FacetSelection results = null;
	private String oid = null;
	private String objectType = null;

	/**
	 * The object Composite Id (Primary Key)
	 **/
	public ProjectFacetJob id(ProjectFacetJobPK id) {
		this.id = id;
		return this;
	}

	@ApiModelProperty(example = "null", value = "The object Composite Id (Primary Key)")
	@JsonProperty("id")
	public ProjectFacetJobPK getId() {
		return id;
	}
	public void setId(ProjectFacetJobPK id) {
		this.id = id;
	}


	/**
	 * The ACL for this object
	 **/
	public ProjectFacetJob accessRights(List<AccessRight> accessRights) {
		this.accessRights = accessRights;
		return this;
	}

	@ApiModelProperty(example = "null", value = "The ACL for this object")
	@JsonProperty("accessRights")
	public List<AccessRight> getAccessRights() {
		return accessRights;
	}
	public void setAccessRights(List<AccessRight> accessRights) {
		this.accessRights = accessRights;
	}


	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("status")
	public StatusEnum getStatus() {
		return status;
	}


	/**
	 **/
	public ProjectFacetJob error(Error error) {
		this.error = error;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("error")
	public Error getError() {
		return error;
	}
	public void setError(Error error) {
		this.error = error;
	}


	/**
	 **/
	public ProjectFacetJob statistics(Statistics statistics) {
		this.statistics = statistics;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("statistics")
	public Statistics getStatistics() {
		return statistics;
	}
	public void setStatistics(Statistics statistics) {
		this.statistics = statistics;
	}


	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("resultsSize")
	public Long getResultsSize() {
		return resultsSize;
	}


	/**
	 **/
	public ProjectFacetJob temporary(Boolean temporary) {
		this.temporary = temporary;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("temporary")
	public Boolean isTemporary() {
		return temporary;
	}
	public void setTemporary(Boolean temporary) {
		this.temporary = temporary;
	}


	/**
	 **/
	public ProjectFacetJob autoRun(Boolean autoRun) {
		this.autoRun = autoRun;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("autoRun")
	public Boolean isAutoRun() {
		return autoRun;
	}
	public void setAutoRun(Boolean autoRun) {
		this.autoRun = autoRun;
	}


	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("creationTime")
	public Long getCreationTime() {
		return creationTime;
	}


	/**
	 **/
	public ProjectFacetJob domains(List<DomainPK> domains) {
		this.domains = domains;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("domains")
	public List<DomainPK> getDomains() {
		return domains;
	}
	public void setDomains(List<DomainPK> domains) {
		this.domains = domains;
	}


	/**
	 **/
	public ProjectFacetJob selection(FacetSelection selection) {
		this.selection = selection;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("selection")
	public FacetSelection getSelection() {
		return selection;
	}
	public void setSelection(FacetSelection selection) {
		this.selection = selection;
	}


	/**
	 **/
	public ProjectFacetJob engineVersion(Integer engineVersion) {
		this.engineVersion = engineVersion;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("engineVersion")
	public Integer getEngineVersion() {
		return engineVersion;
	}
	public void setEngineVersion(Integer engineVersion) {
		this.engineVersion = engineVersion;
	}


	/**
	 **/
	public ProjectFacetJob results(FacetSelection results) {
		this.results = results;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("results")
	public FacetSelection getResults() {
		return results;
	}
	public void setResults(FacetSelection results) {
		this.results = results;
	}


	@ApiModelProperty(example = "null", value = "The Object Id")
	@JsonProperty("oid")
	public String getOid() {
		return oid;
	}


	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("objectType")
	public String getObjectType() {
		return objectType;
	}

}

