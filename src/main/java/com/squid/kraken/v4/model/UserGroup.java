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

import io.swagger.annotations.ApiModelProperty;

public class UserGroup extends Base  {

	private UserGroupPK id = null;
	private List<AccessRight> accessRights = new ArrayList<AccessRight>();
	private String oid = null;
	private String objectType = null;


	public enum RoleEnum {
		NONE("NONE"),
		READ("READ"),
		WRITE("WRITE"),
		OWNER("OWNER");

		private String value;

		RoleEnum(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return value;
		}
	}

	private RoleEnum role = null;
	private String name = null;


	/**
	 * The object Composite Id (Primary Key)
	 **/
	public UserGroup id(UserGroupPK id) {
		this.id = id;
		return this;
	}

	@ApiModelProperty(example = "null", value = "The object Composite Id (Primary Key)")
	public UserGroupPK getId() {
		return id;
	}
	public void setId(UserGroupPK id) {
		this.id = id;
	}


	/**
	 * The ACL for this object
	 **/
	public UserGroup accessRights(List<AccessRight> accessRights) {
		this.accessRights = accessRights;
		return this;
	}

	@ApiModelProperty(example = "null", value = "The ACL for this object")
	public List<AccessRight> getAccessRights() {
		return accessRights;
	}
	public void setAccessRights(List<AccessRight> accessRights) {
		this.accessRights = accessRights;
	}


	@ApiModelProperty(example = "null", value = "The Object Id")
	public String getOid() {
		return oid;
	}


	@ApiModelProperty(example = "null", value = "")
	public String getObjectType() {
		return objectType;
	}


	@ApiModelProperty(example = "null", value = "The role of the current User (passed in the context) over this object")
	public RoleEnum getRole() {
		return role;
	}


	/**
	 **/
	public UserGroup name(String name) {
		this.name = name;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}

