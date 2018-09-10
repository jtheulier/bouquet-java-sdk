package io.bouquet.v4.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(use = Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = APICredentials.class),
	@Type(value = DBMSCredentials.class),
	@Type(value = Oauth2RefreshCredentials.class)})
public class DefaultCredentials implements Credentials {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String url;

	public DefaultCredentials() {

	}
	public DefaultCredentials(String url) {
		super();
		this.url=url;
	}

	@Override
	public String getUrl() {
		return url;
	}

	@Override
	public Credentials hide() {
		return this;
	}

	@Override
	public boolean isHidden() {
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof DefaultCredentials) {
			if ((this.getUrl() == null && ((DefaultCredentials)o).getUrl() != null)
					||(this.getUrl() != null && ((DefaultCredentials)o).getUrl() == null) ){
				return false;
			}
			return this.getUrl() == null || this.getUrl().equals(((DefaultCredentials)o).getUrl());
		}
		return false;
	}

	@Override
	public void copyHiddenFields(Credentials credentials) {

	}
}
