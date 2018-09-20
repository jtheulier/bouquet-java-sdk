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

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * DomainOption
 */

public class DomainOption extends Base  {
	@SerializedName("shortcut")
	private String shortcut = null;

	@SerializedName("analysisJob")
	private ProjectAnalysisJob analysisJob = null;

	@SerializedName("sourceProjectId")
	private String sourceProjectId = null;

	@SerializedName("destSchema")
	private String destSchema = null;

	@SerializedName("destProjectId")
	private String destProjectId = null;

	@SerializedName("reinjected")
	private Boolean reinjected = false;

	@SerializedName("dependencies")
	private List<DomainPK> dependencies = new ArrayList<DomainPK>();

	@SerializedName("alink")
	private Boolean alink = false;

	@SerializedName("LinkSource")
	private String linkSource = null;

	public DomainOption shortcut(String shortcut) {
		this.shortcut = shortcut;
		return this;
	}

	/**
	 * Get shortcut
	 * @return shortcut
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getShortcut() {
		return shortcut;
	}

	public void setShortcut(String shortcut) {
		this.shortcut = shortcut;
	}

	public DomainOption analysisJob(ProjectAnalysisJob analysisJob) {
		this.analysisJob = analysisJob;
		return this;
	}

	/**
	 * Get analysisJob
	 * @return analysisJob
	 **/
	@ApiModelProperty(example = "null", value = "")
	public ProjectAnalysisJob getAnalysisJob() {
		return analysisJob;
	}

	public void setAnalysisJob(ProjectAnalysisJob analysisJob) {
		this.analysisJob = analysisJob;
	}

	public DomainOption sourceProjectId(String sourceProjectId) {
		this.sourceProjectId = sourceProjectId;
		return this;
	}

	/**
	 * Get sourceProjectId
	 * @return sourceProjectId
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getSourceProjectId() {
		return sourceProjectId;
	}

	public void setSourceProjectId(String sourceProjectId) {
		this.sourceProjectId = sourceProjectId;
	}

	public DomainOption destSchema(String destSchema) {
		this.destSchema = destSchema;
		return this;
	}

	/**
	 * Get destSchema
	 * @return destSchema
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getDestSchema() {
		return destSchema;
	}

	public void setDestSchema(String destSchema) {
		this.destSchema = destSchema;
	}

	public DomainOption destProjectId(String destProjectId) {
		this.destProjectId = destProjectId;
		return this;
	}

	/**
	 * Get destProjectId
	 * @return destProjectId
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getDestProjectId() {
		return destProjectId;
	}

	public void setDestProjectId(String destProjectId) {
		this.destProjectId = destProjectId;
	}

	public DomainOption reinjected(Boolean reinjected) {
		this.reinjected = reinjected;
		return this;
	}

	/**
	 * Get reinjected
	 * @return reinjected
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Boolean isReinjected() {
		return reinjected;
	}

	public void setReinjected(Boolean reinjected) {
		this.reinjected = reinjected;
	}

	public DomainOption dependencies(List<DomainPK> dependencies) {
		this.dependencies = dependencies;
		return this;
	}

	public DomainOption addDependenciesItem(DomainPK dependenciesItem) {
		this.dependencies.add(dependenciesItem);
		return this;
	}

	/**
	 * Get dependencies
	 * @return dependencies
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<DomainPK> getDependencies() {
		return dependencies;
	}

	public void setDependencies(List<DomainPK> dependencies) {
		this.dependencies = dependencies;
	}

	public DomainOption alink(Boolean alink) {
		this.alink = alink;
		return this;
	}

	/**
	 * Get alink
	 * @return alink
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Boolean isAlink() {
		return alink;
	}

	public void setAlink(Boolean alink) {
		this.alink = alink;
	}

	public DomainOption linkSource(String linkSource) {
		this.linkSource = linkSource;
		return this;
	}

	/**
	 * Get linkSource
	 * @return linkSource
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getLinkSource() {
		return linkSource;
	}

	public void setLinkSource(String linkSource) {
		this.linkSource = linkSource;
	}

}

