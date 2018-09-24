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
package io.bouquet.v4.client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import com.squid.kraken.v4.model.Bookmark;
import com.squid.kraken.v4.model.ChosenMetric;
import com.squid.kraken.v4.model.Dimension;
import com.squid.kraken.v4.model.Dimension.TypeEnum;
import com.squid.kraken.v4.model.Domain;
import com.squid.kraken.v4.model.DomainPK;
import com.squid.kraken.v4.model.Expression;
import com.squid.kraken.v4.model.Facet;
import com.squid.kraken.v4.model.FacetExpression;
import com.squid.kraken.v4.model.FacetMember;
import com.squid.kraken.v4.model.FacetMemberInterval;
import com.squid.kraken.v4.model.FacetSelection;
import com.squid.kraken.v4.model.Metric;
import com.squid.kraken.v4.model.OrderBy;
import com.squid.kraken.v4.model.OrderBy.DirectionEnum;
import com.squid.kraken.v4.model.ProjectAnalysisJob;
import com.squid.kraken.v4.model.ProjectAnalysisJobPK;
import com.squid.kraken.v4.model.ProjectFacetJob;
import com.squid.kraken.v4.model.ProjectFacetJobPK;
import com.squid.kraken.v4.model.RollUp;

import io.bouquet.v4.ApiException;
import io.bouquet.v4.api.ModelApi;
import io.bouquet.v4.client.CacheConfiguration.ComparePeriod;

public class ClientEngine {

	Logger logger = Logger.getLogger(ClientEngine.class);

	public ClientEngine() {
		super();
	}

