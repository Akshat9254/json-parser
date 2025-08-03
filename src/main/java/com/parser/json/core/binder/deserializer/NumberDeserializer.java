package com.parser.json.core.binder.deserializer;

import com.parser.json.core.binder.Binder;
import com.parser.json.core.binder.type.TypedReference;
import com.parser.json.core.parser.model.JsonNode;
import com.parser.json.core.parser.model.JsonNumberNode;
import com.parser.json.core.binder.BinderException;

import java.lang.reflect.Type;
import java.math.BigDecimal;

@SuppressWarnings("unchecked")
public class NumberDeserializer implements JsonDeserializer {
    @Override
    public <T> T deserialize(JsonNode jsonNode, TypedReference<T> ref, Binder binder) {
        if (!(jsonNode instanceof JsonNumberNode(BigDecimal value))) {
            throw new BinderException("Invalid json: expected number");
        }

        Type type = ref.getType();

        if (!(type instanceof Class<?> clazz)) {
            throw new BinderException("Invalid json: expected number");
        }

        if (clazz == BigDecimal.class) {
            return (T) value;
        }

        if (clazz == double.class || clazz == Double.class) {
            return (T) Double.valueOf(value.doubleValue());
        }

        if (clazz == float.class || clazz == Float.class) {
            return (T) Float.valueOf(value.floatValue());
        }

        if (clazz == long.class || clazz == Long.class) {
            return (T) Long.valueOf(value.longValue());
        }

        if (clazz == int.class || clazz == Integer.class) {
            return (T) Integer.valueOf(value.intValue());
        }

        if (clazz == short.class || clazz == Short.class) {
            return (T) Short.valueOf(value.shortValue());
        }

        if (clazz == byte.class || clazz == Byte.class) {
            return (T) Byte.valueOf(value.byteValue());
        }

        return null;
    }
}
