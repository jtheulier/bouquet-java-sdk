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
package com.squid.kraken.v4.model;

import com.google.gson.annotations.SerializedName;

import io.bouquet.v4.ApiException;
import io.bouquet.v4.client.APIUtils;
import io.swagger.annotations.ApiModelProperty;

/**
 * ProjectAnalysisJobPK
 */

public class ProjectAnalysisJobPK extends ProjectPK  {

	@SerializedName("analysisJobId")
	private String analysisJobId = null;

	public ProjectAnalysisJobPK analysisJobId(String analysisJobId) {
		this.analysisJobId = analysisJobId;
		return this;
	}

	/**
	 * Get analysisJobId
	 * @return analysisJobId
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getAnalysisJobId() {
		return analysisJobId;
	}

	public void setAnalysisJobId(String analysisJobId) {
		this.analysisJobId = analysisJobId;
	}
	@Override
	public String getApiUri(boolean listAllObjects) throws ApiException {
		String localVarPath = "";
		localVarPath = super.getApiUri(false);
		localVarPath = localVarPath + getEndPoint();
		// create path and map variables
		if (!listAllObjects && this.getId() == null) {
			throw new ApiException("Identifier for object(s) on " + getEndPoint()  + " is null");
		}
		if (getId() != null) {
			localVarPath = localVarPath + "/" + APIUtils.escapeString(getId());
		}
		return localVarPath;
	}


	private String getEndPoint() {
		return "/analysisjobs";
	}

	private String getId() {
		return analysisJobId;
	}

}

