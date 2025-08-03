package com.parser.json.core.binder;

import com.parser.json.core.binder.deserializer.ArrayDeserializer;
import com.parser.json.core.binder.deserializer.BooleanDeserializer;
import com.parser.json.core.binder.deserializer.JsonDeserializer;
import com.parser.json.core.binder.deserializer.NullDeserializer;
import com.parser.json.core.binder.deserializer.NumberDeserializer;
import com.parser.json.core.binder.deserializer.ObjectDeserializer;
import com.parser.json.core.binder.deserializer.StringDeserializer;
import com.parser.json.core.binder.type.TypedReference;
import com.parser.json.core.parser.model.JsonNode;
import com.parser.json.core.parser.model.JsonNodeType;
import com.parser.json.core.parser.ParserException;

import java.util.Map;

public class Binder {
    private final Map<JsonNodeType, JsonDeserializer> deserializers = Map.of(
            JsonNodeType.OBJECT, new ObjectDeserializer(),
            JsonNodeType.ARRAY, new ArrayDeserializer(),
            JsonNodeType.BOOLEAN, new BooleanDeserializer(),
            JsonNodeType.NUMBER, new NumberDeserializer(),
            JsonNodeType.STRING, new StringDeserializer(),
            JsonNodeType.NULL, new NullDeserializer()
    );

    public <T> T bind(JsonNode jsonNode, TypedReference<T> ref) {
        JsonDeserializer deserializer = deserializers.get(jsonNode.getType());
        if (deserializer == null) {
            throw new ParserException("Invalid json: expected " + jsonNode.getType());
        }

        return deserializer.deserialize(jsonNode, ref, this);
    }
}
