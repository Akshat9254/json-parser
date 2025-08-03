package com.parser.json.core.tokenizer.handler;

import com.parser.json.core.tokenizer.TokenizerCursor;
import com.parser.json.core.tokenizer.model.Token;
import com.parser.json.core.tokenizer.model.TokenType;

public class LeftBracketTokenHandler implements TokenHandler {
    @Override
    public Token handle(TokenizerCursor cursor) {
        cursor.advance();
        return new Token(TokenType.LEFT_BRACKET, null);
    }
}
