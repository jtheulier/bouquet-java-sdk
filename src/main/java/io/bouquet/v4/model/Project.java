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
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * Project
 */

public class Project extends VersionedBase  {
	@SerializedName("id")
	private ProjectPK id = null;

	@SerializedName("accessRights")
	private List<AccessRight> accessRights = new ArrayList<AccessRight>();

	@SerializedName("description")
	private String description = null;

	@SerializedName("dbUrl")
	private String dbUrl = null;

	@SerializedName("dbUser")
	private String dbUser = null;

	@SerializedName("dbPassword")
	private String dbPassword = null;

	@SerializedName("dbSchemas")
	private List<String> dbSchemas = new ArrayList<String>();

	@SerializedName("config")
	private Object config = null;

	@SerializedName("dbPasswordLength")
	private Integer dbPasswordLength = null;

	@SerializedName("dbVendorId")
	private String dbVendorId = null;

	@SerializedName("dbArguments")
	private Map<String, String> dbArguments = new HashMap<String, String>();

	@SerializedName("internalVersion")
	private Integer internalVersion = null;

	@SerializedName("domains")
	private List<Domain> domains = new ArrayList<Domain>();

	@SerializedName("usingInMemExt")
	private String usingInMemExt = null;

	@SerializedName("relations")
	private List<Relation> relations = new ArrayList<Relation>();

	@SerializedName("bookmarks")
	private List<Bookmark> bookmarks = new ArrayList<Bookmark>();

	@SerializedName("oid")
	private String oid = null;

	@SerializedName("objectType")
	private String objectType = null;

	@SerializedName("_children")
	private List<String> children = new ArrayList<String>();

	@SerializedName("name")
	private String name = null;

	@SerializedName("credentials")
	private Credentials credentials = null;

	public Project id(ProjectPK id) {
		this.id = id;
		return this;
	}

	/**
	 * The object Composite Id (Primary Key)
	 * @return id
	 **/
	@ApiModelProperty(example = "null", value = "The object Composite Id (Primary Key)")
	public ProjectPK getId() {
		return id;
	}

	public void setId(ProjectPK id) {
		this.id = id;
	}

	public Project accessRights(List<AccessRight> accessRights) {
		this.accessRights = accessRights;
		return this;
	}

	public Project addAccessRightsItem(AccessRight accessRightsItem) {
		this.accessRights.add(accessRightsItem);
		return this;
	}

	/**
	 * The ACL for this object
	 * @return accessRights
	 **/
	@ApiModelProperty(example = "null", value = "The ACL for this object")
	public List<AccessRight> getAccessRights() {
		return accessRights;
	}

	public void setAccessRights(List<AccessRight> accessRights) {
		this.accessRights = accessRights;
	}

