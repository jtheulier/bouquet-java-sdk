/*******************************************************************************
 * Copyright © Squid Solutions, 2016
 *
 * This file is part of Open Bouquet software.
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the GNU Affero General
 * Public License as published by the Free Software Foundation (version 3 of the License).
 *
 * There is a special FOSS exception to the terms and conditions of the licenses as they are applied to this program.
 * See LICENSE.txt in the directory of this program distribution.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * Squid Solutions also offers commercial licenses with additional warranties, professional functionalities or services.
 * If you purchase a commercial license, then it supersedes and replaces any other agreement between you and Squid
 * Solutions (above licenses and LICENSE.txt included). See http://www.squidsolutions.com/EnterpriseBouquet/
 *******************************************************************************/
package com.squid.kraken.v4.model;

import java.io.Serializable;

/**
 * SSO Definition model UserAction indicates how to react when a user isn't found or modified
 * 
 * @author jtheulier
 *
 */
public abstract class ClientSSODefaultConfiguration implements ClientSSOConfiguration, Serializable {


  /**
   *
   */
  private static final long serialVersionUID = 1480216023422900152L;

  private UserAction userAction = UserAction.NONE;

  private String defaultAccessControlGroup = null;

  /**
   * This will genenate a double authentification
   */
  private Boolean obio = false;

  private String name;

  /**
   * get the UserAction to perform when the SSO tries to authenticate a new or modified User
   * 
   * @return
   */
  public UserAction getUserAction() {
    return userAction;
  }

  public void setUserAction(UserAction userAction) {
    this.userAction = userAction;
  }


  public String getDefaultAccessControlGroup() {
    return defaultAccessControlGroup;
  }

  public void setDefaultAccessControlGroup(String defaultAccessControlGroup) {
    this.defaultAccessControlGroup = defaultAccessControlGroup;
  }

  public Boolean isObio() {
    return obio;
  }

  public void setObio(Boolean obio) {
    this.obio = obio;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
