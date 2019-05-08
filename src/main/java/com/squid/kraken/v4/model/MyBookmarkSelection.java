package com.squid.kraken.v4.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MyBookmarkSelection extends VersionedBase<MyBookmarkSelectionPK> {

  private FacetSelection selection;

  private String userName;

  private String bookmarkName;

  public FacetSelection getSelection() {
    return selection;
  }

  public void setSelection(FacetSelection selection) {
    this.selection = selection;
  }

  @JsonIgnore
  public String getUserName() {
    return userName;
  }

  @JsonProperty("userName")
  public void setUserName(String userName) {
    this.userName = userName;
  }

  @JsonIgnore
  public String getBookmarkName() {
    return bookmarkName;
  }

  @JsonProperty("bookmarkName")
  public void setBookmarkName(String bookmarkName) {
    this.bookmarkName = bookmarkName;
  }

}
