package com.parser.json.core.parser.model;

import java.util.List;

public record JsonArrayNode(List<JsonNode> elements) implements JsonNode {
    public void addElement(JsonNode element) {
        elements.add(element);
    }

    public JsonNode getElement(int index) {
        return elements.get(index);
    }

    @Override
    public JsonNodeType getType() {
        return JsonNodeType.ARRAY;
    }
}
