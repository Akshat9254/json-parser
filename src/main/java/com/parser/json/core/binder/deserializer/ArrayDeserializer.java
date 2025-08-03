package com.parser.json.core.binder.deserializer;

import com.parser.json.core.binder.Binder;
import com.parser.json.core.binder.type.TypedReference;
import com.parser.json.core.parser.model.JsonArrayNode;
import com.parser.json.core.parser.model.JsonNode;
import com.parser.json.core.binder.BinderException;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class ArrayDeserializer implements JsonDeserializer {
    @Override
    public <T> T deserialize(JsonNode jsonNode, TypedReference<T> ref, Binder binder) {
        if (!(jsonNode instanceof JsonArrayNode(List<JsonNode> elements))) {
            throw new BinderException("Invalid json: expected array");
        }

        Type type = ref.getType();

        if(!(type instanceof ParameterizedType parameterizedType)) {
            throw new BinderException("Invalid json: expected array");
        }

        Type rawType = parameterizedType.getRawType();
        if(!(rawType instanceof Class<?> clazz) || !List.class.isAssignableFrom(clazz)) {
            throw new BinderException("Invalid json: expected array");
        }

        Type elementType = parameterizedType.getActualTypeArguments()[0];
        List<Object> values = new ArrayList<>();
        for (JsonNode element : elements) {
            Object value = binder.bind(element, TypedReference.of(elementType));
            values.add(value);
        }

        return (T) values;
    }
}
