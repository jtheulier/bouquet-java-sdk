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
package io.openbouquet.v4.model;

import com.google.gson.annotations.SerializedName;

import io.openbouquet.v4.ApiException;
import io.openbouquet.v4.client.APIUtils;
import io.swagger.annotations.ApiModelProperty;

/**
 * MetricPK
 */

public class MetricPK extends DomainPK  {
	@SerializedName("metricId")
	private String metricId = null;

	/**
	 * Get metricId
	 * @return metricId
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getMetricId() {
		return metricId;
	}

	public void setMetricId(String metricId) {
		this.metricId = metricId;
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
		return "/metrics";
	}

	private String getId() {
		return metricId;
	}
}

