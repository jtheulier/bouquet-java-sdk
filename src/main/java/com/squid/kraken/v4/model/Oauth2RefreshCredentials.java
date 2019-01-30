package com.squid.kraken.v4.model;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("REFRESH")
@SuppressWarnings("serial")
public class Oauth2RefreshCredentials extends DefaultCredentials implements Credentials {

	private String refreshToken = null;

	private String accessToken = null;

	public Oauth2RefreshCredentials() {
		super();
	}

	public Oauth2RefreshCredentials(String url, DatabaseProductFacade databaseProduct, String refreshToken, String accessToken) {
		super(url, databaseProduct);
		this.refreshToken = refreshToken;
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	@Override
	public Credentials hide() {
		return new Oauth2RefreshCredentials(this.getUrl(), this.getDatabaseProduct(), null, null);
	}

	@Override
	public boolean isHidden() {
		return this.getRefreshToken() == null && this.getAccessToken() == null;
	}

	public boolean isAuthenticationUpdated(Oauth2RefreshCredentials oldCredentials) {
		if (super.equals(oldCredentials) == false) {
			if ((this.getRefreshToken() == null && oldCredentials.getRefreshToken() != null) || (this.getRefreshToken() != null && oldCredentials.getRefreshToken() == null)) {
				return true;
			}
			return this.getRefreshToken() == null || this.getRefreshToken().equals(oldCredentials.getRefreshToken()) == false;
		} else {
			return false;
		}
	}

	@Override
	public boolean equals(Object o) {
		if (super.equals(o) && o instanceof Oauth2RefreshCredentials) {
			if ((this.getRefreshToken() == null && ((Oauth2RefreshCredentials) o).getRefreshToken() != null) || (this.getRefreshToken() != null && ((Oauth2RefreshCredentials) o).getRefreshToken() == null)) {
				return false;
			} else if ((this.getAccessToken() == null && ((Oauth2RefreshCredentials) o).getAccessToken() != null) || (this.getAccessToken() != null && ((Oauth2RefreshCredentials) o).getAccessToken() == null)) {
				return false;
			}
			return (this.getRefreshToken() == null || this.getRefreshToken().equals(((Oauth2RefreshCredentials) o).getRefreshToken())) && (this.getAccessToken() == null || this.getAccessToken().equals(((Oauth2RefreshCredentials) o).getAccessToken()));
		}
		return false;
	}

	@Override
	public void copyHiddenFields(Credentials credentials) {
		if (credentials instanceof Oauth2RefreshCredentials) {
			this.refreshToken = ((Oauth2RefreshCredentials) credentials).getRefreshToken();
			this.accessToken = ((Oauth2RefreshCredentials) credentials).getAccessToken();
		}
	}

}
