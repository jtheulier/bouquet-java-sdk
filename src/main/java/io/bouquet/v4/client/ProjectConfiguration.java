/*******************************************************************************
 * Copyright © Squid Solutions, 2016
 *
 *******************************************************************************/
package io.bouquet.v4.client;

import java.io.IOException;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProjectConfiguration implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -320183859314895095L;

	private final String projectId;

	public ProjectConfiguration(@JsonProperty("projectId") String projectId) {
		super();
		this.projectId = projectId;
	}

	public String getProjectId() {
		return projectId;
	}


	public String toJson() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static ProjectConfiguration fromJson(String json) {
		ObjectMapper mapper = new ObjectMapper();

		ProjectConfiguration client = null;
		try {
			client = mapper.readValue(json, ProjectConfiguration.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return client;
	}

}
