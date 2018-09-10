package io.bouquet.v4.model;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("API")
@SuppressWarnings("serial")
public class APICredentials extends DefaultCredentials implements Credentials {

	private String clientId;
	private String clientSecret;

	public APICredentials() {
		super();
	}

	public APICredentials(String url, String clientId, String clientSecret) {
		super(url);
		this.clientId = clientId;
		this.clientSecret = clientSecret;
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

	@Override
	public Credentials hide() {
		return new APICredentials(this.getUrl(), this.getClientId(), null);
	}

	@Override
	public boolean isHidden() {
		return this.clientSecret == null;
	}

	@Override
	public boolean equals(Object o) {
		if (super.equals(o) && o instanceof APICredentials) {
			if (this.getClientId() == null && ((APICredentials)o).getClientId() != null){
				return false;
			} else if (this.getClientId() != null && ((APICredentials)o).getClientId() == null){
				return false;
			} else if (this.getClientId() == null && ((APICredentials)o).getClientId() == null){
				return true;
			}
			return this.getClientId().equals(((APICredentials)o).getClientId());
		}
		return false;
	}

	@Override
	public void copyHiddenFields(Credentials credentials) {
		if (credentials instanceof APICredentials) {
			this.clientSecret= ((APICredentials) credentials).getClientSecret();
		}
	}

}
