package com.parser.json.core.parser;

import com.parser.json.core.parser.model.JsonNode;

public interface TokenParser {
    JsonNode parse(ParserCursor cursor, JsonParser jsonParser);
}
