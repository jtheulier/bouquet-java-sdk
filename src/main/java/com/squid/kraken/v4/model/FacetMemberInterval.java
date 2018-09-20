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

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * FacetMemberInterval
 */

@JsonTypeName("i")
public class FacetMemberInterval extends FacetMember  {
	@SerializedName("lowerBound")
	private String lowerBound = null;

	@SerializedName("upperBound")
	private String upperBound = null;

	public FacetMemberInterval lowerBound(String lowerBound) {
		this.lowerBound = lowerBound;
		return this;
	}

	/**
	 * Get lowerBound
	 * @return lowerBound
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getLowerBound() {
		return lowerBound;
	}

	public void setLowerBound(String lowerBound) {
		this.lowerBound = lowerBound;
	}

	public FacetMemberInterval upperBound(String upperBound) {
		this.upperBound = upperBound;
		return this;
	}

	/**
	 * Get upperBound
	 * @return upperBound
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getUpperBound() {
		return upperBound;
	}

	public void setUpperBound(String upperBound) {
		this.upperBound = upperBound;
	}

}

