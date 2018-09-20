package com.squid.kraken.v4.model;

import com.squid.kraken.v4.model.AccessControlGroup.AccessLevel;

public class SharedProject {

	String projectId;
	String groupId;
	String role;
	String projectName;
	AccessLevel accessLevel;

	public SharedProject() {

	}

	public SharedProject(String projectId, AccessLevel accessLevel) {
		this.projectId = projectId;
		this.accessLevel = accessLevel;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public AccessLevel getAccessLevel() {
		return accessLevel;
	}
	public void setAccessLevel(AccessLevel accessLevel) {
		this.accessLevel = accessLevel;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof SharedProject) {
			if (this.projectId == null && ((SharedProject)o).getProjectId() != null) {
				return false;
			}
			return (this.projectId.equals(((SharedProject)o).getProjectId()) && this.getAccessLevel() == ((SharedProject)o).getAccessLevel());
		}
		return false;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}
