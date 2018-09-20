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
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public class CustomerInfo extends RoleBase  {

	private String id = null;
	private String defaultLocale = null;
	private List<AccessRight> accessRights = new ArrayList<AccessRight>();
	private String awsclientId = null;
	private List<Client> clients = new ArrayList<Client>();
	private List<Project> projects = new ArrayList<Project>();
	private List<UserGroup> userGroups = new ArrayList<UserGroup>();
	private List<User> users = new ArrayList<User>();
	private List<State> states = new ArrayList<State>();
	private String objectType = null;

	private String name = null;

	private String description;

	private String teamId;

	private String publicUrl;

	private Map<String, List<String>> oauthEndPoints;

	private List<AccessControlGroup> accessControlGroups;

	//private SubscriptionStatus subscriptionStatus;

	private int accessTokenExpiration;

	private String preferedTeamOwner;

	private String privateCertificate;

	private String publicCertificate;

	/**
	 **/
	public CustomerInfo id(String id) {
		this.id = id;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("id")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}


	/**
	 **/
	public CustomerInfo defaultLocale(String defaultLocale) {
		this.defaultLocale = defaultLocale;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("defaultLocale")
	public String getDefaultLocale() {
		return defaultLocale;
	}
	public void setDefaultLocale(String defaultLocale) {
		this.defaultLocale = defaultLocale;
	}


	/**
	 **/
	public CustomerInfo accessRights(List<AccessRight> accessRights) {
		this.accessRights = accessRights;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("accessRights")
	public List<AccessRight> getAccessRights() {
		return accessRights;
	}
	public void setAccessRights(List<AccessRight> accessRights) {
		this.accessRights = accessRights;
	}


	/**
	 **/
	public CustomerInfo awsclientId(String awsclientId) {
		this.awsclientId = awsclientId;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("awsclientId")
	public String getAwsclientId() {
		return awsclientId;
	}
	public void setAwsclientId(String awsclientId) {
		this.awsclientId = awsclientId;
	}


	/**
	 **/
	public CustomerInfo clients(List<Client> clients) {
		this.clients = clients;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("clients")
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}


	/**
	 **/
	public CustomerInfo projects(List<Project> projects) {
		this.projects = projects;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("projects")
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}


	/**
	 **/
	public CustomerInfo userGroups(List<UserGroup> userGroups) {
		this.userGroups = userGroups;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("userGroups")
	public List<UserGroup> getUserGroups() {
		return userGroups;
	}
	public void setUserGroups(List<UserGroup> userGroups) {
		this.userGroups = userGroups;
	}


	/**
	 **/
	public CustomerInfo users(List<User> users) {
		this.users = users;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("users")
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}


	/**
	 **/
	public CustomerInfo states(List<State> states) {
		this.states = states;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("states")
	public List<State> getStates() {
		return states;
	}
	public void setStates(List<State> states) {
		this.states = states;
	}


	/**
	 **/
	public CustomerInfo objectType(String objectType) {
		this.objectType = objectType;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("objectType")
	public String getObjectType() {
		return objectType;
	}
	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}
	/**
	 **/
	public CustomerInfo name(String name) {
		this.name = name;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	/**
	 **/
	public  CustomerInfo description(String description) {
		this.description = description;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 **/
	public CustomerInfo teamId(String teamId) {
		this.teamId = teamId;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("teamId")
	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	/**
	 **/
	public CustomerInfo publicUrl(String publicUrl) {
		this.publicUrl = publicUrl;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("publicUrl")
	public String getPublicUrl() {
		return publicUrl;
	}

	public void setPublicUrl(String publicUrl) {
		this.publicUrl = publicUrl;
	}

	/**
	 **/
	public CustomerInfo accessControlGroups(List<AccessControlGroup> accessControlGroups) {
		this.accessControlGroups = accessControlGroups;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("accessControlGroups")
	public List<AccessControlGroup> getAccessControlGroups() {
		return accessControlGroups;
	}

	public void setAccessControlGroups(List<AccessControlGroup> accessControlGroups) {
		this.accessControlGroups = accessControlGroups;
	}

	/**
	 **/
	public CustomerInfo accessTokenExpiration(int accessTokenExpiration) {
		this.accessTokenExpiration = accessTokenExpiration;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("accessTokenExpiration")
	public int getAccessTokenExpiration() {
		return accessTokenExpiration;
	}

	public void setAccessTokenExpiration(int accessTokenExpiration) {
		this.accessTokenExpiration = accessTokenExpiration;
	}

	/**
	 **/
	public CustomerInfo preferedTeamOwner(String preferedTeamOwner) {
		this.preferedTeamOwner = preferedTeamOwner;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("preferedTeamOwner")
	public String getPreferedTeamOwner() {
		return preferedTeamOwner;
	}

	public void setPreferedTeamOwner(String preferedTeamOwner) {
		this.preferedTeamOwner = preferedTeamOwner;
	}

	/**
	 **/
	public CustomerInfo privateCertificate(String privateCertificate) {
		this.privateCertificate = privateCertificate;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("privateCertificate")
	public String getPrivateCertificate() {
		return privateCertificate;
	}

	public void setPrivateCertificate(String privateCertificate) {
		this.privateCertificate = privateCertificate;
	}

	/**
	 **/
	public CustomerInfo publicCertificate(String publicCertificate) {
		this.publicCertificate = publicCertificate;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("publicCertificate")
	public String getPublicCertificate() {
		return publicCertificate;
	}

	public void setPublicCertificate(String publicCertificate) {
		this.publicCertificate = publicCertificate;
	}

	/**
	 **/
	public CustomerInfo oauthEndPoints(Map<String, List<String>> oauthEndPoints) {
		this.oauthEndPoints = oauthEndPoints;
		return this;
	}

	@ApiModelProperty(example = "null", value = "")
	@JsonProperty("oauthEndPoints")
	public Map<String, List<String>> getOauthEndPoints() {
		return oauthEndPoints;
	}

	public void setOauthEndPoints(Map<String, List<String>> oauthEndPoints) {
		this.oauthEndPoints = oauthEndPoints;
	}
}

