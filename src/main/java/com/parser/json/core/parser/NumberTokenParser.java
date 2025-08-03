package com.parser.json.core.parser;

import com.parser.json.core.parser.model.JsonNode;
import com.parser.json.core.parser.model.JsonNumberNode;
import com.parser.json.core.tokenizer.model.Token;

import java.math.BigDecimal;

public class NumberTokenParser implements TokenParser {
    @Override
    public JsonNode parse(ParserCursor cursor, JsonParser jsonParser) {
        Token token = cursor.peek();
        cursor.advance();
        return new JsonNumberNode(new BigDecimal(token.value()));
    }
}
