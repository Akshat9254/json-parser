package com.parser.json.core.parser.model;

public record JsonBooleanNode(Boolean value) implements JsonNode {
    @Override
    public JsonNodeType getType() {
        return JsonNodeType.BOOLEAN;
    }
}
