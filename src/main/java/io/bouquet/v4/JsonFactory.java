package io.bouquet.v4;

import java.lang.reflect.Type;

public interface JsonFactory {

	public String serialize(Object obj);

	public <T> T deserialize(String body, Type returnType);
}
