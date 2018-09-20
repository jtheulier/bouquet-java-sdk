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
 * Row
 */

public class Row extends Base  {
	@SerializedName("v")
	private List<Object> v = new ArrayList<Object>();

	public Row v(List<Object> v) {
		this.v = v;
		return this;
	}

	public Row addVItem(Object vItem) {
		this.v.add(vItem);
		return this;
	}

	/**
	 * Get v
	 * @return v
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<Object> getV() {
		return v;
	}

	public void setV(List<Object> v) {
		this.v = v;
	}


}

