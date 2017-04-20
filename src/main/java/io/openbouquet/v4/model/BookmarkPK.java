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
 * BookmarkPK
 */

public class BookmarkPK extends ProjectPK implements ApiPK  {

	@SerializedName("bookmarkId")
	private String bookmarkId = null;

	public BookmarkPK bookmarkId(String bookmarkId) {
		this.bookmarkId = bookmarkId;
		return this;
	}

	/**
	 * Get bookmarkId
	 * @return bookmarkId
	 **/
	@ApiModelProperty(example = "null", value = "")
	public String getBookmarkId() {
		return bookmarkId;
	}

	public void setBookmarkId(String bookmarkId) {
		this.bookmarkId = bookmarkId;
	}


	private String getEndPoint() {
		return "/bookmarks";
	}

	private String getId() {
		return bookmarkId;
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
}


