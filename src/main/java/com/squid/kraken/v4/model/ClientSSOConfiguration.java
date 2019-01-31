package com.squid.kraken.v4.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(use = Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({@Type(value = ClientSSOOAuthConfiguration.class), @Type(value = ClientSSOOpenIdConfiguration.class),
    @Type(value = ClientSSOSAMLConfiguration.class), @Type(value = ClientOAuthEmbeddedConfiguration.class)})
public interface ClientSSOConfiguration {

  public enum UserAction {
    NONE, CREATE, CREATE_OR_UPDATE, UPDATE
  };

  public UserAction getUserAction();

  public String getDefaultAccessControlGroup();

  public String getName();


  public Boolean isObio();

  public void setObio(Boolean obio);

}
