package com.parser.json.core.parser.model;

import java.util.Map;

public record JsonObjectNode(Map<String, JsonNode> properties) implements JsonNode {
    public void addProperty(String key, JsonNode value) {
        properties.put(key, value);
    }

    public JsonNode getProperty(String key) {
        return properties.get(key);
    }

    @Override
    public JsonNodeType getType() {
        return JsonNodeType.OBJECT;
    }
}
