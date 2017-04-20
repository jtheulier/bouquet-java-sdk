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

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * Error
 */

public class Error extends Base  {
	@SerializedName("reason")
	private String reason = null;

	@SerializedName("message")
	private String message = null;

	@SerializedName("enableRerun")
	private Boolean enableRerun = false;

	public Error reason(String reason) {
		this.reason = reason;
		return this;
	}

	/**
	 * Get reason
	 * @return reason
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Error message(String message) {
		this.message = message;
		return this;
	}

	/**
	 * Get message
	 * @return message
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Error enableRerun(Boolean enableRerun) {
		this.enableRerun = enableRerun;
		return this;
	}

	/**
	 * Get enableRerun
	 * @return enableRerun
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Boolean isEnableRerun() {
		return enableRerun;
	}

	public void setEnableRerun(Boolean enableRerun) {
		this.enableRerun = enableRerun;
	}

}

