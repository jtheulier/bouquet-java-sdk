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
package com.squid.kraken.v4.model;

import io.bouquet.v4.ApiException;

public abstract class BasePK implements ApiPK {

	@Override
	public String getApiUri(boolean allValues) throws ApiException {
		return getEndPoint();
	}

	private String getEndPoint() {
		return "/rs";
	}
	/*
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			BasePK other = (BasePK) obj;
			if (getId() == null) {
				if (other.getId() != null)
					return false;
			} else if (!getId().equals(other.getId()))
				return false;
			if (getParent() == null) {
				if (other.getParent() != null)
					return false;
			} else if (!getParent().equals(other.getParent()))
				return false;
			return true;
		}
	
		protected abstract String getId();
	
		protected abstract BasePK getParent();
	*/
}
