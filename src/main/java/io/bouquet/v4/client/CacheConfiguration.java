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

import java.io.IOException;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class CacheConfiguration extends ProjectConfiguration implements Serializable {

	public enum RefreshType {
		FACETS, BOOKMARKS, ALL
	};

	public enum ClearFlag {
		TRUE, FALSE
	};

	public enum ClearAnalysis {
		TRUE, FALSE
	};

	public enum ComparePeriod {
		__NONE, __COMPARE_TO_PREVIOUS_YEAR
	};

	public final static ComparePeriod COMPAREPERIODNONE = ComparePeriod.__NONE;
	/**
	 *
	 */
	private static final long serialVersionUID = 6318591534411668339L;

	private RefreshType refreshType = RefreshType.ALL;
	private ClearFlag clearFlag = ClearFlag.FALSE;
	private ClearAnalysis clearAnalysis = ClearAnalysis.TRUE;
	private ComparePeriod defaultComparePeriod = COMPAREPERIODNONE;

	public CacheConfiguration(@JsonProperty("projectId") String projectId, @JsonProperty("refreshType") String refreshType, @JsonProperty("clearFlag") String clearFlag, @JsonProperty("comparePeriodDefault") String defaultComparePeriod,
			@JsonProperty("clearAnalysis") String clearAnalysis) {
		super(projectId);
		if (refreshType != null) {
			this.refreshType = RefreshType.valueOf(refreshType);
		}
		if (clearAnalysis != null) {
			this.clearAnalysis = ClearAnalysis.valueOf(clearAnalysis.toUpperCase());
		}
		if (defaultComparePeriod != null) {
			this.defaultComparePeriod = ComparePeriod.valueOf(defaultComparePeriod.toUpperCase());
		}
	}

	public RefreshType getRefreshType() {
		return refreshType;
	}

	public ClearFlag getClearFlag() {
		return clearFlag;
	}

	public ClearAnalysis getClearAnalysis() {
		return clearAnalysis;
	}

	@Override
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

	public static CacheConfiguration fromJson(String json) {
		ObjectMapper mapper = new ObjectMapper();

		CacheConfiguration client = null;
		try {
			client = mapper.readValue(json, CacheConfiguration.class);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return client;
	}

	public ComparePeriod getDefaultComparePeriod() {
		return defaultComparePeriod;
	}
}
