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

import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.Serializable;

/**
 * SSO Definition model UserAction indicates how to react when a user isn't found or modified
 * 
 * @author jtheulier
 *
 */
@JsonTypeName("OAuth")
public class ClientSSOOAuthConfiguration extends ClientSSODefaultConfiguration
    implements ClientSSOConfiguration, Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -4337485804618658334L;

  private String authorizationEndPoint = null; // Endpoint to perform the auth code generation with the IDP
  private String tokenEndPoint = null; // Endpoint to perform the auth code exchange with the IDP
  private String logoutEndPoint = null; // Endpoint to perform the token revokation with the IDP
  private String userInfoEndPoint = null; // Endpoint to get user profile infromation with the IDP

  private String clientId = null;
  private String clientSecret = null;
  private String scope = null;


  /**
   * Mandatory: this is the SSO URL endpoint. Obviously this must be a valid URL. The SSO endpoint must implement the
   * GET DelegatedUser API: it will return the SSO User associated with the provided token If using the default
   * SSOSecuritytValidator, the URL must contains the {token} string that will be replace by the actual token when
   * executed.
   * 
   * @return
   */
  public String getAuthorizationEndPoint() {
    return authorizationEndPoint;
  }

  public void setAuthorizationEndPoint(String ssoEndpoint) {
    this.authorizationEndPoint = ssoEndpoint;
  };

  /**
   * Optionally this is the URL to redirect application to the SSO Authentication page when then token is not valid
   * anymore.
   * 
   * @return the ssoLoginPage
   */
  public String getTokenEndPoint() {
    return tokenEndPoint;
  }

  /**
   * @param ssoLoginPage the ssoLoginPage to set
   */
  public void setTokenEndPoint(String tokenEndPoint) {
    this.tokenEndPoint = tokenEndPoint;
  }

  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public String getClientSecret() {
    return clientSecret;
  }

  public void setClientSecret(String clientSecret) {
    this.clientSecret = clientSecret;
  }

  public String getLogoutEndPoint() {
    return logoutEndPoint;
  }

  public void setLogoutEndPoint(String logoutEndPoint) {
    this.logoutEndPoint = logoutEndPoint;
  }

  public String getUserInfoEndPoint() {
    return userInfoEndPoint;
  }

  public void setUserInfoEndPoint(String userInfoEndPoint) {
    this.userInfoEndPoint = userInfoEndPoint;
  }

  public String getScope() {
    return scope;
  }

  public void setScope(String scope) {
    this.scope = scope;
  }

}
