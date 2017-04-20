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
package io.bouquet.v4.client;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.X509TrustManager;

import org.apache.commons.lang3.text.WordUtils;

import io.bouquet.v4.ApiException;
import io.bouquet.v4.model.FacetMember;
import io.bouquet.v4.model.FacetMemberInterval;
import io.bouquet.v4.model.FacetMemberString;


public class APIUtils {

	private static final Pattern p = Pattern.compile("[\\.]{0,}@'([:\\w]+)'");

	private static final Pattern n = Pattern.compile("([^a-z0-9]+)", Pattern.CASE_INSENSITIVE);

	public static String[] splitDomainObject(String input) throws ApiException {
		if (input != null) {
			Matcher m = p.matcher(input);
			List<String> splitted = new ArrayList<String>();
			while (m.find()) {
				splitted.add(m.group(1));
			}
			return splitted.toArray(new String[splitted.size()]);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static List<FacetMember> deserializeFacets(List<Hashtable<String, Object>> facets) throws ApiException {
		if (facets != null && facets.size() > 0) {
			List<FacetMember> facetMembers = new ArrayList<FacetMember>();
			for (Hashtable<String, Object> facet : facets) {
				if (facet != null) {
					if ("i".equals(facet.get("type"))) {
						FacetMemberInterval facetMember = new FacetMemberInterval();
						facetMember.setLowerBound((String) facet.get("lowerBound"));
						facetMember.setUpperBound((String) facet.get("upperBound"));
						facetMember.setType((String) facet.get("type"));
						facetMembers.add(facetMember);
					} else if ("v".equals(facet.get("type"))) {
						FacetMemberString facetMember = new FacetMemberString();
						facetMember.setId((String) facet.get("id"));
						facetMember.setValue((String) facet.get("value"));
						facetMember.setType((String) facet.get("type"));
						facetMember.setAttributes((Map<String, String>) facet.get("attributes"));

						facetMembers.add(facetMember);
					} else {
						throw new ApiException("Invalid facet type");
					}
				}
			}
			return facetMembers;
		}
		return null;
	}

	public static String normalizeBouquetToSQL(String input) {
		if (input != null) {
			input = input.trim();
			Matcher m = n.matcher(input);
			return trim(m.replaceAll("_").toLowerCase(), "_");
		}
		return null;
	}

	private static String trim(String stringToTrim, String stringToRemove) {
		String answer = stringToTrim;

		while (answer.startsWith(stringToRemove)) {
			answer = answer.substring(stringToRemove.length());
		}

		while (answer.endsWith(stringToRemove)) {
			answer = answer.substring(0, answer.length() - stringToRemove.length());
		}

		return answer;
	}

	public static String normalizeSQLToBouquet(String input) {
		if (input != null) {
			return WordUtils.capitalize(input.replaceAll("_", " "));
		}
		return null;
	}

	public static X509TrustManager getTrustManager() {
		X509TrustManager tm = new X509TrustManager() {
			@Override
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			@Override
			public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws java.security.cert.CertificateException {

			}

			@Override
			public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws java.security.cert.CertificateException {

			}
		};

		return tm;
	}

	/**
	 * Escape the given string to be used as URL query value.
	 *
	 * @param str String to be escaped
	 * @return Escaped string
	 */
	public static String escapeString(String str) {
		try {
			return URLEncoder.encode(str, "utf8").replaceAll("\\+", "%20");
		} catch (UnsupportedEncodingException e) {
			return str;
		}
	}

}
