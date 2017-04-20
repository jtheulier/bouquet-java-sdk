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

public class OrderBy extends Base  {
	@SerializedName("col")
	private Integer col = null;

	@SerializedName("expression")
	private Expression expression = null;

	/**
	 * the direction to order-by
	 */
	public enum DirectionEnum {
		@SerializedName("ASC")
		ASC("ASC"),

		@SerializedName("DESC")
		DESC("DESC");

		private String value;

		DirectionEnum(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}

	@SerializedName("direction")
	private DirectionEnum direction = null;

	public OrderBy col(Integer col) {
		this.col = col;
		return this;
	}

	/**
	 * the indice of the expression to order-by, or null if it is defined by a expression.
	 * @return col
	 **/
	@ApiModelProperty(example = "null", value = "the indice of the expression to order-by, or null if it is defined by a expression.")
	public Integer getCol() {
		return col;
	}

	public void setCol(Integer col) {
		this.col = col;
	}

	public OrderBy expression(Expression expression) {
		this.expression = expression;
		return this;
	}

	/**
	 * the expression to order-by if it is not defined by an indice.
	 * @return expression
	 **/
	@ApiModelProperty(example = "null", value = "the expression to order-by if it is not defined by an indice.")
	public Expression getExpression() {
		return expression;
	}

	public void setExpression(Expression expression) {
		this.expression = expression;
	}

	public OrderBy direction(DirectionEnum direction) {
		this.direction = direction;
		return this;
	}

	/**
	 * the direction to order-by
	 * @return direction
	 **/
	@ApiModelProperty(example = "ASC", value = "the direction to order-by")
	public DirectionEnum getDirection() {
		return direction;
	}

	public void setDirection(DirectionEnum direction) {
		this.direction = direction;
	}
}

