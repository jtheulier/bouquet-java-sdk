package com.squid.kraken.v4.model;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

public class DynamicObject<PK extends BasePK> extends VersionedBase<PK> {

	@SerializedName("dynamic")
	private Boolean dynamic = false;

	@SerializedName("hidden")
	private Boolean hidden = false;

	/**
	 * indicates if the object is automatically generated. This property can be updated.
	 * @return dynamic
	 **/
	@ApiModelProperty(example = "null", value = "indicates if the object is automatically generated. This property can be updated.")
	public Boolean isDynamic() {
		return dynamic;
	}

	public void setDynamic(Boolean dynamic) {
		this.dynamic = dynamic;
	}

	/**
	 * indicates if the object is not dynamic but hidden.
	 * @return dynamic
	 **/
	@ApiModelProperty(example = "null", value = "indicates if the object is not dynamic but hidden. This property can be updated.")
	public Boolean isHidden() {
		return hidden;
	}

	public void setHidden(Boolean hidden) {
		this.hidden = hidden;
	}

}
