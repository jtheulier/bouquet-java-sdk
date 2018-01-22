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
 * AccessRight
 */

public class AccessRight extends RoleBase  {

	@SerializedName("role")
	private RoleEnum role = null;

	@SerializedName("userId")
	private String userId = null;

	@SerializedName("groupId")
	private String groupId = null;

	public AccessRight role(RoleEnum role) {
		this.role = role;
		return this;
	}

	/**
	 * Get role
	 * @return role
	 **/
	@Override
	@ApiModelProperty(example = "null", value = "")
	public RoleEnum getRole() {
		return role;
	}

	@Override
	public void setRole(RoleEnum role) {
		this.role = role;
	}

	public AccessRight userId(String userId) {
		this.userId = userId;
		return this;
	}

	/**
	 * Get userId
	 * @return userId
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public AccessRight groupId(String groupId) {
		this.groupId = groupId;
		return this;
	}

	/**
	 * Get groupId
	 * @return groupId
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
}

