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
 * StackTraceElement
 */

public class StackTraceElement extends Base  {
	@SerializedName("methodName")
	private String methodName = null;

	@SerializedName("fileName")
	private String fileName = null;

	@SerializedName("lineNumber")
	private Integer lineNumber = null;

	@SerializedName("className")
	private String className = null;

	@SerializedName("nativeMethod")
	private Boolean nativeMethod = false;

	public StackTraceElement methodName(String methodName) {
		this.methodName = methodName;
		return this;
	}

	/**
	 * Get methodName
	 * @return methodName
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public StackTraceElement fileName(String fileName) {
		this.fileName = fileName;
		return this;
	}

	/**
	 * Get fileName
	 * @return fileName
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public StackTraceElement lineNumber(Integer lineNumber) {
		this.lineNumber = lineNumber;
		return this;
	}

	/**
	 * Get lineNumber
	 * @return lineNumber
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Integer getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(Integer lineNumber) {
		this.lineNumber = lineNumber;
	}

	public StackTraceElement className(String className) {
		this.className = className;
		return this;
	}

	/**
	 * Get className
	 * @return className
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public StackTraceElement nativeMethod(Boolean nativeMethod) {
		this.nativeMethod = nativeMethod;
		return this;
	}

	/**
	 * Get nativeMethod
	 * @return nativeMethod
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Boolean isNativeMethod() {
		return nativeMethod;
	}

	public void setNativeMethod(Boolean nativeMethod) {
		this.nativeMethod = nativeMethod;
	}

}

