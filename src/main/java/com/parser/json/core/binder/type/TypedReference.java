package com.parser.json.core.binder.type;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class TypedReference<T> {
    private final Type type;

    protected TypedReference() {
        Type superclass = getClass().getGenericSuperclass();
        if (!(superclass instanceof ParameterizedType parameterizedType)) {
            throw new IllegalStateException("Type reference must be parameterized");
        }

        this.type = parameterizedType.getActualTypeArguments()[0];
    }

    public Type getType() {
        return type;
    }

    public static <T> TypedReference<T> of(Type type) {
        return new TypedReference<>() {
            @Override
            public Type getType() {
                return type;
            }
        };
    }
}
