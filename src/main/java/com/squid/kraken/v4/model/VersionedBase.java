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
import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

public class VersionedBase extends RoleBase {

	@SerializedName("_vctrl")
	@JsonProperty("_vctrl")
	private Integer vctrl = null;

	/**
	 * Internal version control value. (used by optimistic-locking mechanism)
	 * 
	 * @return vctrl
	 **/
	@ApiModelProperty(example = "null", value = "Internal version control value. (used by optimistic-locking mechanism)")
	public Integer getVctrl() {
		return vctrl;
	}

	public void setVctrl(Integer vctrl) {
		this.vctrl = vctrl;
	}
}
