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
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * SSO Definition model UserAction indicates how to react when a user isn't found or modified
 *
 * @author jtheulier
 *
 */
@JsonTypeName("Custom")
public class ClientSSOCustomConfiguration extends ClientSSODefaultConfiguration
implements ClientSSOConfiguration, Serializable {

  /**
   *
   */
  private static final long serialVersionUID = -4337485804618658334L;

  private String tokenEndPoint = null; // Endpoint to perform the auth code exchange with the IDP
  private String loginPage = null; // External Login page profided by the IDP
  private String authorizationEndPoint = null;

  private String clientId = null;
  private String clientSecret = null;


  @Override
  public String getName() {
    return "Custom";
  }

  /**
   * Mandatory: this is the SSO URL endpoint. Obviously this must be a valid URL. The SSO endpoint must implement the
   * GET DelegatedUser API: it will return the SSO User associated with the provided token If using the default
   * SSOSecuritytValidator, the URL must contains the {token} string that will be replace by the actual token when
   * executed.
   *
   * @return
   */
  public String getTokenEndPoint() {
    return tokenEndPoint;
  }

  public void setTokenEndPoint(String ssoEndpoint) {
    this.tokenEndPoint = ssoEndpoint;
  };

  /**
   * Optionally this is the URL to redirect application to the SSO Authentication page when then token is not valid
   * anymore.
   *
   * @return the ssoLoginPage
   */
  public String getLoginPage() {
    return loginPage;
  }

  /**
   * @param ssoLoginPage the ssoLoginPage to set
   */
  public void setLoginPage(String ssoLoginPage) {
    this.loginPage = ssoLoginPage;
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

  public String getAuthorizationEndPoint() {
    return authorizationEndPoint;
  }

  public void setAuthorizationEndPoint(String redirectEndpoint) {
    this.authorizationEndPoint = redirectEndpoint;
  }


}