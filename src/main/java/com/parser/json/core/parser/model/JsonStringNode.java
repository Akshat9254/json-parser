package com.parser.json.core.parser.model;

public record JsonStringNode(String value) implements JsonNode {
    @Override
    public JsonNodeType getType() {
        return JsonNodeType.STRING;
    }
}
