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

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * ExpressionSuggestion
 */

public class ExpressionSuggestion extends Base  {
	@SerializedName("suggestions")
	private List<ExpressionSuggestionItem> suggestions = new ArrayList<ExpressionSuggestionItem>();

	@SerializedName("definitions")
	private List<String> definitions = new ArrayList<String>();

	@SerializedName("validateMessage")
	private String validateMessage = null;

	@SerializedName("filterIndex")
	private Integer filterIndex = null;

	@SerializedName("beginInsertPos")
	private Integer beginInsertPos = null;

	@SerializedName("endInsertPos")
	private Integer endInsertPos = null;

	@SerializedName("filter")
	private String filter = null;

	public ExpressionSuggestion suggestions(List<ExpressionSuggestionItem> suggestions) {
		this.suggestions = suggestions;
		return this;
	}

	public ExpressionSuggestion addSuggestionsItem(ExpressionSuggestionItem suggestionsItem) {
		this.suggestions.add(suggestionsItem);
		return this;
	}

	/**
	 * Get suggestions
	 * @return suggestions
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<ExpressionSuggestionItem> getSuggestions() {
		return suggestions;
	}

	public void setSuggestions(List<ExpressionSuggestionItem> suggestions) {
		this.suggestions = suggestions;
	}

	public ExpressionSuggestion definitions(List<String> definitions) {
		this.definitions = definitions;
		return this;
	}

	public ExpressionSuggestion addDefinitionsItem(String definitionsItem) {
		this.definitions.add(definitionsItem);
		return this;
	}

	/**
	 * Get definitions
	 * @return definitions
	 **/
	@ApiModelProperty(example = "null", value = "")
	public List<String> getDefinitions() {
		return definitions;
	}

	public void setDefinitions(List<String> definitions) {
		this.definitions = definitions;
	}

	public ExpressionSuggestion validateMessage(String validateMessage) {
		this.validateMessage = validateMessage;
		return this;
	}

	/**
	 * Get validateMessage
	 * @return validateMessage
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getValidateMessage() {
		return validateMessage;
	}

	public void setValidateMessage(String validateMessage) {
		this.validateMessage = validateMessage;
	}

	public ExpressionSuggestion filterIndex(Integer filterIndex) {
		this.filterIndex = filterIndex;
		return this;
	}

	/**
	 * Get filterIndex
	 * @return filterIndex
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Integer getFilterIndex() {
		return filterIndex;
	}

	public void setFilterIndex(Integer filterIndex) {
		this.filterIndex = filterIndex;
	}

	public ExpressionSuggestion beginInsertPos(Integer beginInsertPos) {
		this.beginInsertPos = beginInsertPos;
		return this;
	}

	/**
	 * Get beginInsertPos
	 * @return beginInsertPos
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Integer getBeginInsertPos() {
		return beginInsertPos;
	}

	public void setBeginInsertPos(Integer beginInsertPos) {
		this.beginInsertPos = beginInsertPos;
	}

	public ExpressionSuggestion endInsertPos(Integer endInsertPos) {
		this.endInsertPos = endInsertPos;
		return this;
	}

	/**
	 * Get endInsertPos
	 * @return endInsertPos
	 **/
	@ApiModelProperty(example = "null", value = "")
	public Integer getEndInsertPos() {
		return endInsertPos;
	}

	public void setEndInsertPos(Integer endInsertPos) {
		this.endInsertPos = endInsertPos;
	}

	public ExpressionSuggestion filter(String filter) {
		this.filter = filter;
		return this;
	}

	/**
	 * Get filter
	 * @return filter
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}
}

