package com.squid.kraken.v4.model;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("REFRESH")
@SuppressWarnings("serial")
public class OAuth2RefreshCredentials extends DefaultCredentials implements Credentials {

	private String refreshToken = null;

	private String accessToken = null;

	public OAuth2RefreshCredentials() {
		super();
	}

	public OAuth2RefreshCredentials(String url, String refreshToken, String accessToken) {
		super(url);
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
		return new OAuth2RefreshCredentials(this.getUrl(), null, null);
	}

	@Override
	public boolean isHidden() {
		return this.getRefreshToken() == null && this.getAccessToken() == null;
	}

	public boolean isAuthenticationUpdated(OAuth2RefreshCredentials oldCredentials) {
		if (super.equals(oldCredentials) == false) {
			if ((this.getRefreshToken() == null && oldCredentials.getRefreshToken() != null)
					|| (this.getRefreshToken() != null && oldCredentials.getRefreshToken() == null)){
				return true;
			}
			return this.getRefreshToken() == null || this.getRefreshToken().equals(oldCredentials.getRefreshToken()) == false;
		} else {
			return false;
		}
	}

	@Override
	public boolean equals(Object o) {
		if (super.equals(o) && o instanceof OAuth2RefreshCredentials) {
			if ((this.getRefreshToken() == null && ((OAuth2RefreshCredentials)o).getRefreshToken() != null)
					|| (this.getRefreshToken() != null && ((OAuth2RefreshCredentials)o).getRefreshToken() == null)) {
				return false;
			} else if ((this.getAccessToken() == null && ((OAuth2RefreshCredentials)o).getAccessToken() != null)
					|| (this.getAccessToken() != null && ((OAuth2RefreshCredentials)o).getAccessToken() == null)) {
				return false;
			}
			return (this.getRefreshToken() == null || this.getRefreshToken().equals(((OAuth2RefreshCredentials)o).getRefreshToken()))
					&& (this.getAccessToken() == null || this.getAccessToken().equals(((OAuth2RefreshCredentials)o).getAccessToken()))
					;
		}
		return false;
	}

	@Override
	public void copyHiddenFields(Credentials credentials) {
		if (credentials instanceof OAuth2RefreshCredentials) {
			this.refreshToken= ((OAuth2RefreshCredentials) credentials).getRefreshToken();
			this.accessToken= ((OAuth2RefreshCredentials) credentials).getAccessToken();
		}
	}

}
