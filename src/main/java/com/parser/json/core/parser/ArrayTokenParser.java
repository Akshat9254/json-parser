package com.parser.json.core.parser;

import com.parser.json.core.parser.model.JsonArrayNode;
import com.parser.json.core.parser.model.JsonNode;
import com.parser.json.core.tokenizer.model.TokenType;

import java.util.ArrayList;
import java.util.List;

public class ArrayTokenParser implements TokenParser {
    @Override
    public JsonNode parse(ParserCursor cursor, JsonParser jsonParser) {
        if( !cursor.expect(TokenType.LEFT_BRACKET) ) {
            throw new ParserException("Invalid json: expected '['");
        }

        cursor.advance();
        List<JsonNode> elements = new ArrayList<>();
        while(cursor.hasNext()) {
            JsonNode element = jsonParser.parse(cursor);
            elements.add(element);

            if (cursor.peek().type() == TokenType.RIGHT_BRACKET) {
                break;
            }

            if (!cursor.expect(TokenType.COMMA)) {
                throw new ParserException("Invalid json: expected ','");
            }
            cursor.advance();
        }

        if (!cursor.expect(TokenType.RIGHT_BRACKET)) {
            throw new ParserException("Invalid json: expected ']'");
        }
        cursor.advance();

        return new JsonArrayNode(elements);
    }
}
