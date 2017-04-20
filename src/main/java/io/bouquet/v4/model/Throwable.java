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
 * Throwable
 */

public class Throwable extends Base  {
	@SerializedName("cause")
	private Throwable cause = null;

	@SerializedName("stackTrace")
	private List<StackTraceElement> stackTrace = new ArrayList<StackTraceElement>();

	@SerializedName("message")
	private String message = null;

	@SerializedName("localizedMessage")
	private String localizedMessage = null;

	@SerializedName("suppressed")
	private List<Throwable> suppressed = new ArrayList<Throwable>();

	public Throwable cause(Throwable cause) {
		this.cause = cause;
		return this;
	}

	/**
	 * Get cause
	 * @return cause
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Throwable getCause() {
		return cause;
	}

	public void setCause(Throwable cause) {
		this.cause = cause;
	}

	public Throwable stackTrace(List<StackTraceElement> stackTrace) {
		this.stackTrace = stackTrace;
		return this;
	}

	public Throwable addStackTraceItem(StackTraceElement stackTraceItem) {
		this.stackTrace.add(stackTraceItem);
		return this;
	}

	/**
	 * Get stackTrace
	 * @return stackTrace
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<StackTraceElement> getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(List<StackTraceElement> stackTrace) {
		this.stackTrace = stackTrace;
	}

	public Throwable message(String message) {
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

	public Throwable localizedMessage(String localizedMessage) {
		this.localizedMessage = localizedMessage;
		return this;
	}

	/**
	 * Get localizedMessage
	 * @return localizedMessage
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getLocalizedMessage() {
		return localizedMessage;
	}

	public void setLocalizedMessage(String localizedMessage) {
		this.localizedMessage = localizedMessage;
	}

	public Throwable suppressed(List<Throwable> suppressed) {
		this.suppressed = suppressed;
		return this;
	}

	public Throwable addSuppressedItem(Throwable suppressedItem) {
		this.suppressed.add(suppressedItem);
		return this;
	}

	/**
	 * Get suppressed
	 * @return suppressed
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<Throwable> getSuppressed() {
		return suppressed;
	}

	public void setSuppressed(List<Throwable> suppressed) {
		this.suppressed = suppressed;
	}

}

