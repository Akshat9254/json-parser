package com.parser.json.core.binder.deserializer;

import com.parser.json.core.binder.Binder;
import com.parser.json.core.binder.type.TypedReference;
import com.parser.json.core.parser.model.JsonNode;
import com.parser.json.core.parser.model.JsonStringNode;
import com.parser.json.core.binder.BinderException;
import com.parser.json.core.parser.ParserException;

import java.lang.reflect.Type;

@SuppressWarnings("unchecked")
public class StringDeserializer implements JsonDeserializer {
    @Override
    public <T> T deserialize(JsonNode jsonNode, TypedReference<T> ref, Binder binder) {
        if (!(jsonNode instanceof JsonStringNode(String value))) {
            throw new BinderException("Invalid json: expected string");
        }

        Type type = ref.getType();
        if(!(type instanceof Class<?> clazz)) {
            throw new BinderException("Invalid json: expected string");
        }

        if (clazz == String.class) {
            return (T) value;
        } else {
            throw new ParserException("Invalid json: expected string");
        }
    }
}
