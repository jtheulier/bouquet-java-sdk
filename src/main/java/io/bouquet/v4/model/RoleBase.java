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

public class RoleBase extends Base {

	/**
	 * The role of the current User (passed in the context) over this object
	 */
	public enum RoleEnum {
		@SerializedName("NONE")
		NONE("NONE"),

		@SerializedName("EXECUTE")
		EXECUTE("EXECUTE"),

		@SerializedName("READ")
		READ("READ"),

		@SerializedName("WRITE")
		WRITE("WRITE"),

		@SerializedName("OWNER")
		OWNER("OWNER");

		private String value;

		RoleEnum(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}

	@SerializedName("_role")
	private RoleEnum role = null;
	/**
	 * The role of the current User (passed in the context) over this object
	 * @return role
	 **/
	@ApiModelProperty(example = "null", value = "The role of the current User (passed in the context) over this object")
	public RoleEnum getRole() {
		return role;
	}
	public void setRole(RoleEnum role) {
		this.role = role;
	}
}
