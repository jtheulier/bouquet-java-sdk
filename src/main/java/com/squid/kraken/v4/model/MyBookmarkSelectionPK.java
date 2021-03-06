/*******************************************************************************
 * Copyright © Squid Solutions, 2016
 * This file is part of Open Bouquet software.
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation (version 3 of the License).
 * There is a special FOSS exception to the terms and conditions of the
 * licenses as they are applied to this program. See LICENSE.txt in
 * the directory of this program distribution.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * Squid Solutions also offers commercial licenses with additional warranties,
 * professional functionalities or services. If you purchase a commercial
 * license, then it supersedes and replaces any other agreement between
 * you and Squid Solutions (above licenses and LICENSE.txt included).
 * See http://www.squidsolutions.com/EnterpriseBouquet/
 *******************************************************************************/
package com.squid.kraken.v4.model;

import io.bouquet.v4.ApiException;
import io.bouquet.v4.client.APIUtils;
import io.swagger.annotations.ApiModelProperty;

/**
 * Bookmark holds a project configuration
 */
public class MyBookmarkSelectionPK extends BookmarkPK {

  private String myBookmarkSelectionId;

  public MyBookmarkSelectionPK myBookmarkSelectionId(String myBookmarkSelectionId) {
    this.myBookmarkSelectionId = myBookmarkSelectionId;
    return this;
  }

  /**
   * Get myBookmarkSelectionId
   * 
   * @return myBookmarkSelectionId
   **/
  @ApiModelProperty(example = "null", value = "")
  public String getMyBookmarkSelectionId() {
    return myBookmarkSelectionId;
  }

  public void setMyBookmarkSelectionId(String myBookmarkSelectionId) {
    this.myBookmarkSelectionId = myBookmarkSelectionId;
  }

  @Override
  public String getApiUri(boolean listAllObjects) throws ApiException {
    String localVarPath = "";
    localVarPath = super.getApiUri(false);
    localVarPath = localVarPath + getEndPoint();
    // create path and map variables
    if (!listAllObjects && this.getId() == null) {
      throw new ApiException("Identifier for object(s) on " + getEndPoint() + " is null");
    }
    if (getId() != null) {
      localVarPath = localVarPath + "/" + APIUtils.escapeString(getId());
    }
    return localVarPath;
  }


  private String getEndPoint() {
    return "/myselections";
  }

  private String getId() {
    return myBookmarkSelectionId;
  }
}
