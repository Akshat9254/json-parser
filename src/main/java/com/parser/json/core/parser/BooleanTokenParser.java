package com.parser.json.core.parser;

import com.parser.json.core.parser.model.JsonBooleanNode;
import com.parser.json.core.parser.model.JsonNode;
import com.parser.json.core.tokenizer.model.Token;

public class BooleanTokenParser implements TokenParser {
    @Override
    public JsonNode parse(ParserCursor cursor, JsonParser jsonParser) {
        Token token = cursor.peek();
        cursor.advance();
        return new JsonBooleanNode(Boolean.parseBoolean(token.value()));
    }
}
