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
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.bouquet.v4.ApiClient;
import io.bouquet.v4.ApiException;
import io.bouquet.v4.api.ModelApi;
import io.bouquet.v4.client.CacheConfiguration;
import io.bouquet.v4.client.ClientEngine;
import io.bouquet.v4.client.LoginConfiguration;
import io.bouquet.v4.client.ProjectConfiguration;
import io.bouquet.v4.model.Bookmark;
import io.bouquet.v4.model.Project;
import io.bouquet.v4.model.ProjectAnalysisJob;

/**
 * Refresh caches for a given project Steps are :
 * - Invalidate project caches
 * - Scan domains to reload indexed dimensions
 * - Compute the analysis for every shared bookmark Ex of config as argument: {\"url\":\"https://............/release/v4.2\",\"customerId\":\"************\",\"clientId\":\"dashboard\",\"login\":\"**********\",\"password\":\"*********\",\"redirectUrl\":null,\"accessType\":null,\"projectId\":\"***********   \"}
 *
 *
 */

public class ReloadProject extends ClientEngine {

	static String projectDisplayName = "Reload projects after restart";

	static Logger logger = Logger.getLogger(ReloadProject.class);

	public ReloadProject() {
		String loggerFile = "log4j.conf";
		System.out.println("Logger properties in " + loggerFile);
		PropertyConfigurator.configure(loggerFile);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println( clientConfiguration.toJson());
		ReloadProject ds = new ReloadProject();

		LoginConfiguration clientConfiguration = null;
		ProjectConfiguration projectConfiguration = null;
		CacheConfiguration cacheConfiguration = null;
		boolean hasError = false;
		if (args.length >= 3) {
			clientConfiguration = LoginConfiguration.fromJson(args[1]);
			projectConfiguration = ProjectConfiguration.fromJson(args[2]);
			if (args.length >= 4) {
				cacheConfiguration = CacheConfiguration.fromJson(args[3]);
			}
			try {
				ds.run(args[0], clientConfiguration, projectConfiguration, cacheConfiguration);
			} catch (InterruptedException | ApiException | IOException e) {
				e.printStackTrace();
				hasError = true;
			}
		} else {
			hasError = true;
		}
		if (hasError) {
			System.exit(1);
		} else {
			System.exit(0);
		}
	}

	public void run(String baseUrl, LoginConfiguration clientConfiguration, ProjectConfiguration projectConfiguration, CacheConfiguration cacheConfiguration) throws ApiException, JsonParseException, JsonMappingException, IOException, InterruptedException {
		ApiClient sourceClient = ApiClient.buildClient(baseUrl);
		sourceClient.setConnectTimeout(0);
		ModelApi api = new ModelApi(sourceClient, clientConfiguration);
		Project project = api.getProject(projectConfiguration.getProjectId(), true);
		// logger.debug("Start refresh for project");

		Bookmark bookmark = api.getBookmark(projectConfiguration.getProjectId(), "570e095ec942c00417033e08", true);
		api.getDomain(projectConfiguration.getProjectId(), bookmark.getConfig().getDomain(), true);

		ProjectAnalysisJob analysis = buildAnalysisFromBookmark(api, bookmark, true, cacheConfiguration.getDefaultComparePeriod());
		analysis.setLimit(new Long(1000));
		analysis = api.putAnalysisJob(analysis.getId().getProjectId(), analysis, 10000, 100, 1, true, null, null);
		getAnalysisJobResults(api, analysis, 10000, 1000, 1, false, null, null, 3);
		boolean refreshDomains = true;
		if (project != null) {
			refreshBookmarks(api, project, refreshDomains);
		}
	}

	private void refreshBookmarks(ModelApi api, Project project, boolean refreshDomains) throws ApiException, InterruptedException {
		boolean hasError = false;
		List<String> refreshedDomains = new ArrayList<String>();
		for (Bookmark bookmark : project.getBookmarks()) {
			if (bookmark.getPath() != null && bookmark.getPath().startsWith("/SHARED") && bookmark.getConfig() != null) {
				try {
					if (refreshDomains && refreshedDomains.contains(bookmark.getConfig().getDomain()) == false) {
						logger.debug("Refresh domain " + bookmark.getConfig().getDomain());
						api.getDomain(bookmark.getId().getProjectId(), bookmark.getConfig().getDomain(), true);
						// api.refreshCache(project.getOid(), bookmark.getConfig().getDomain());
						refreshedDomains.add(bookmark.getConfig().getDomain());
					}

				} catch (ApiException ae) {
					hasError = true;
					logger.debug("Refresh domain " + bookmark.getPath() + "/" + bookmark.getConfig().getDomain() + " has errors: " + ae.getMessage() + " with " + ae.getResponseBody(), ae);
				}
			}
		}
		if (hasError) {
			throw new ApiException("Some domains could not be refreshed, please check logs");
		}
	}

}
