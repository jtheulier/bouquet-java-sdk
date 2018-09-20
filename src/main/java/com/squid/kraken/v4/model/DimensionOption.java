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
 * DimensionOption
 */

public class DimensionOption extends Base  {

	@SerializedName("id")
	private DimensionOptionPK id = null;

	@SerializedName("mandatorySelection")
	private Boolean mandatorySelection = false;

	@SerializedName("singleSelection")
	private Boolean singleSelection = false;

	@SerializedName("defaultSelection")
	private Expression defaultSelection = null;

	@SerializedName("unmodifiableSelection")
	private Boolean unmodifiableSelection = false;

	@SerializedName("hidden")
	private Boolean hidden = false;

	@SerializedName("name")
	public String name = null;

	@SerializedName("groupFilter")
	private List<String> groupFilter = new ArrayList<String>();

	@SerializedName("userFilter")
	private List<String> userFilter = new ArrayList<String>();

	public DimensionOption id(DimensionOptionPK id) {
		this.id = id;
		return this;
	}

	/**
	 * The object Composite Id (Primary Key)
	 * @return id
	 **/
	@ApiModelProperty(example = "null", value = "The object Composite Id (Primary Key)")
	public DimensionOptionPK getId() {
		return id;
	}

	public void setId(DimensionOptionPK id) {
		this.id = id;
	}

	public DimensionOption mandatorySelection(Boolean mandatorySelection) {
		this.mandatorySelection = mandatorySelection;
		return this;
	}

	/**
	 * Get mandatorySelection
	 * @return mandatorySelection
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Boolean isMandatorySelection() {
		return mandatorySelection;
	}

	public void setMandatorySelection(Boolean mandatorySelection) {
		this.mandatorySelection = mandatorySelection;
	}

	public DimensionOption singleSelection(Boolean singleSelection) {
		this.singleSelection = singleSelection;
		return this;
	}

	/**
	 * Get singleSelection
	 * @return singleSelection
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Boolean isSingleSelection() {
		return singleSelection;
	}

	public void setSingleSelection(Boolean singleSelection) {
		this.singleSelection = singleSelection;
	}

	public DimensionOption defaultSelection(Expression defaultSelection) {
		this.defaultSelection = defaultSelection;
		return this;
	}

	/**
	 * Get defaultSelection
	 * @return defaultSelection
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Expression getDefaultSelection() {
		return defaultSelection;
	}

	public void setDefaultSelection(Expression defaultSelection) {
		this.defaultSelection = defaultSelection;
	}

	public DimensionOption unmodifiableSelection(Boolean unmodifiableSelection) {
		this.unmodifiableSelection = unmodifiableSelection;
		return this;
	}

	/**
	 * Get unmodifiableSelection
	 * @return unmodifiableSelection
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Boolean isUnmodifiableSelection() {
		return unmodifiableSelection;
	}

	public void setUnmodifiableSelection(Boolean unmodifiableSelection) {
		this.unmodifiableSelection = unmodifiableSelection;
	}

	public DimensionOption hidden(Boolean hidden) {
		this.hidden = hidden;
		return this;
	}

	/**
	 * Get hidden
	 * @return hidden
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Boolean isHidden() {
		return hidden;
	}

	public void setHidden(Boolean hidden) {
		this.hidden = hidden;
	}

	public DimensionOption groupFilter(List<String> groupFilter) {
		this.groupFilter = groupFilter;
		return this;
	}

	public DimensionOption addGroupFilterItem(String groupFilterItem) {
		this.groupFilter.add(groupFilterItem);
		return this;
	}

	/**
	 * Get name
	 * @return name
	 **/
	@ApiModelProperty(example = "null", value = "")
	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	/**
	 * Get groupFilter
	 * @return groupFilter
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<String> getGroupFilter() {
		return groupFilter;
	}

	public void setGroupFilter(List<String> groupFilter) {
		this.groupFilter = groupFilter;
	}

	public DimensionOption userFilter(List<String> userFilter) {
		this.userFilter = userFilter;
		return this;
	}

	public DimensionOption addUserFilterItem(String userFilterItem) {
		this.userFilter.add(userFilterItem);
		return this;
	}

	/**
	 * Get userFilter
	 * @return userFilter
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<String> getUserFilter() {
		return userFilter;
	}

	public void setUserFilter(List<String> userFilter) {
		this.userFilter = userFilter;
	}
}

