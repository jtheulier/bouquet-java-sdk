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
import io.bouquet.v4.client.CacheConfiguration.ClearAnalysis;
import io.bouquet.v4.client.CacheConfiguration.ClearFlag;
import io.bouquet.v4.client.CacheConfiguration.ComparePeriod;
import io.bouquet.v4.client.CacheConfiguration.RefreshType;
import io.bouquet.v4.model.Bookmark;
import io.bouquet.v4.model.DataTable;
import io.bouquet.v4.model.Dimension;
import io.bouquet.v4.model.Domain;
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

public class RefreshProject extends ClientEngine {

	static String projectDisplayName = "Refresh V4 facets & bookmarks";

	static Logger logger = Logger.getLogger(RefreshProject.class);

	public RefreshProject() {
		String loggerFile = "log4j.conf";
		System.out.println("Logger properties in " + loggerFile);
		PropertyConfigurator.configure(loggerFile);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System.out.println( clientConfiguration.toJson());
		RefreshProject ds = new RefreshProject();

		CacheConfiguration cacheConfiguration = null;
		LoginConfiguration clientConfiguration = null;
		boolean hasError = false;
		if (args.length == 2) {
			clientConfiguration = LoginConfiguration.fromJson(args[1]);
			cacheConfiguration = CacheConfiguration.fromJson(args[2]);
			try {
				ds.run(args[0], clientConfiguration, cacheConfiguration);
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

	public void run(String baseUrl, LoginConfiguration clientConfiguration, CacheConfiguration cacheConfiguration) throws ApiException, JsonParseException, JsonMappingException, IOException, InterruptedException {
		ApiClient sourceClient = ApiClient.buildClient(baseUrl);
		sourceClient.setConnectTimeout(0);
		ModelApi api = new ModelApi(sourceClient, clientConfiguration);
		Project project = api.getProject("myproject", true);
		// logger.debug("Start refresh for project");
		boolean refreshDomains = true;
		if (project != null) {
			if (cacheConfiguration.getClearFlag() == ClearFlag.TRUE) {
				api.releaseAllCaches(project.getOid());
				refreshDomains = false;
			}

			boolean hasError = false;
			if (cacheConfiguration.getRefreshType() == RefreshType.FACETS || cacheConfiguration.getRefreshType() == RefreshType.ALL) {
				try {
					refreshFacets(api, project, refreshDomains);
					// refreshDomains = false;
				} catch (ApiException ae) {
					hasError = true;
				}
			}

			if (cacheConfiguration.getRefreshType() == RefreshType.BOOKMARKS || cacheConfiguration.getClearAnalysis() == ClearAnalysis.TRUE || cacheConfiguration.getRefreshType() == RefreshType.ALL) {
				try {
					removeAnalyses(api, project);
					refreshDomains = false;
				} catch (ApiException ae) {
					hasError = true;
				}
			}

			if (cacheConfiguration.getRefreshType() == RefreshType.BOOKMARKS || cacheConfiguration.getRefreshType() == RefreshType.ALL) {
				try {
					refreshBookmarks(api, project, refreshDomains, cacheConfiguration.getDefaultComparePeriod());
					refreshDomains = false;
				} catch (ApiException ae) {
					hasError = true;
				}
			}
			if (hasError) {
				throw new ApiException("Some domains could not be refreshed, please check logs");
			}
		}
	}

	private void removeAnalyses(ModelApi api, Project project) throws ApiException, InterruptedException {
		List<ProjectAnalysisJob> jobs = api.getAnalysisJobs(project.getOid());
		for (ProjectAnalysisJob job : jobs) {
			if (job.getDomains() != null && job.getDomains().size() > 0) {
				boolean result = api.deleteAnalysisJob(job.getId().getProjectId(), job.getId().getAnalysisJobId());
				if (result == false) {
					logger.debug("Could not delete analysis job " + job.getId().getAnalysisJobId());
				}
			}
		}
	}

	private void refreshBookmarks(ModelApi api, Project project, boolean refreshDomains, ComparePeriod defaultComparePeriod) throws ApiException, InterruptedException {
		boolean hasError = false;
		int limit = 1000;
		List<String> refreshedDomains = new ArrayList<String>();
		for (Bookmark bookmark : project.getBookmarks()) {
			if (bookmark.getPath() != null && bookmark.getPath().startsWith("/SHARED") && bookmark.getConfig() != null) {
				try {
					if (refreshDomains && refreshedDomains.contains(bookmark.getConfig().getDomain()) == false) {
						logger.debug("Refresh domain " + bookmark.getConfig().getDomain());
						// api.refreshCache(project.getOid(), bookmark.getConfig().getDomain());
						refreshedDomains.add(bookmark.getConfig().getDomain());
					}

					logger.debug("Start to refresh Bookmark " + bookmark.getPath() + "/" + bookmark.getName());
					ProjectAnalysisJob analysis = buildAnalysisFromBookmark(api, bookmark, true, defaultComparePeriod);
					analysis.setLimit(new Long(limit));
					analysis = api.setAnalysisJob(analysis.getId().getProjectId(), analysis, 10000, limit, 1, true, null, null);
					Object analysisResult = getAnalysisJobResults(api, analysis, 10000, limit, 1, false, null, null, 3);

					analysis = buildAnalysisFromBookmark(api, bookmark, false, defaultComparePeriod);
					analysis.setLimit(new Long(limit));
					analysis = api.setAnalysisJob(analysis.getId().getProjectId(), analysis, 10000, limit, 1, true, null, null);
					analysisResult = getAnalysisJobResults(api, analysis, 10000, limit, 1, false, null, null, 3);
					if (analysisResult != null && analysisResult instanceof DataTable) {
						logger.debug("Bookmark detail & summary refreshed " + bookmark.getPath() + "/" + bookmark.getName());
					}

				} catch (ApiException ae) {
					hasError = true;
					logger.debug("Bookmark " + bookmark.getPath() + "/" + bookmark.getName() + " has errors: " + ae.getMessage() + " with " + ae.getResponseBody(), ae);
				}
			}
		}
		if (hasError) {
			throw new ApiException("Some bookmarks could not be refreshed, please check logs");
		}
	}

	private void refreshFacets(ModelApi api, Project project, boolean refreshDomains) throws ApiException, InterruptedException {
		boolean hasError = false;
		for (Domain domain : api.getDomains(project.getOid())) {
			String domainId = domain.getOid();
			if (domain.isDynamic() == false) {
				try {
					if (refreshDomains) {
						logger.debug("Refresh domain " + domain.getName());
						api.releaseDomainCache(project.getOid(), domainId);
					} else {
						logger.debug("Processing domain " + domain.getName());
					}
					domain = api.getDomain(project.getOid(), domainId, true);
					List<Dimension> dimensions = api.getDimensions(project.getOid(), domain.getOid());
					executeFacetJob(api, domain, dimensions, true);
				} catch (ApiException ae) {
					hasError = true;
					logger.debug("Domain " + domain.getName() + " has errors", ae);
				}
			}
		}
		if (hasError) {
			throw new ApiException("Some domains could not be refreshed, please check logs");
		}
	}
}
