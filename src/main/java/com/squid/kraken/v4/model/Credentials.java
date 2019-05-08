package com.squid.kraken.v4.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import java.beans.Transient;
import java.io.Serializable;

@JsonTypeInfo(use = Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({@Type(value = DBMSCredentials.class), @Type(value = APICredentials.class),
    @Type(value = Oauth2RefreshCredentials.class),})
public interface Credentials extends Serializable {

  /**
   * Used for typing credentials in project in particular, do not rename else it will break serialization
   * /deserialization of projects
   * 
   * @author jtheulier
   */
  public enum CredentialsType {
    API, DBMS, REFFESH
  }

  /**
   * Indicates how data is shared accross users:
   * - PERSONAL: Indexes & queries are private to each user
   * - SHARED: Indexes & queries are shared across users
   * - SHARED_INDEXES: default mode for API vendors: indexes are shared, but queries are private to users
   * Order in the list from the most permissive to the least permissive
   * 
   * @author jtheulier
   */
  public enum DataAccess {
    // * - PRIVATE: even model is private to users (for a future use maybe)
    SHARED, SHARED_INDEXES, PERSONAL /* , PRIVATE */;
  }

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


  public DataAccess getDataAccess();

}
