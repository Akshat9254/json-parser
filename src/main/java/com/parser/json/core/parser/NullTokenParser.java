package com.parser.json.core.parser;

import com.parser.json.core.parser.model.JsonNode;
import com.parser.json.core.parser.model.JsonNullNode;

public class NullTokenParser implements TokenParser {
    @Override
    public JsonNode parse(ParserCursor cursor, JsonParser jsonParser) {
        cursor.advance();
        return new JsonNullNode();
    }
}
