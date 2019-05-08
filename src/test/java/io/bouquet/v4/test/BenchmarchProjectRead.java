/*******************************************************************************
 * Copyright 2017 julien@squidsolutions.com
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package io.bouquet.v4.test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.squid.kraken.v4.model.Bookmark;
import com.squid.kraken.v4.model.ChosenMetric;
import com.squid.kraken.v4.model.Dimension;
import com.squid.kraken.v4.model.Domain;
import com.squid.kraken.v4.model.DomainPK;
import com.squid.kraken.v4.model.Expression;
import com.squid.kraken.v4.model.Metric;
import com.squid.kraken.v4.model.Project;
import com.squid.kraken.v4.model.ReferencePK;
import com.squid.kraken.v4.model.Relation;
import io.bouquet.v4.ApiClient;
import io.bouquet.v4.ApiException;
import io.bouquet.v4.api.ModelApi;
import io.bouquet.v4.client.ClientEngine;
import io.bouquet.v4.client.LoginConfiguration;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.joda.time.DateTime;

/**
 * Simple class wich will read all availailable projects created
 * select 'drop table '||schemaname||'.'||tablename||';' from pg_tables where tablename like '%old%' or tablename like
 * '%tmp%' or tablename like '%temp%' order by 1;
 *
 * @author jtheulier
 */
public class BenchmarchProjectRead extends ClientEngine {
  static String projectDisplayName = "Refresh V4 facets & bookmarks";

  Logger logger = Logger.getLogger(BenchmarchProjectRead.class);

  boolean dryRun = false;

  public BenchmarchProjectRead() {
    String loggerFile = "log4j.conf";
    System.out.println("Logger properties in " + loggerFile);
    PropertyConfigurator.configure(loggerFile);
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    // System.out.println( clientConfiguration.toJson());

    BenchmarchProjectRead ds = new BenchmarchProjectRead();

    try {
      LoginConfiguration clientConfiguration = LoginConfiguration.fromJson(args[1]);
      ds.runperf(args[0], clientConfiguration);

    } catch (InterruptedException | ApiException | IOException e) {
      e.printStackTrace();
    }

  }

  public void run(String baseURL, LoginConfiguration clientConfiguration)
      throws ApiException, JsonParseException, JsonMappingException, IOException, InterruptedException {
    ApiClient sourceClient = ApiClient.buildClient(baseURL);
    sourceClient.setConnectTimeout(0);
    ModelApi api = new ModelApi(sourceClient, clientConfiguration);
    List<Project> projects = api.getProjects();
    for (Project project : projects) {

      if (project.getId().getProjectId().equals("proquest_counter")
          || project.getId().getProjectId().equals("56d568b7c942c0388b8627fa")) {
        cleanDynamicObjects(api, project);
        // addNameToMetrics(api, project);
        // api.getProject(project.getId().getProjectId(), true);
      }
    }
  }

  public void runperf(String baseURL, LoginConfiguration clientConfiguration)
      throws ApiException, JsonParseException, JsonMappingException, IOException, InterruptedException {
    ApiClient sourceClient = ApiClient.buildClient(baseURL);
    sourceClient.setConnectTimeout(0);
    ModelApi api = new ModelApi(sourceClient, clientConfiguration);
    List<Project> projects = api.getProjects();
    for (Project project : projects) {
      if (project.getId().getProjectId().equals("proquest_counter")) {
        readProjectContent(api, project);
      }
    }
    logger.info("Start test");
    for (int i = 0; i < 5; i++) {
      DateTime d1 = new DateTime();
      for (Project project : projects) {
        if (project.getId().getProjectId().equals("proquest_counter")) {
          readProjectContent(api, project);
        }
      }
      DateTime d2 = new DateTime();

      logger.info("End Iteration " + i + " in " + (d2.getMillis() - d1.getMillis()) / 1000.00f);
    }

  }

  public void readProjectContent(ModelApi api, Project project) throws ApiException {
    for (Domain domain : api.getDomains(project.getId().getProjectId())) {
      if (domain.isDynamic() == false) {
        for (Dimension dimension : api.getDimensions(domain.getId().getProjectId(), domain.getId().getDomainId())) {
          if (dimension.isDynamic() == false) {
            try {
              api.getDimension(dimension.getId().getProjectId(), dimension.getId().getDomainId(),
                  dimension.getId().getDimensionId(), true);
            } catch (ApiException ae) {
              // ae.printStackTrace();
            }
          }
        }
        for (Metric metric : api.getMetrics(domain.getId().getProjectId(), domain.getId().getDomainId())) {
          if (metric.isDynamic() == false) {
            try {
              api.getMetric(metric.getId().getProjectId(), metric.getId().getDomainId(), metric.getId().getMetricId(),
                  true);
            } catch (ApiException ae) {
              // ae.printStackTrace();
            }
          }
        }
      }
    }
  }

  public void cleanDynamicObjects(ModelApi api, Project project) throws ApiException {
    for (Relation object : api.getRelations(project.getId().getProjectId())) {
      if (object.isDynamic()) {
        logger.info("Found dynamic relation " + object.getName());
        if (dryRun == false) {
          try {
            api.deleteRelation(object.getId().getProjectId(), object.getId().getRelationId());
          } catch (ApiException ae) {
            ae.printStackTrace();
          }
        }
      }
    }
    List<Domain> domains = api.getDomains(project.getId().getProjectId());
    List<DomainPK> domainIds = new ArrayList<DomainPK>();
    for (Domain domain : domains) {
      domainIds.add(domain.getId());
    }
    project = api.getProject(project.getId().getProjectId(), true);
    for (Domain object : project.getDomains()) {
      int index = domainIds.indexOf(object.getId());
      Domain object2 = null;
      if (index != -1) {
        object2 = domains.get(index);
        if (object2.getId().getDomainId().equals(object.getId().getDomainId()) == false) {
          throw new ApiException("invalid");
        }
      }
      if (object2 != null && object2.isDynamic()) {
        logger.info("Found dynamic domain " + object.getName());
        if (dryRun == false) {
          try {
            api.deleteDomain(object.getId().getProjectId(), object.getId().getDomainId());
          } catch (ApiException ae) {
            ae.printStackTrace();
          }
        }
      } else {
        if (index == -1) {
          logger.info("Going to delete " + object.getName());
          if (dryRun == false) {
            try {
              api.deleteDomain(object.getId().getProjectId(), object.getId().getDomainId());
            } catch (ApiException ae) {
              ae.printStackTrace();
            }
          }
        }
      }
    }

  }

  public void addNameToMetrics(ModelApi api, Project project) throws ApiException {
    for (Bookmark bookmark : api.getBookmarks(project.getId().getProjectId())) {
      for (ChosenMetric metric : bookmark.getConfig().getChosenMetrics()) {
        Expression expr = metric.getExpression();
        if (expr != null) {
          for (@SuppressWarnings("rawtypes")
          ReferencePK ref : expr.getReferences()) {
            Object o = ref.getReference();
            System.out.println(o.toString());
          }
        } else {
          System.out.println("expr is null");
        }
      }

    }

  }

}