	public Project description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Get description
	 * @return description
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Project dbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
		return this;
	}

	/**
	 * The DataBase JDBC URL (requires WRITE role to view)
	 * @return dbUrl
	 **/
	@ApiModelProperty(example = "null", value = "The DataBase JDBC URL (requires WRITE role to view)")
	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public Project dbUser(String dbUser) {
		this.dbUser = dbUser;
		return this;
	}

	/**
	 * The DataBase JDBC user (requires WRITE role to view)
	 * @return dbUser
	 **/
	@ApiModelProperty(example = "null", value = "The DataBase JDBC user (requires WRITE role to view)")
	public String getDbUser() {
		return dbUser;
	}

	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}

	public Project dbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
		return this;
	}

	/**
	 * The DataBase JDBC password (write-only)
	 * @return dbPassword
	 **/
	@ApiModelProperty(example = "null", value = "The DataBase JDBC password (write-only)")
	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	public Project dbSchemas(List<String> dbSchemas) {
		this.dbSchemas = dbSchemas;
		return this;
	}

	public Project addDbSchemasItem(String dbSchemasItem) {
		this.dbSchemas.add(dbSchemasItem);
		return this;
	}

	/**
	 * The DataBase Schemas enabled (requires WRITE role). The list of available discovered Schemas can be found via the {projectId}/schemas-suggestion method
	 * @return dbSchemas
	 **/
	@ApiModelProperty(example = "null", value = "The DataBase Schemas enabled (requires WRITE role). The list of available discovered Schemas can be found via the {projectId}/schemas-suggestion method")
	public List<String> getDbSchemas() {
		return dbSchemas;
	}

	public void setDbSchemas(List<String> dbSchemas) {
		this.dbSchemas = dbSchemas;
	}

	public Project config(Hashtable<String, Object> config) {
		this.config = config;
		return this;
	}

	/**
	 * Deprecated : An optional configuration (json) object
	 * @return config
	 **/
	@ApiModelProperty(example = "null", value = "Deprecated : An optional configuration (json) object")
	public Object getConfig() {
		return config;
	}

	public void setConfig(Object config) {
		this.config = config;
	}

	/**
	 * The DataBase JDBC password length
	 * @return dbPasswordLength
	 **/
	@ApiModelProperty(example = "null", value = "The DataBase JDBC password length")
	public Integer getDbPasswordLength() {
		return dbPasswordLength;
	}

	public Project dbVendorId(String dbVendorId) {
		this.dbVendorId = dbVendorId;
		return this;
	}

	/**
	 * The DataBase vendor ID to use for connecting
	 * @return dbVendorId
	 **/
	@ApiModelProperty(example = "null", value = "The DataBase vendor ID to use for connecting")
	public String getDbVendorId() {
		return dbVendorId;
	}

	public void setDbVendorId(String dbVendorId) {
		this.dbVendorId = dbVendorId;
	}

	public Project dbArguments(Map<String, String> dbArguments) {
		this.dbArguments = dbArguments;
		return this;
	}

	public Project putDbArgumentsItem(String key, String dbArgumentsItem) {
		this.dbArguments.put(key, dbArgumentsItem);
		return this;
	}

	/**
	 * The DataBase JDBC URL arguments
	 * @return dbArguments
	 **/
	@ApiModelProperty(example = "null", value = "The DataBase JDBC URL arguments")
	public Map<String, String> getDbArguments() {
		return dbArguments;
	}

	public void setDbArguments(Map<String, String> dbArguments) {
		this.dbArguments = dbArguments;
	}

	public Project internalVersion(Integer internalVersion) {
		this.internalVersion = internalVersion;
		return this;
	}

	/**
	 * Get internalVersion
	 * @return internalVersion
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Integer getInternalVersion() {
		return internalVersion;
	}

	public void setInternalVersion(Integer internalVersion) {
		this.internalVersion = internalVersion;
	}

	public Project domains(List<Domain> domains) {
		this.domains = domains;
		return this;
	}

	public Project addDomainsItem(Domain domainsItem) {
		this.domains.add(domainsItem);
		return this;
	}

	/**
	 * Get domains
	 * @return domains
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<Domain> getDomains() {
		return domains;
	}

	public void setDomains(List<Domain> domains) {
		this.domains = domains;
	}

	public Project usingInMemExt(String usingInMemExt) {
		this.usingInMemExt = usingInMemExt;
		return this;
	}

	/**
	 * If the Project is using In Memory Extension
	 * @return usingInMemExt
	 **/
	@ApiModelProperty(example = "null", value = "If the Project is using In Memory Extension")
	public String getUsingInMemExt() {
		return usingInMemExt;
	}

	public void setUsingInMemExt(String usingInMemExt) {
		this.usingInMemExt = usingInMemExt;
	}

	public Project relations(List<Relation> relations) {
		this.relations = relations;
		return this;
	}

	public Project addRelationsItem(Relation relationsItem) {
		this.relations.add(relationsItem);
		return this;
	}

	/**
	 * Get relations
	 * @return relations
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<Relation> getRelations() {
		return relations;
	}

	public void setRelations(List<Relation> relations) {
		this.relations = relations;
	}

	public Project bookmarks(List<Bookmark> bookmarks) {
		this.bookmarks = bookmarks;
		return this;
	}

	public Project addBookmarksItem(Bookmark bookmarksItem) {
		this.bookmarks.add(bookmarksItem);
		return this;
	}

	/**
	 * Get bookmarks
	 * @return bookmarks
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<Bookmark> getBookmarks() {
		return bookmarks;
	}

	public void setBookmarks(List<Bookmark> bookmarks) {
		this.bookmarks = bookmarks;
	}

	/**
	 * The Object Id
	 * @return oid
	 **/
	@ApiModelProperty(example = "null", value = "The Object Id")
	public String getOid() {
		return oid;
	}

	/**
	 * Get objectType
	 * @return objectType
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getObjectType() {
		return objectType;
	}

	public Project children(List<String> children) {
		this.children = children;
		return this;
	}

	public Project addChildrenItem(String childrenItem) {
		this.children.add(childrenItem);
		return this;
	}

	/**
	 * Get children
	 * @return children
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<String> getChildren() {
		return children;
	}

	public void setChildren(List<String> children) {
		this.children = children;
	}

	public Project name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Get name
	 * @return name
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Credentials getCredentials() {
		return credentials;
	}

	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}

}

