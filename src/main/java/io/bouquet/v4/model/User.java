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
	private List<String> groupsAndUpgrades = new ArrayList<String>();
	private List<SharedProject> sharedProjects = new ArrayList<SharedProject>();
	private Map<String, String> attributes = new HashMap<String, String>();
	private String oid = null;
	private String objectType = null;
	private String password = null;
	private List<String> upgrades = new ArrayList<String>();
	private String givenName;
	private String familyName;
	private String authId;

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
	public User groupsAndUpgrades(List<String> groupsAndUpgrades) {
		this.groupsAndUpgrades = groupsAndUpgrades;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	public List<String> getGroupsAndUpgrades() {
		return groupsAndUpgrades;
	}
	public void setGroupsAndUpgrades(List<String> groupsAndUpgrades) {
		this.groupsAndUpgrades = groupsAndUpgrades;
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

	/**
	 **/
	public User password(String password) {
		this.password = password;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 **/
	public User upgrades(List<String> upgrades) {
		this.upgrades = upgrades;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	public List<String> getUpgrades() {
		return upgrades;
	}
	public void setUpgrades(List<String> upgrades) {
		this.upgrades = upgrades;
	}

	/**
	 **/
	public User givenName(String givenName) {
		this.givenName = givenName;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	/**
	 **/
	public User familyName(String familyName) {
		this.familyName = familyName;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public List<SharedProject> getSharedProjects() {
		return sharedProjects;
	}

	public void setSharedProjects(List<SharedProject> sharedProjects) {
		this.sharedProjects = sharedProjects;
	}

	/**
	 **/
	public User authId(String authId) {
		this.authId = authId;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	public String getAuthId() {
		return authId;
	}

	public void setAuthId(String authId) {
		this.authId = authId;
	}

}

