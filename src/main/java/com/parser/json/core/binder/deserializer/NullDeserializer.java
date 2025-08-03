package com.parser.json.core.binder.deserializer;

import com.parser.json.core.binder.Binder;
import com.parser.json.core.binder.type.TypedReference;
import com.parser.json.core.parser.model.JsonNode;
import com.parser.json.core.parser.model.JsonNullNode;
import com.parser.json.core.binder.BinderException;

public class NullDeserializer implements JsonDeserializer {
    @Override
    public <T> T deserialize(JsonNode jsonNode, TypedReference<T> ref, Binder binder) {
        if (!(jsonNode instanceof JsonNullNode)) {
            throw new BinderException("Invalid json: expected null");
        }
        return null;
    }
}
