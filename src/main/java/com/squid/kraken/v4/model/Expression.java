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
 * Expression
 */

public class Expression extends Base {
	@SerializedName("value")
	private String value = null;

	@SerializedName("name")
	private String name = null;

	private int level = 0;// level of references (0=no model references, 1=at
							// least one indirect reference, ...)

	private String internal = null;// store the identifier only reference
									// expression

	/*
	 * Added transiant else something isn't correctly set debug what is missing
	 * if you need to remove it
	 */
	@SerializedName("references")
	private transient List<ReferencePK> references = new ArrayList<ReferencePK>();

	public Expression value(String value) {
		this.value = value;
		return this;
	}

	/**
	 * Get value
	 * 
	 * @return value
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Expression name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Get name
	 * 
	 * @return name
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Expression references(List<ReferencePK> references) {
		this.references = references;
		return this;
	}

	public Expression addReferencesItem(ReferencePK referencesItem) {
		this.references.add(referencesItem);
		return this;
	}

	/**
	 * Get references
	 * 
	 * @return references
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<ReferencePK> getReferences() {
		return references;
	}

	public void setReferences(List<ReferencePK> references) {
		this.references = references;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getInternal() {
		return internal;
	}

	public void setInternal(String internal) {
		this.internal = internal;
	}
}
