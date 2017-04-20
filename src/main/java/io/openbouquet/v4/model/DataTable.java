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

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * DataTable
 */

public class DataTable extends Base  {
	@SerializedName("startIndex")
	private Long startIndex = null;

	@SerializedName("cols")
	private List<Col> cols = new ArrayList<Col>();

	@SerializedName("rows")
	private List<Row> rows = new ArrayList<Row>();

	@SerializedName("objectType")
	private String objectType = null;

	@SerializedName("fromCache")
	private Boolean fromCache = false;

	@SerializedName("fromSmartCache")
	private Boolean fromSmartCache = false;

	@SerializedName("executionDate")
	private String executionDate = null;

	@SerializedName("fullset")
	private Boolean fullset = false;

	@SerializedName("totalSize")
	private Long totalSize = null;

	public DataTable startIndex(Long startIndex) {
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

	public DataTable cols(List<Col> cols) {
		this.cols = cols;
		return this;
	}

	public DataTable addColsItem(Col colsItem) {
		this.cols.add(colsItem);
		return this;
	}

	/**
	 * Get cols
	 * @return cols
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<Col> getCols() {
		return cols;
	}

	public void setCols(List<Col> cols) {
		this.cols = cols;
	}

	public DataTable rows(List<Row> rows) {
		this.rows = rows;
		return this;
	}

	public DataTable addRowsItem(Row rowsItem) {
		this.rows.add(rowsItem);
		return this;
	}

	/**
	 * Get rows
	 * @return rows
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<Row> getRows() {
		return rows;
	}

	public void setRows(List<Row> rows) {
		this.rows = rows;
	}

	public DataTable objectType(String objectType) {
		this.objectType = objectType;
		return this;
	}

	/**
	 * Get objectType
	 * @return objectType
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public DataTable fromCache(Boolean fromCache) {
		this.fromCache = fromCache;
		return this;
	}

	/**
	 * Get fromCache
	 * @return fromCache
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Boolean isFromCache() {
		return fromCache;
	}

	public void setFromCache(Boolean fromCache) {
		this.fromCache = fromCache;
	}

	public DataTable fromSmartCache(Boolean fromSmartCache) {
		this.fromSmartCache = fromSmartCache;
		return this;
	}

	/**
	 * Get fromSmartCache
	 * @return fromSmartCache
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Boolean isFromSmartCache() {
		return fromSmartCache;
	}

	public void setFromSmartCache(Boolean fromSmartCache) {
		this.fromSmartCache = fromSmartCache;
	}

	public DataTable executionDate(String executionDate) {
		this.executionDate = executionDate;
		return this;
	}

	/**
	 * Get executionDate
	 * @return executionDate
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getExecutionDate() {
		return executionDate;
	}

	public void setExecutionDate(String executionDate) {
		this.executionDate = executionDate;
	}

	public DataTable fullset(Boolean fullset) {
		this.fullset = fullset;
		return this;
	}

	/**
	 * Get fullset
	 * @return fullset
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Boolean isFullset() {
		return fullset;
	}

	public void setFullset(Boolean fullset) {
		this.fullset = fullset;
	}

	public DataTable totalSize(Long totalSize) {
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

