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

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * Facet
 */

@JsonIgnoreProperties({"dataType"})
public class Facet extends Base {
	@SerializedName("items")
	private List<? extends FacetMember> items = new ArrayList<FacetMember>();

	@SerializedName("selectedItems")
	private List<? extends FacetMember> selectedItems = new ArrayList<FacetMember>();

	@SerializedName("dimension")
	private Dimension dimension = null;

	@SerializedName("name")
	private String name = null;

	@SerializedName("id")
	private String id = null;

	@SerializedName("hasMore")
	private Boolean hasMore = false;

	@SerializedName("error")
	private Boolean error = false;

	@SerializedName("errorMessage")
	private String errorMessage = null;

	@SerializedName("proxy")
	private Boolean proxy = false;

	@SerializedName("totalSize")
	private Integer totalSize = null;

	@SerializedName("compositeName")
	private Boolean compositeName = false;

	@SerializedName("done")
	private Boolean done = false;

	public Facet items(List<? extends FacetMember> items) {
		this.items = items;
		return this;
	}

	/**
	 * Get items
	 * 
	 * @return items
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<? extends FacetMember> getItems() {
		return items;
	}

	public void setItems(List<? extends FacetMember> items) {
		this.items = items;
	}

	public Facet selectedItems(List<? extends FacetMember> selectedItems) {
		this.selectedItems = selectedItems;
		return this;
	}

	/**
	 * Get selectedItems
	 * 
	 * @return selectedItems
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<? extends FacetMember> getSelectedItems() {
		return selectedItems;
	}

	public void setSelectedItems(List<? extends FacetMember> selectedItems) {
		this.selectedItems = selectedItems;
	}

	public Facet dimension(Dimension dimension) {
		this.dimension = dimension;
		return this;
	}

	/**
	 * Get dimension
	 * 
	 * @return dimension
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public Facet name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Get name
	 * 
	 * @return name
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Facet id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * 
	 * @return id
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Facet hasMore(Boolean hasMore) {
		this.hasMore = hasMore;
		return this;
	}

	/**
	 * Get hasMore
	 * 
	 * @return hasMore
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Boolean isHasMore() {
		return hasMore;
	}

	public void setHasMore(Boolean hasMore) {
		this.hasMore = hasMore;
	}

	public Facet error(Boolean error) {
		this.error = error;
		return this;
	}

	/**
	 * Get error
	 * 
	 * @return error
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Boolean isError() {
		return error;
	}

	public void setError(Boolean error) {
		this.error = error;
	}

	public Facet errorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		return this;
	}

	/**
	 * Get errorMessage
	 * 
	 * @return errorMessage
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Facet proxy(Boolean proxy) {
		this.proxy = proxy;
		return this;
	}

	/**
	 * Get proxy
	 * 
	 * @return proxy
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Boolean isProxy() {
		return proxy;
	}

	public void setProxy(Boolean proxy) {
		this.proxy = proxy;
	}

	public Facet totalSize(Integer totalSize) {
		this.totalSize = totalSize;
		return this;
	}

	/**
	 * Get totalSize
	 * 
	 * @return totalSize
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Integer getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}

	public Facet compositeName(Boolean compositeName) {
		this.compositeName = compositeName;
		return this;
	}

	/**
	 * Get compositeName
	 * 
	 * @return compositeName
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Boolean isCompositeName() {
		return compositeName;
	}

	public void setCompositeName(Boolean compositeName) {
		this.compositeName = compositeName;
	}

	public Facet done(Boolean done) {
		this.done = done;
		return this;
	}

	/**
	 * Get done
	 * 
	 * @return done
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Boolean isDone() {
		return done;
	}

	public void setDone(Boolean done) {
		this.done = done;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		return this.getDimension().getId()
				.equals(((Facet) o).getDimension().getId());
	}

}
