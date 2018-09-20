package com.squid.kraken.v4.model;

import java.beans.Transient;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(use = Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = DBMSCredentials.class),
	@Type(value = APICredentials.class),
	@Type(value = Oauth2RefreshCredentials.class), })
public interface Credentials extends Serializable {

	/**
	 * Used for typing credentials in project in particular, do not rename else it will break serialization /deserialization of projects
	 * @author jtheulier
	 *
	 */
	public enum CredentialsType { API, DBMS, REFFESH }

	public String getUrl();

	@Transient
	@JsonIgnore
	public Credentials hide();

	@Transient
	@JsonIgnore
	public boolean isHidden();

	@Transient
	@JsonIgnore
	public void copyHiddenFields(Credentials credentials);

}
