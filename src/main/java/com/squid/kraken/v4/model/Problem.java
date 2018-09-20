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
 * Problem
 */

public class Problem extends Base  {
	/**
	 * Gets or Sets severity
	 */
	public enum SeverityEnum {
		@SerializedName("WARNING")
		WARNING("WARNING"),

		@SerializedName("ERROR")
		ERROR("ERROR");

		private String value;

		SeverityEnum(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}

	@SerializedName("severity")
	private SeverityEnum severity = null;

	@SerializedName("subject")
	private String subject = null;

	@SerializedName("message")
	private String message = null;

	@SerializedName("error")
	private Throwable error = null;

	public Problem severity(SeverityEnum severity) {
		this.severity = severity;
		return this;
	}

	/**
	 * Get severity
	 * @return severity
	 **/
	@ApiModelProperty(example = "null", value = "")
	public SeverityEnum getSeverity() {
		return severity;
	}

	public void setSeverity(SeverityEnum severity) {
		this.severity = severity;
	}

	public Problem subject(String subject) {
		this.subject = subject;
		return this;
	}

	/**
	 * Get subject
	 * @return subject
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Problem message(String message) {
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

	public Problem error(Throwable error) {
		this.error = error;
		return this;
	}

	/**
	 * Get error
	 * @return error
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Throwable getError() {
		return error;
	}

	public void setError(Throwable error) {
		this.error = error;
	}

}

