package com.squid.kraken.v4.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(use = Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({@Type(value = APICredentials.class), @Type(value = DBMSCredentials.class),
    @Type(value = Oauth2RefreshCredentials.class)})
public class DefaultCredentials implements Credentials {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private String url;

  private DatabaseProduct databaseProduct;

  /**
   * This flag has for purpose to switch the project in "personal" mode: each user will have his own indexed facets
   * Put on this class to allow to do some tests with any type of DBMS. But mainly for API vendors
   */
  protected DataAccess dataAccess;


  public DefaultCredentials() {

  }

  public DefaultCredentials(String url) {
    super();
    this.url = url;
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
      if ((this.getUrl() == null && ((DefaultCredentials) o).getUrl() != null)
          || (this.getUrl() != null && ((DefaultCredentials) o).getUrl() == null)) {
        return false;
      }
      return this.getUrl() == null || this.getUrl().equals(((DefaultCredentials) o).getUrl());
    }
    return false;
  }

  @Override
  public void copyHiddenFields(Credentials credentials) {

  }

  public DatabaseProduct getDatabaseProduct() {
    return databaseProduct;
  }

  public void setDatabaseProduct(DatabaseProduct databaseProduct) {
    this.databaseProduct = databaseProduct;
  }

  @Override
  public DataAccess getDataAccess() {
    return this.dataAccess;
  }

  public void setDataAccess(DataAccess dataAccess) {
    if (dataAccess != null) {
      this.dataAccess = dataAccess;
    }
  }

}
