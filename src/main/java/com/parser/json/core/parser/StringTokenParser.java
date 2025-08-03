package com.parser.json.core.parser;

import com.parser.json.core.parser.model.JsonNode;
import com.parser.json.core.parser.model.JsonStringNode;
import com.parser.json.core.tokenizer.model.Token;

public class StringTokenParser implements TokenParser {
    @Override
    public JsonNode parse(ParserCursor cursor, JsonParser jsonParser) {
        Token token = cursor.peek();
        cursor.advance();
        return new JsonStringNode(token.value());
    }
}
