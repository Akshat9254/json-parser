package com.parser.json.core.parser;

import com.parser.json.core.parser.model.JsonNode;
import com.parser.json.core.parser.model.JsonObjectNode;
import com.parser.json.core.tokenizer.model.TokenType;

import java.util.HashMap;
import java.util.Map;

public class ObjectTokenParser implements TokenParser {
    @Override
    public JsonNode parse(ParserCursor cursor, JsonParser jsonParser) {
        if(!cursor.expect(TokenType.LEFT_PAREN) ) {
            throw new ParserException("Invalid json: expected '{'");
        }

        cursor.advance();
        Map<String, JsonNode> properties = new HashMap<>();

        while (cursor.hasNext()) {
            if(!cursor.expect(TokenType.STRING)) {
                throw new ParserException("Invalid json: expected string in key");
            }

            String key = cursor.peek().value();
            cursor.advance();

            if(!cursor.expect(TokenType.COLON)) {
                throw new ParserException("Invalid json: expected ':'");
            }
            cursor.advance();

            JsonNode value = jsonParser.parse(cursor);
            properties.put(key, value);

            if (cursor.peek().type() == TokenType.RIGHT_PAREN) {
                break;
            }

            if (!cursor.expect(TokenType.COMMA)) {
                throw new ParserException("Invalid json: expected ','");
            }

            cursor.advance();
        }

        if (!cursor.expect(TokenType.RIGHT_PAREN)) {
            throw new ParserException("Invalid json: expected '}'");
        }
        cursor.advance();
        return new JsonObjectNode(properties);
    }
}
