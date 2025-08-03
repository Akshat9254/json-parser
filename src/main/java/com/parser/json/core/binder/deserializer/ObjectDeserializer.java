package com.parser.json.core.binder.deserializer;

import com.parser.json.core.binder.Binder;
import com.parser.json.core.binder.type.TypedReference;
import com.parser.json.core.parser.model.JsonNode;
import com.parser.json.core.parser.model.JsonObjectNode;
import com.parser.json.core.binder.BinderException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

@SuppressWarnings("unchecked")
public class ObjectDeserializer implements JsonDeserializer {
    @Override
    public <T> T deserialize(JsonNode jsonNode, TypedReference<T> ref, Binder binder) {
        if (!(jsonNode instanceof JsonObjectNode jsonObjectNode)) {
            throw new BinderException("Invalid json: expected object");

        }

        Type type = ref.getType();
        if (!(type instanceof Class<?> clazz)) {
            throw new BinderException("Invalid json: expected object");
        }

        try {
//            Constructor<?> constructor = Arrays.stream(clzz.getDeclaredConstructors())
//                    .findFirst()
//                    .orElseThrow(() -> new RuntimeException("No constructor found for class: " + clzz.getName()));
//            constructor.setAccessible(true);
//            Parameter[] parameters = constructor.getParameters();
//
            T instance = (T) clazz.getDeclaredConstructor().newInstance();
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                JsonNode property = jsonObjectNode.getProperty(field.getName());
                if (property == null) {
                    continue;
                }

                Type genericType = field.getGenericType();
                Object value = binder.bind(property, TypedReference.of(genericType));
                field.set(instance, value);
            }

            return instance;
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
