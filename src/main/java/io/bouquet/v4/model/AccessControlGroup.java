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
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class AccessControlGroup extends Base {

	public enum AccessLevel {
		EDITOR,   // allow to edit
		VIEWER,   // allow to view
		EXECUTE,  // allow to execute only
		NONE      // no access - use it to revoke access
	};

	private String name;

	private Map<String,AccessLevel> projectsGranted = new Hashtable<String,AccessLevel>();

	private List<String> accessRestrictionGroups = new ArrayList<String>();

	/**
	 *
	 */
	public AccessControlGroup() {
		// TODO Auto-generated constructor stub
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
	public Map<String,AccessLevel> getProjectGranted() {
		return projectsGranted;
	}

	public void setProjectGranted(Map<String,AccessLevel> projectGranted) {
		this.projectsGranted = projectGranted;
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
			return this.name.equals(((AccessControlGroup) o).getName());
		}
		return false;
	}

}
