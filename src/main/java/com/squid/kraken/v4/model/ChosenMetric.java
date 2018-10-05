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

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class ChosenMetric extends Base {

	private String id = null;
	private Expression expression = null;
	private String name = null;

	public ChosenMetric() {
	}

	public ChosenMetric(String id) {
		this.id = id;
	}

	public ChosenMetric(String id, String name, Expression expression) {
		this.id = id;
		this.name = name;
		this.expression = expression;
	}

	public ChosenMetric(Expression expression) {
		this.expression = expression;
	}

	/**
	 **/
	public ChosenMetric expression(Expression expression) {
		this.expression = expression;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("expression")
	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
