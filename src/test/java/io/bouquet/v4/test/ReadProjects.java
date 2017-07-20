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
package io.bouquet.v4.test;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.bouquet.v4.ApiClient;
import io.bouquet.v4.ApiException;
import io.bouquet.v4.api.ModelApi;
import io.bouquet.v4.client.ClientEngine;
import io.bouquet.v4.client.LoginConfiguration;
import io.bouquet.v4.model.Bookmark;
import io.bouquet.v4.model.ChoosenMetric;
import io.bouquet.v4.model.Domain;
import io.bouquet.v4.model.Expression;
import io.bouquet.v4.model.Project;
import io.bouquet.v4.model.ReferencePKObject;
import io.bouquet.v4.model.Relation;

/**
 * Simple class wich will read all availailable projects created
 *
 *
 * @author jtheulier
 *
 */
public class ReadProjects extends ClientEngine {
	static String projectDisplayName = "Refresh V4 facets & bookmarks";

	Logger logger = Logger.getLogger(ReadProjects.class);

	public ReadProjects() {
		String loggerFile = "log4j.conf";
		System.out.println("Logger properties in " + loggerFile);
		PropertyConfigurator.configure(loggerFile);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println( clientConfiguration.toJson());

		ReadProjects ds = new ReadProjects();

		try {
			LoginConfiguration clientConfiguration = LoginConfiguration.fromJson(args[1]);
			ds.run(args[0], clientConfiguration);

		} catch (InterruptedException | ApiException | IOException e) {
			e.printStackTrace();
		}

	}

	public void run(String baseURL, LoginConfiguration clientConfiguration) throws ApiException, JsonParseException, JsonMappingException, IOException, InterruptedException {
		ApiClient sourceClient = ApiClient.buildClient(baseURL);
		sourceClient.setConnectTimeout(0);
		ModelApi api = new ModelApi(sourceClient, clientConfiguration);
		List<Project> projects = api.getProjects();
		for (Project project:projects) {
			logger.info("Found project " + project.getName() + " with id "+project.getId().getProjectId());
			if (project.getId().getProjectId().equals("proquest_counter")) {
				//cleanDynamicObjects(api, project);
				addNameToMetrics(api, project);
			}
		}
	}

	public void cleanDynamicObjects(ModelApi api, Project project) throws ApiException {
		for (Relation object : api.getRelations(project.getId().getProjectId())) {
			if (object.isDynamic()) {
				logger.info("Found dynamic relation " + object.getName());
				try {
					api.deleteRelation(object.getId().getProjectId(), object.getId().getRelationId());
				} catch (ApiException ae){
					ae.printStackTrace();
				}
			}
		}
		for (Domain object: api.getDomains(project.getId().getProjectId())) {
			object =  api.getDomain(object.getId().getProjectId(), object.getId().getDomainId(), true);
			if (object.isDynamic()) {
				logger.info("Found dynamic domain " + object.getName());
				try {
					api.deleteDomain(object.getId().getProjectId(), object.getId().getDomainId());
				} catch (ApiException ae){
					ae.printStackTrace();
				}
			}
		}
	}

	public void addNameToMetrics(ModelApi api, Project project) throws ApiException {
		for (Bookmark bookmark:api.getBookmarks(project.getId().getProjectId())) {
			for (ChoosenMetric metric: bookmark.getConfig().getChosenMetrics()) {
				Expression expr = metric.getExpression();
				for (ReferencePKObject ref:expr.getReferences()) {
					Object o = ref.getReference();
					System.out.println(o.toString());
				}
			}

		}

	}
}