	public void writeAnalysisResult(InputStream in, OutputStream out) throws ApiException, IOException, FileNotFoundException {
		if (in != null && out != null) {
			try {
				IOUtils.copy(in, out);
			} finally {
				try {
					in.close();
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public Object getAnalysisJobResults(ModelApi api, ProjectAnalysisJob analysis, Integer timeout, Integer maxResults, Integer startIndex, Boolean lazy, String format, String compression, int maxLoops) throws ApiException {
		boolean done = false;
		int loops = 0;
		String projectId = null;
		String jobId = null;
		Object result = null;
		if (analysis != null) {
			projectId = analysis.getId().getProjectId();
			jobId = analysis.getId().getAnalysisJobId();
			while (!done) {
				// Launch the execution
				result = api.getAnalysisJobResults(projectId, jobId, timeout, maxResults, startIndex, lazy, format, compression);
				ProjectAnalysisJob analysisJob = api.getAnalysisJob(projectId, jobId, null, 10000);
				loops++;
				if (result != null || (analysisJob != null && analysisJob.getStatus() != null && analysisJob.getStatus() == ProjectAnalysisJob.StatusEnum.DONE)) {
					done = true;
					if (result instanceof ApiException) {
						if (((ApiException) result).getMessage() == "COMPUTING_IN_PROGRESS") {
							result = api.getAnalysisJobResults(projectId, jobId, timeout, maxResults, startIndex, lazy, format, compression);
						}
					}
					return result;
				} else {
					if (loops > maxLoops) {
						done = true;
					} else {
						synchronized (this) {
							try {
								this.wait(60 * 1000);
							} catch (InterruptedException ie) {
								// TODO Auto-generated catch block
								throw new ApiException(ie);
							}
						}
					}
				}
			}
		}
		return null;
	}

	public boolean executeFacetJob(ModelApi api, Domain domain, List<Dimension> dimensions, boolean wait) throws ApiException, InterruptedException {
		ProjectFacetJob job = new ProjectFacetJob();
		job.setDomains(Arrays.asList(domain.getId()));
		ProjectFacetJobPK facetJobId = new ProjectFacetJobPK();
		job.setId(facetJobId);
		facetJobId.setProjectId(domain.getId().getProjectId());
		job = api.postFacetJob(domain.getId().getProjectId(), job, null);
		List<Facet> remainingFacets = job.getResults().getFacets();
		int retry = 120;
		if (!wait) {
			retry = 1;
			wait = true;
		}
		if (wait) {
			int facetsNr = 0;
			Domain facetsDomain = api.getDomain(domain.getId().getProjectId(), domain.getId().getDomainId(), false);
			while (retry > 0) {
				// job = api.getOrStoreFacetJob(domain.getProjectId(),
				// job.getId().getFacetJobId(), null, null);
				// job = api.putFacetJob(domain.getProjectId(), job, null);
				if (job.getStatus() == ProjectFacetJob.StatusEnum.DONE) {
					List<Facet> computingFacets = new ArrayList<Facet>();
					if (job.getError() == null) {
						computingFacets.clear();
						computingFacets.addAll(remainingFacets);
						for (Facet facet : remainingFacets) {
							String facetName = facet.getName();
							try {
								facet = api.getFacet(domain.getId().getProjectId(), job.getId().getFacetJobId(), facet.getId(), null, 10, 10, 0);
								if (facet.isProxy() != null && facet.isProxy()) {
									logger.debug("Proxied facet '" + facetName + "'");
									computingFacets.remove(facet);
								} else if (facet.isError() != null && facet.isError() == false && (facet.isDone() == true)) {
									if (facet.getDimension() != null && facet.getDimension().getType() == TypeEnum.CATEGORICAL) {
										logger.debug("Facet '" + facetName + "' done");
									}
									computingFacets.remove(facet);
								} else if (facet.isDone() == true && facet.isHasMore() == false && facet.isError() == true) {
									logger.debug("Facet '" + facetName + "' in error " + facet.getErrorMessage());
									computingFacets.remove(facet);
								} else if (retry == 1) {
									logger.debug("Ongoing processing on facet '" + facetName + "'");
								}
							} catch (ApiException ae) {
								logger.debug("Error occured while checking facet '" + facetName + "' :" + ae.getMessage());
								throw ae;
							}
						}
						facetsNr = computingFacets.size();
						remainingFacets.clear();
						remainingFacets.addAll(computingFacets);
						if (facetsNr == 0) {
							retry = 0;
						}
					} else {
						retry = 0;
					}
				}
				if (retry > 1) {
					synchronized (this) {
						this.wait(5 * 1000L);
					}
				}
				retry--;
			}
			if (job.getStatus() != ProjectFacetJob.StatusEnum.DONE) {

				logger.debug("Processing facet job " + job.getStatus() + " on domain" + facetsDomain.getName());
			} else if (facetsNr > 0) {
				logger.debug("Leaving facet job processing on domain " + facetsDomain.getName() + " with " + facetsNr + " still running");
			}
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public ProjectAnalysisJob buildAnalysisFromBookmark(ModelApi api, Bookmark bookmark, boolean isSummary, ComparePeriod defaultComparePeriod) throws ApiException, InterruptedException {

		if (bookmark != null) {
			ProjectAnalysisJob analysis = new ProjectAnalysisJob();

			DomainPK domain = api.getDomain(bookmark.getId().getProjectId(), bookmark.getConfig().getDomain(), false).getId();
			// executeFacetJob(api, domain, false);

			FacetSelection selection = new FacetSelection();
			if (bookmark.getConfig() != null && bookmark.getConfig().getSelection() != null) {
				selection.setFacets(bookmark.getConfig().getSelection().getFacets());
				selection.setRootFacets(bookmark.getConfig().getSelection().getRootFacets());
				selection.setCompareTo(bookmark.getConfig().getSelection().getCompareTo());
			}
			if ((selection.getCompareTo() == null || selection.getCompareTo().size() == 0) && defaultComparePeriod != ComparePeriod.__NONE && bookmark.getConfig().getPeriod() != null) {
				if (bookmark.getConfig().getPeriod().any() != null && bookmark.getConfig().getPeriod().any().size() == 1) {
					FacetMemberInterval compare = new FacetMemberInterval();
					compare.setType("i");
					compare.setLowerBound(defaultComparePeriod.toString());
					compare.setUpperBound(defaultComparePeriod.toString());
					Facet facet = new Facet();
					Dimension dim = api.getDimension(bookmark.getId().getProjectId(), bookmark.getConfig().getDomain(), APIUtils.splitDomainObject(bookmark.getConfig().getPeriod().any().values().iterator().next())[1], true);
					facet.setDimension(dim);
					facet.setName(dim.getName());
					facet.setId("@'" + bookmark.getConfig().getDomain() + "'.@'" + dim.getOid() + "'");
					facet.setSelectedItems(new ArrayList<FacetMember>(Arrays.asList(compare)));
					facet.setError(false);
					facet.setHasMore(false);
					facet.setDone(true);
					selection.setCompareTo(new ArrayList<Facet>(Arrays.asList(facet)));
				}
			}
			if (selection.getCompareTo() != null && selection.getCompareTo().size() > 0)

			{
				analysis.setOptionKeys(new HashMap<String, Object>() {
					private static final long serialVersionUID = 8372602286359963290L;
					{
						put("formatResults", true);
						put("computeGrowth", true);
					}
				});
			}
			analysis.setSelection(selection);

			analysis.setAutoRun(false);

			List<DomainPK> domains = new ArrayList<DomainPK>();
			domains.add(domain);
			analysis.setDomains(domains);

			List<FacetExpression> facets = new ArrayList<FacetExpression>();
			List<String> dims = bookmark.getConfig().getChosenDimensions();

			List<RollUp> rollups = new ArrayList<RollUp>();
			List<OrderBy> orderBys = new ArrayList<OrderBy>();
			if ("timeAnalysis".equals(bookmark.getConfig().getCurrentAnalysis()) && bookmark.getConfig().getPeriod() != null)

			{
				Map<String, String> periods = bookmark.getConfig().getPeriod().any();
				if (periods != null) {
					FacetExpression expression = new FacetExpression();
					Entry<String, String> period = periods.entrySet().iterator().next();
					expression.setValue("TO_DATE(" + period.getValue() + ")");
					facets.add(expression);
					OrderBy timeOrder = new OrderBy();
					timeOrder.col(0);
					timeOrder.direction(DirectionEnum.DESC);
					orderBys.add(timeOrder);
				}
			}
			if (isSummary == false && dims != null)

			{
				for (String dim : dims) {
					FacetExpression expression = new FacetExpression();
					expression.setValue(dim);
					facets.add(expression);
				}
			}
			analysis.setFacets(facets);
			if (bookmark.getConfig().getRollUps() != null)

			{
				rollups.addAll(bookmark.getConfig().getRollUps());
			}

			List<OrderBy> bookmarkOrderBys = bookmark.getConfig().getOrderBy();
			if (orderBys != null && bookmarkOrderBys != null)

			{
				for (OrderBy orderBy : bookmarkOrderBys) {
					if (orderBy.getCol() != null || orderBy.getExpression().getValue() != null) {
						orderBys.add(orderBy);
					}
				}
			}

			ProjectAnalysisJobPK analysisJobPK = new ProjectAnalysisJobPK();
			analysisJobPK.setProjectId(bookmark.getId().getProjectId());
			analysis.setId(analysisJobPK);
			// Do not define an id to let it temporary
			List<String> mets = bookmark.getConfig().getAvailableMetrics();
			ArrayList<Metric> metrics = new ArrayList<Metric>();
			if (isSummary)

			{
				if (bookmark.getConfig().getConfig() != null && bookmark.getConfig().getConfig().containsKey("kpiMetrics")) {
					mets = (List<String>) bookmark.getConfig().getConfig().get("kpiMetrics");
				}
				if (mets != null) {
					for (String met : mets) {
						if (met != null) {
							Metric metric = api.getMetric(bookmark.getId().getProjectId(), domain.getDomainId(), met, false);
							if (metric == null) {
								throw new ApiException("Invalid metric Id " + met);
							}
							metric.getAccessRights().clear();
							metrics.add(metric);
						}
					}
					analysis.setMetricList(metrics);
				}
				analysis.setOptionKeys(new HashMap<String, Object>() {
					private static final long serialVersionUID = -3511263422949970083L;
					{
						put("formatResults", true);
						put("computeGrowth", true);
					}
				});
			} else {
				analysis.setOrderBy(orderBys);
				analysis.setRollups(rollups);
				List<ChosenMetric> choosens = bookmark.getConfig().getChosenMetrics();
				if (mets == null) {
					mets = new ArrayList<String>();
					for (ChosenMetric choosen : choosens) {
						mets.add(choosen.getId());
					}
				}
				if (choosens != null) {
					for (String met : mets) {
						for (ChosenMetric choosen : choosens) {
							if (met.equals(choosen.getId())) {
								if (choosen.getId() != null && choosen.getId().indexOf("@") == -1) {
									Metric metric = api.getMetric(bookmark.getId().getProjectId(), domain.getDomainId(), choosen.getId(), false);
									if (metric == null) {
										throw new ApiException("Invalid metric Id " + met);
									}
									metric.getAccessRights().clear();
									metrics.add(metric);
								} else if (choosen.getId() != null) {
									Metric metric = new Metric();
									metric.setExpression(new Expression().value(choosen.getId()));
									metric.setDynamic(false);
									metrics.add(metric);
								} else if (choosen.getExpression() != null) {
									Metric metric = new Metric();
									metric.setExpression(choosen.getExpression());
									metric.setDynamic(false);
									metrics.add(metric);
								}
							}
						}
					}
					analysis.setMetricList(metrics);
				}
			}
			return analysis;

		}
		return null;
	}

}