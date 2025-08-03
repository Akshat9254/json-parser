package com.parser.json.core.parser.model;

import java.math.BigDecimal;

public record JsonNumberNode(BigDecimal value) implements JsonNode {
    @Override
    public JsonNodeType getType() {
        return JsonNodeType.NUMBER;
    }
}
