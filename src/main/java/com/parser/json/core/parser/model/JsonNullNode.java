package com.parser.json.core.parser.model;

public record JsonNullNode() implements JsonNode {
    @Override
    public JsonNodeType getType() {
        return JsonNodeType.NULL;
    }
}
