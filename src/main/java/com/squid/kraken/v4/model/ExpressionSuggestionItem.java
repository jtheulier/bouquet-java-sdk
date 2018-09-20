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

import io.swagger.annotations.ApiModelProperty;

/**
 * ExpressionSuggestionItem
 */

public class ExpressionSuggestionItem extends Base  {
	@SerializedName("display")
	private String display = null;

	@SerializedName("description")
	private String description = null;

	@SerializedName("caption")
	private String caption = null;

	@SerializedName("ranking")
	private Integer ranking = null;

	@SerializedName("suggestion")
	private String suggestion = null;

	/**
	 * Gets or Sets objectType
	 */
	public enum ObjectTypeEnum {
		@SerializedName("TABLE")
		TABLE("TABLE"),

		@SerializedName("COLUMN")
		COLUMN("COLUMN"),

		@SerializedName("FOREIGNKEY")
		FOREIGNKEY("FOREIGNKEY"),

		@SerializedName("RELATION")
		RELATION("RELATION"),

		@SerializedName("DOMAIN")
		DOMAIN("DOMAIN"),

		@SerializedName("DIMENSION")
		DIMENSION("DIMENSION"),

		@SerializedName("METRIC")
		METRIC("METRIC"),

		@SerializedName("EXPRESSION")
		EXPRESSION("EXPRESSION"),

		@SerializedName("FUNCTION")
		FUNCTION("FUNCTION");

		private String value;

		ObjectTypeEnum(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}

	@SerializedName("objectType")
	private ObjectTypeEnum objectType = null;

	/**
	 * Gets or Sets valueType
	 */
	public enum ValueTypeEnum {
		@SerializedName("OBJECT")
		OBJECT("OBJECT"),

		@SerializedName("NUMERIC")
		NUMERIC("NUMERIC"),

		@SerializedName("AGGREGATE")
		AGGREGATE("AGGREGATE"),

		@SerializedName("DATE")
		DATE("DATE"),

		@SerializedName("STRING")
		STRING("STRING"),

		@SerializedName("CONDITION")
		CONDITION("CONDITION"),

		@SerializedName("LINK")
		LINK("LINK"),

		@SerializedName("TABLE")
		TABLE("TABLE"),

		@SerializedName("VIEW")
		VIEW("VIEW"),

		@SerializedName("DOMAIN")
		DOMAIN("DOMAIN"),

		@SerializedName("OTHER")
		OTHER("OTHER"),

		@SerializedName("ERROR")
		ERROR("ERROR");

		private String value;

		ValueTypeEnum(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}

	@SerializedName("valueType")
	private ValueTypeEnum valueType = null;

	@SerializedName("folder")
	private String folder = null;

	public ExpressionSuggestionItem display(String display) {
		this.display = display;
		return this;
	}

	/**
	 * Get display
	 * @return display
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public ExpressionSuggestionItem description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Get description
	 * @return description
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ExpressionSuggestionItem caption(String caption) {
		this.caption = caption;
		return this;
	}

	/**
	 * Get caption
	 * @return caption
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public ExpressionSuggestionItem ranking(Integer ranking) {
		this.ranking = ranking;
		return this;
	}

	/**
	 * Get ranking
	 * @return ranking
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Integer getRanking() {
		return ranking;
	}

	public void setRanking(Integer ranking) {
		this.ranking = ranking;
	}

	public ExpressionSuggestionItem suggestion(String suggestion) {
		this.suggestion = suggestion;
		return this;
	}

	/**
	 * Get suggestion
	 * @return suggestion
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	public ExpressionSuggestionItem objectType(ObjectTypeEnum objectType) {
		this.objectType = objectType;
		return this;
	}

	/**
	 * Get objectType
	 * @return objectType
	 **/
	@ApiModelProperty(example = "null", value = "")
	public ObjectTypeEnum getObjectType() {
		return objectType;
	}

	public void setObjectType(ObjectTypeEnum objectType) {
		this.objectType = objectType;
	}

	public ExpressionSuggestionItem valueType(ValueTypeEnum valueType) {
		this.valueType = valueType;
		return this;
	}

	/**
	 * Get valueType
	 * @return valueType
	 **/
	@ApiModelProperty(example = "null", value = "")
	public ValueTypeEnum getValueType() {
		return valueType;
	}

	public void setValueType(ValueTypeEnum valueType) {
		this.valueType = valueType;
	}

	public ExpressionSuggestionItem folder(String folder) {
		this.folder = folder;
		return this;
	}

	/**
	 * Get folder
	 * @return folder
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

}

