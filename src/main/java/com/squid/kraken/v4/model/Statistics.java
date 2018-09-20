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

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * Statistics
 */

public class Statistics extends Base  {
	@SerializedName("startTime")
	private Long startTime = null;

	@SerializedName("endTime")
	private Long endTime = null;

	@SerializedName("totalBytesProcessed")
	private Long totalBytesProcessed = null;

	public Statistics startTime(Long startTime) {
		this.startTime = startTime;
		return this;
	}

	/**
	 * Get startTime
	 * @return startTime
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Long getStartTime() {
		return startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	public Statistics endTime(Long endTime) {
		this.endTime = endTime;
		return this;
	}

	/**
	 * Get endTime
	 * @return endTime
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Long getEndTime() {
		return endTime;
	}

	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}

	public Statistics totalBytesProcessed(Long totalBytesProcessed) {
		this.totalBytesProcessed = totalBytesProcessed;
		return this;
	}

	/**
	 * Get totalBytesProcessed
	 * @return totalBytesProcessed
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Long getTotalBytesProcessed() {
		return totalBytesProcessed;
	}

	public void setTotalBytesProcessed(Long totalBytesProcessed) {
		this.totalBytesProcessed = totalBytesProcessed;
	}

}

