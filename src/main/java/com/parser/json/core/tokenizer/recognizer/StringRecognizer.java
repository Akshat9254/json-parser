package com.parser.json.core.tokenizer.recognizer;

import com.parser.json.core.tokenizer.TokenizerCursor;
import com.parser.json.core.tokenizer.model.Token;
import com.parser.json.core.tokenizer.model.TokenType;

public class StringRecognizer implements TokenRecognizer {
    @Override
    public boolean matches(TokenizerCursor cursor) {
        char ch = cursor.peek();
        return ch == '"';
    }

    @Override
    public Token recognize(TokenizerCursor cursor) {
        StringBuilder stringBuilder = new StringBuilder();
        cursor.advance();

        while (cursor.hasNext() && cursor.peek() != '"') {
            stringBuilder.append(cursor.peek());
            cursor.advance();
        }

        cursor.advance();
        return new Token(TokenType.STRING, stringBuilder.toString());
    }
}
