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

public class AccessControlGroup extends Base {

	public enum AccessLevel {
		EDITOR("EDITOR","Editor"),   // allow to edit
		VIEWER("VIEWER","Viewer"),   // allow to view
		EXECUTE("EXECUTE","Execute"),  // allow to execute only
		NONE("NONE","None");     // no access - use it to revoke access

		private java.lang.String name;

		private java.lang.String id;

		private static final Map<String, AccessLevel> byId = new HashMap<String, AccessLevel>();
		static {
			for (AccessLevel e : AccessLevel.values()) {
				if (byId.put(e.getId(), e) != null) {
					throw new IllegalArgumentException("duplicate id: " + e.getId());
				}
			}
		}

		public static AccessLevel getById(String id) {
			return byId.get(id);
		}

		AccessLevel(String id, String name) {
			this.id = id;
			this.name = name;
		}

		public java.lang.String getName() {
			return name;
		}

		public String getId() {
			return id;
		}

	};

	private AccessControlGroupPK id;

	private String name;

	private List<SharedProject> sharedProjects = new ArrayList<SharedProject>();

	private List<String> accessRestrictionGroups = new ArrayList<String>();

	/**
	 *
	 */
	public AccessControlGroup() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * The object Composite Id (Primary Key)
	 **/
	public AccessControlGroup id(AccessControlGroupPK id) {
		this.id = id;
		return this;
	}

	@ApiModelProperty(example = "null", value = "The object Composite Id (Primary Key)")
	public AccessControlGroupPK getId() {
		return id;
	}
	public void setId(AccessControlGroupPK id) {
		this.id = id;
	}

	/**
	 * return this access control group name; this is the name used to identified the ACG in the user definition provided by the SSO server
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * get the list of project to grant access to the SSO users. A project is identified by its unique ID.
	 * @return
	 */
	public List<SharedProject> getSharedProjects() {
		return sharedProjects;
	}

	public void setSharedProjects(List<SharedProject> sharedProjects) {
		this.sharedProjects = sharedProjects;
	}

	/**
	 * return the list of special group that implements access restrictions. Any user created in this access control group will have to comply with those restrictions.
	 * @return the accessRestrictionGroups
	 */
	public List<String> getAccessRestrictionGroups() {
		return accessRestrictionGroups;
	}

	/**
	 * @param accessRestrictionGroups the accessRestrictionGroups to set
	 */
	public void setAccessRestrictionGroups(List<String> accessRestrictionGroups) {
		this.accessRestrictionGroups = accessRestrictionGroups;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof AccessControlGroup) {
			return this.id.equals(((AccessControlGroup) o).getId());
		}
		return false;
	}
}
