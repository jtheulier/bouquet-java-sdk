package com.squid.kraken.v4.model;

import com.fasterxml.jackson.annotation.JsonTypeName;

@JsonTypeName("DBMS")
@SuppressWarnings("serial")
public class DBMSCredentials extends DefaultCredentials implements Credentials {

	private String login;
	private String password;

	public DBMSCredentials() {
		super();
	}

	public DBMSCredentials(String url, String login, String password) {
		super(url);
		this.login = login;
		this.password = password;
	}
	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public Credentials hide() {
		return new DBMSCredentials(this.getUrl(), this.getLogin(), null);
	}

	@Override
	public boolean isHidden() {
		return this.password == null;
	}

	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof DBMSCredentials) {
			if (this.getUrl() == null && ((DBMSCredentials)o).getLogin() != null){
				return false;
			} else if (this.getUrl() != null && ((DBMSCredentials)o).getLogin() == null){
				return false;
			} else if (this.getUrl() == null && ((DBMSCredentials)o).getLogin() == null){
				return true;
			}
			return this.getUrl().equals(((DBMSCredentials)o).getLogin());
		}
		return false;
	}

	@Override
	public void copyHiddenFields(Credentials credentials) {
		if (credentials instanceof DBMSCredentials) {
			this.password= ((DBMSCredentials) credentials).getPassword();
		}
	}
}
