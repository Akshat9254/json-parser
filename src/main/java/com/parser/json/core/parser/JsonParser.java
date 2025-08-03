package com.parser.json.core.parser;

import com.parser.json.core.binder.Binder;
import com.parser.json.core.binder.type.TypedReference;
import com.parser.json.core.tokenizer.Tokenizer;
import com.parser.json.core.tokenizer.model.Token;
import com.parser.json.core.parser.model.JsonNode;
import com.parser.json.core.tokenizer.model.TokenType;

import java.util.List;
import java.util.Map;

public class JsonParser {
    public static final Binder binder = new Binder();

    private static final Map<TokenType, TokenParser> tokenParsers = Map.of(
            TokenType.LEFT_PAREN, new ObjectTokenParser(),
            TokenType.LEFT_BRACKET, new ArrayTokenParser(),
            TokenType.STRING, new StringTokenParser(),
            TokenType.NUMBER, new NumberTokenParser(),
            TokenType.BOOLEAN, new BooleanTokenParser(),
            TokenType.NULL, new NullTokenParser()
    );

    public <T> T parse(String json, Class<T> clazz) {
        return parse(json, TypedReference.of(clazz));
//        JsonNode jsonNode = parse(json);
//        return binder.bind(jsonNode, new ClassType<>(clazz));
    }

    public <T> T parse(String json, TypedReference<T> ref) {
        JsonNode jsonNode = parse(json);
        return binder.bind(jsonNode, ref);
    }

    public JsonNode parse(String json) {
        Tokenizer tokenizer = new Tokenizer(json);
        List<Token> tokens = tokenizer.tokenize();

        ParserCursor parserCursor = new ParserCursor(tokens);
        JsonNode jsonNode = parse(parserCursor);

        if (!parserCursor.expect(TokenType.EOF)) {
            throw new ParserException("Invalid json");
        }

        return jsonNode;
    }

    public JsonNode parse(ParserCursor cursor) {
        cursor.peek();
        TokenParser tokenParser = tokenParsers.get(cursor.peek().type());
        if (tokenParser == null) {
            throw new ParserException("Invalid json: unexpected token: " + cursor.peek().type());
        }
        return tokenParser.parse(cursor, this);
    }
}
