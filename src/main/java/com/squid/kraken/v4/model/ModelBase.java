package com.squid.kraken.v4.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

public abstract class ModelBase<PK extends BasePK> {

	private PK id;
	private String oid = null;

	@ApiModelProperty(example = "null", value = "The object Composite Id (Primary Key)")
	public PK getId() {
		return id;
	}

	public void setId(PK id) {
		this.id = id;
	}

	@JsonIgnore
	public String getOid() {
		return oid;
	}

	@JsonProperty("oid")
	public void setOid(String oid) {
		this.oid=oid;
	}
}
