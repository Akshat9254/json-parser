package com.parser.json.core.binder.deserializer;

import com.parser.json.core.binder.Binder;
import com.parser.json.core.binder.type.TypedReference;
import com.parser.json.core.parser.model.JsonNode;

public interface JsonDeserializer {
    <T> T deserialize(JsonNode jsonNode, TypedReference<T> ref, Binder binder);
}
