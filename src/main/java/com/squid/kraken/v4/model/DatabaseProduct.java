/*******************************************************************************
 * Copyright © Squid Solutions, 2016
 *
 * This file is part of Open Bouquet software.
 *  
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation (version 3 of the License).
 *
 * There is a special FOSS exception to the terms and conditions of the 
 * licenses as they are applied to this program. See LICENSE.txt in
 * the directory of this program distribution.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * Squid Solutions also offers commercial licenses with additional warranties,
 * professional functionalities or services. If you purchase a commercial
 * license, then it supersedes and replaces any other agreement between
 * you and Squid Solutions (above licenses and LICENSE.txt included).
 * See http://www.squidsolutions.com/EnterpriseBouquet/
 *******************************************************************************/
package com.squid.kraken.v4.model;

import java.io.Serializable;

/**
 * The DatabaseProduct object identifies a kind of database given a product name and version. It can be used to override some SQL features.
 * @author sfantino
 *
 */
public class DatabaseProduct implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String productName = "";

	private String productVersion = "";

	private int majorVersion = 0;

	private int minorVersion = 0;

	/**
	 * default constructor
	 */
	public DatabaseProduct() {
	}

	/**
	 * default constructor
	 */
	public DatabaseProduct(String productName) {
		this.productName = productName;
	}

	public DatabaseProduct(DatabaseProduct databaseProduct) {
		this.productName = databaseProduct.getProductName();
		this.productVersion = databaseProduct.getProductVersion();
		this.majorVersion = databaseProduct.getMajorVersion();
		this.minorVersion = databaseProduct.getMinorVersion();
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductVersion() {
		return productVersion;
	}

	public void setProductVersion(String productVersion) {
		this.productVersion = productVersion;
	}

	public int getMajorVersion() {
		return majorVersion;
	}

	public void setMajorVersion(int majorVersion) {
		this.majorVersion = majorVersion;
	}

	public int getMinorVersion() {
		return minorVersion;
	}

	public void setMinorVersion(int minorVersion) {
		this.minorVersion = minorVersion;
	}

}
