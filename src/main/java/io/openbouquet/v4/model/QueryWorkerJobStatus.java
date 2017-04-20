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

import io.swagger.annotations.ApiModelProperty;

/**
 * QueryWorkerJobStatus
 */

public class QueryWorkerJobStatus extends Base  {
	/**
	 * Gets or Sets status
	 */
	public enum StatusEnum {
		@SerializedName("EXECUTING")
		EXECUTING("EXECUTING"),

		@SerializedName("READING")
		READING("READING"),

		@SerializedName("INDEXING")
		INDEXING("INDEXING");

		private String value;

		StatusEnum(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}

	@SerializedName("status")
	private StatusEnum status = null;

	@SerializedName("userID")
	private String userID = null;

	@SerializedName("projectPK")
	private ProjectPK projectPK = null;

	@SerializedName("jobID")
	private String jobID = null;

	@SerializedName("key")
	private String key = null;

	@SerializedName("start")
	private Long start = null;

	@SerializedName("elapse")
	private Long elapse = null;

	@SerializedName("lineRead")
	private Long lineRead = null;

	@SerializedName("chunks")
	private Integer chunks = null;

	@SerializedName("sql")
	private String sql = null;

	@SerializedName("elaspeTime")
	private String elaspeTime = null;

	@SerializedName("id")
	private Integer id = null;

	@SerializedName("startTime")
	private String startTime = null;

	public QueryWorkerJobStatus status(StatusEnum status) {
		this.status = status;
		return this;
	}

	/**
	 * Get status
	 * @return status
	 **/
	@ApiModelProperty(example = "null", value = "")
	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public QueryWorkerJobStatus userID(String userID) {
		this.userID = userID;
		return this;
	}

	/**
	 * Get userID
	 * @return userID
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public QueryWorkerJobStatus projectPK(ProjectPK projectPK) {
		this.projectPK = projectPK;
		return this;
	}

	/**
	 * Get projectPK
	 * @return projectPK
	 **/
	@ApiModelProperty(example = "null", value = "")
	public ProjectPK getProjectPK() {
		return projectPK;
	}

	public void setProjectPK(ProjectPK projectPK) {
		this.projectPK = projectPK;
	}

	public QueryWorkerJobStatus jobID(String jobID) {
		this.jobID = jobID;
		return this;
	}

	/**
	 * Get jobID
	 * @return jobID
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getJobID() {
		return jobID;
	}

	public void setJobID(String jobID) {
		this.jobID = jobID;
	}

	public QueryWorkerJobStatus key(String key) {
		this.key = key;
		return this;
	}

	/**
	 * Get key
	 * @return key
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public QueryWorkerJobStatus start(Long start) {
		this.start = start;
		return this;
	}

	/**
	 * Get start
	 * @return start
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Long getStart() {
		return start;
	}

	public void setStart(Long start) {
		this.start = start;
	}

	public QueryWorkerJobStatus elapse(Long elapse) {
		this.elapse = elapse;
		return this;
	}

	/**
	 * Get elapse
	 * @return elapse
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Long getElapse() {
		return elapse;
	}

	public void setElapse(Long elapse) {
		this.elapse = elapse;
	}

	public QueryWorkerJobStatus lineRead(Long lineRead) {
		this.lineRead = lineRead;
		return this;
	}

	/**
	 * Get lineRead
	 * @return lineRead
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Long getLineRead() {
		return lineRead;
	}

	public void setLineRead(Long lineRead) {
		this.lineRead = lineRead;
	}

	public QueryWorkerJobStatus chunks(Integer chunks) {
		this.chunks = chunks;
		return this;
	}

	/**
	 * Get chunks
	 * @return chunks
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Integer getChunks() {
		return chunks;
	}

	public void setChunks(Integer chunks) {
		this.chunks = chunks;
	}

	public QueryWorkerJobStatus sql(String sql) {
		this.sql = sql;
		return this;
	}

	/**
	 * Get sql
	 * @return sql
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public QueryWorkerJobStatus elaspeTime(String elaspeTime) {
		this.elaspeTime = elaspeTime;
		return this;
	}

	/**
	 * Get elaspeTime
	 * @return elaspeTime
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getElaspeTime() {
		return elaspeTime;
	}

	public void setElaspeTime(String elaspeTime) {
		this.elaspeTime = elaspeTime;
	}

	public QueryWorkerJobStatus id(Integer id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * @return id
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public QueryWorkerJobStatus startTime(String startTime) {
		this.startTime = startTime;
		return this;
	}

	/**
	 * Get startTime
	 * @return startTime
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
}

