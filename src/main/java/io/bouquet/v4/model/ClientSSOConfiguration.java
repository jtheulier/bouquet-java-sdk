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
package io.bouquet.v4.model;

/**
 * SSO Definition model
 * UserAction indicates how to react when a user isn't found or modified
 * @author jtheulier
 *
 */
public class ClientSSOConfiguration extends Base {

	public enum UserAction {
		NONE, CREATE, CREATE_OR_UPDATE, UPDATE
	};

	private UserAction userAction = UserAction.NONE;

	private String ssoClass = null;
	private String ssoEndpoint = null; //Endpoint to perform the auth code exchange with the IDP
	private String ssoLoginPage = null; //External Login page profided by the IDP

	private String clientId = null;
	private String clientSecret = null;
	private String redirectEndpoint = null;
	private String samlConfiguration = null;

	private String defaultAccessGroupControl = null;


	/**
	 **/
	public ClientSSOConfiguration userAction(UserAction userAction) {
		this.userAction = userAction;
		return this;
	}

	public UserAction getUserAction() {
		return userAction;
	}

	public void setUserAction(UserAction userAction) {
		this.userAction = userAction;
	}

	/**
	 **/
	public ClientSSOConfiguration ssoClass(String ssoClass) {
		this.ssoClass = ssoClass;
		return this;
	}
	/**
	 * Optional: get the class implementing the SSOSecurityValidator interface to handle this SSO client.
	 * By default the SSO request is proceeded by the SSOSecurityTokenValidator
	 * @return
	 */
	public String getSsoClass() {
		return ssoClass;
	}

	public void setSsoClass(String ssoClass) {
		this.ssoClass = ssoClass;
	};

	/**
	 **/
	public ClientSSOConfiguration ssoEndpoint(String ssoEndpoint) {
		this.ssoEndpoint = ssoEndpoint;
		return this;
	}
	/**
	 * Mandatory: this is the SSO URL endpoint. Obviously this must be a valid URL.
	 * The SSO endpoint must implement the GET DelegatedUser API: it will return the SSO User associated with the provided token
	 * If using the default SSOSecuritytValidator, the URL must contains the {token} string that will be replace by the actual token when executed.
	 * @return
	 */
	public String getSsoEndpoint() {
		return ssoEndpoint;
	}

	public void setSsoEndpoint(String ssoEndpoint) {
		this.ssoEndpoint = ssoEndpoint;
	};

	/**
	 **/
	public ClientSSOConfiguration ssoLoginPage(String ssoLoginPage) {
		this.ssoLoginPage = ssoLoginPage;
		return this;
	}
	/**
	 * Optionally this is the URL to redirect application to the SSO Authentication page when then token is not valid anymore.
	 * @return the ssoLoginPage
	 */
	public String getSsoLoginPage() {
		return ssoLoginPage;
	}

	/**
	 * @param ssoLoginPage the ssoLoginPage to set
	 */
	public void setSsoLoginPage(String ssoLoginPage) {
		this.ssoLoginPage = ssoLoginPage;
	}

	/**
	 **/
	public ClientSSOConfiguration clientId(String clientId) {
		this.clientId = clientId;
		return this;
	}
	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 **/
	public ClientSSOConfiguration clientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
		return this;
	}
	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	/**
	 **/
	public ClientSSOConfiguration redirectEndpoint(String redirectEndpoint) {
		this.redirectEndpoint = redirectEndpoint;
		return this;
	}
	public String getRedirectEndpoint() {
		return redirectEndpoint;
	}

	public void setRedirectEndpoint(String redirectEndpoint) {
		this.redirectEndpoint = redirectEndpoint;
	}

	/**
	 **/
	public ClientSSOConfiguration samlConfiguration(String  samlConfiguration) {
		this.samlConfiguration = samlConfiguration;
		return this;
	}
	public String getSamlConfiguration() {
		return samlConfiguration;
	}

	public void setSamlConfiguration(String  samlConfiguration) {
		this.samlConfiguration = samlConfiguration;
	}

	/**
	 **/
	public ClientSSOConfiguration defaultAccessGroupControl(String defaultAccessGroupControl) {
		this.defaultAccessGroupControl = defaultAccessGroupControl;
		return this;
	}
	public String getDefaultAccessGroupControl() {
		return defaultAccessGroupControl;
	}

	public void setDefaultAccessGroupControl(String defaultAccessGroupControl) {
		this.defaultAccessGroupControl = defaultAccessGroupControl;
	}

}
