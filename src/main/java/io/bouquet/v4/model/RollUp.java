/*******************************************************************************
 * Copyright 2017 julien@squidsolutions.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package io.bouquet.v4.model;

import com.google.gson.annotations.SerializedName;

import io.swagger.annotations.ApiModelProperty;

/**
 * a Rollup allows to specify which dimension to use for the sub-total level. The dimension is defined by its indice in the analysis job, starting at 0. In order to compute a grand-total, use indice -1. It is also possible to define how to sort sub-total using the position, default to FIRST.
 */

public class RollUp extends Base  {
	@SerializedName("col")
	private Integer col = null;

	/**
	 * define how to sort the sub-total, either before the detailled data (FIRST) or after (LAST)
	 */
	public enum PositionEnum {
		@SerializedName("FIRST")
		FIRST("FIRST"),

		@SerializedName("LAST")
		LAST("LAST");

		private String value;

		PositionEnum(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}

	@SerializedName("position")
	private PositionEnum position = null;

	public RollUp col(Integer col) {
		this.col = col;
		return this;
	}

	/**
	 * the indice of the dimension to rollup on, or -1 to compute a grand-total.
	 * @return col
	 **/
	@ApiModelProperty(example = "0", value = "the indice of the dimension to rollup on, or -1 to compute a grand-total.")
	public Integer getCol() {
		return col;
	}

	public void setCol(Integer col) {
		this.col = col;
	}

	public RollUp position(PositionEnum position) {
		this.position = position;
		return this;
	}

	/**
	 * define how to sort the sub-total, either before the detailled data (FIRST) or after (LAST)
	 * @return position
	 **/
	@ApiModelProperty(example = "FIRST", value = "define how to sort the sub-total, either before the detailled data (FIRST) or after (LAST)")
	public PositionEnum getPosition() {
		return position;
	}

	public void setPosition(PositionEnum position) {
		this.position = position;
	}

}

