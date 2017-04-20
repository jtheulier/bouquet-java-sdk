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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.ApiModelProperty;

public class User extends VersionedBase  {

	private UserPK id = null;
	private List<AccessRight> accessRights = new ArrayList<AccessRight>();
	private String login = null;
	private String email = null;
	private List<String> groups = new ArrayList<String>();
	private Map<String, String> attributes = new HashMap<String, String>();
	private String oid = null;
	private String objectType = null;

	/**
	 * The object Composite Id (Primary Key)
	 **/
	public User id(UserPK id) {
		this.id = id;
		return this;
	}

	@ApiModelProperty(example = "null", value = "The object Composite Id (Primary Key)")
	public UserPK getId() {
		return id;
	}
	public void setId(UserPK id) {
		this.id = id;
	}


	/**
	 * The ACL for this object
	 **/
	public User accessRights(List<AccessRight> accessRights) {
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


	/**
	 **/
	public User login(String login) {
		this.login = login;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}


	/**
	 **/
	public User email(String email) {
		this.email = email;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 **/
	public User groups(List<String> groups) {
		this.groups = groups;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	public List<String> getGroups() {
		return groups;
	}
	public void setGroups(List<String> groups) {
		this.groups = groups;
	}


	/**
	 **/
	public User attributes(Map<String, String> attributes) {
		this.attributes = attributes;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	public Map<String, String> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}


	@ApiModelProperty(example = "null", value = "The Object Id")
	public String getOid() {
		return oid;
	}


	@ApiModelProperty(example = "null", value = "")
	public String getObjectType() {
		return objectType;
	}

}

