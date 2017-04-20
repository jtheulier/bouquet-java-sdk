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
package io.openbouquet.v4.model;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class Base {


	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	protected String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		boolean result = true;
		List<Field> fields = getAllFields();
		for (Field field : fields) {
			try {
				Object b = field.get(o);
				Object a = field.get(this);
				result = result && (b.equals(a));
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public int hashCode() {
		int i = 0;
		List<Field> fields = getAllFields();
		Object[] objs = new Object[fields.size()];
		for (Field field : fields) {
			for (Method method:this.getClass().getMethods()) {
				if (method.getName().equalsIgnoreCase("get"+field.getName())) {
					try {
						objs[i++] = method.invoke(this);
					} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return Arrays.hashCode(objs);
	}

	protected List<Field> getAllFields() {
		List<Field> fields = new ArrayList<Field>();
		Class<?> tmpClass = this.getClass();
		while (tmpClass != null) {
			fields.addAll(Arrays.asList(tmpClass .getDeclaredFields()));
			tmpClass = tmpClass .getSuperclass();
		}
		Collections.reverse(fields);
		return fields;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class "+this.getClass().getSimpleName() + " {\n");
		List<Field> fields = getAllFields();
		for (Field field : fields) {
			for (Method method:this.getClass().getMethods()) {
				if (method.getName().equalsIgnoreCase("get"+field.getName())) {
					try {
						sb.append("    " + field.getName() + ": " + method.invoke(this)).append("\n");
					} catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}
		}
		sb.append("}");
		return sb.toString();
	}
}
