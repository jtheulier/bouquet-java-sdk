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
package io.openbouquet.v4.test;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.openbouquet.v4.ApiClient;
import io.openbouquet.v4.ApiException;
import io.openbouquet.v4.api.ModelApi;
import io.openbouquet.v4.client.LoginConfiguration;
import io.openbouquet.v4.client.ClientEngine;
import io.openbouquet.v4.model.Project;

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
			logger.info("Found project " + project.getName());
		}

	}
}
