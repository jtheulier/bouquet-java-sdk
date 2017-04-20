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
package io.bouquet.v4.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * FacetSelection
 */

public class FacetSelection extends Base  {
	@SerializedName("startIndex")
	private Long startIndex = null;

	@SerializedName("facets")
	private List<Facet> facets = new ArrayList<Facet>();

	@SerializedName("compareTo")
	private List<Facet> compareTo = new ArrayList<Facet>();

	@SerializedName("totalSize")
	private Long totalSize = null;

	public FacetSelection startIndex(Long startIndex) {
		this.startIndex = startIndex;
		return this;
	}

	/**
	 * Get startIndex
	 * @return startIndex
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Long getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Long startIndex) {
		this.startIndex = startIndex;
	}

	public FacetSelection facets(List<Facet> facets) {
		this.facets = facets;
		return this;
	}

	public FacetSelection addFacetsItem(Facet facetsItem) {
		this.facets.add(facetsItem);
		return this;
	}

	/**
	 * Get facets
	 * @return facets
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<Facet> getFacets() {
		return facets;
	}

	public void setFacets(List<Facet> facets) {
		this.facets = facets;
	}

	public FacetSelection compareTo(List<Facet> compareTo) {
		this.compareTo = compareTo;
		return this;
	}

	public FacetSelection addCompareToItem(Facet compareToItem) {
		this.compareTo.add(compareToItem);
		return this;
	}

	/**
	 * Get compareTo
	 * @return compareTo
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<Facet> getCompareTo() {
		return compareTo;
	}

	public void setCompareTo(List<Facet> compareTo) {
		this.compareTo = compareTo;
	}

	public FacetSelection totalSize(Long totalSize) {
		this.totalSize = totalSize;
		return this;
	}

	/**
	 * Get totalSize
	 * @return totalSize
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Long getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(Long totalSize) {
		this.totalSize = totalSize;
	}

}

