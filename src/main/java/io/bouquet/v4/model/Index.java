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
 * a Index allows to identify a dimension by its position in the Analysis. The dimension is defined by its indice in the analysis job, starting at 0.
 */

public class Index extends Base  {
	@SerializedName("col")
	private Integer col = null;

	public Index col(Integer col) {
		this.col = col;
		return this;
	}

	/**
	 * the indice of the dimension.
	 * @return col
	 **/
	@ApiModelProperty(example = "0", value = "the indice of the dimension.")
	public Integer getCol() {
		return col;
	}

	public void setCol(Integer col) {
		this.col = col;
	}
}

