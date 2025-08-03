package com.parser.json.core.binder.deserializer;

import com.parser.json.core.binder.Binder;
import com.parser.json.core.binder.type.TypedReference;
import com.parser.json.core.parser.model.JsonBooleanNode;
import com.parser.json.core.parser.model.JsonNode;
import com.parser.json.core.binder.BinderException;

import java.lang.reflect.Type;

@SuppressWarnings("unchecked")
public class BooleanDeserializer implements JsonDeserializer {
    @Override
    public <T> T deserialize(JsonNode jsonNode, TypedReference<T> ref, Binder binder) {
        if (!(jsonNode instanceof JsonBooleanNode(Boolean value))) {
            throw new BinderException("Invalid json: expected boolean");
        }

        Type type = ref.getType();

        if(!(type instanceof Class<?> clazz)) {
            throw new BinderException("Invalid json: expected boolean");
        }

        if (clazz == Boolean.class || clazz == boolean.class) {
            return (T) value;
        }

        throw new BinderException("Invalid json: expected boolean");
    }
}
