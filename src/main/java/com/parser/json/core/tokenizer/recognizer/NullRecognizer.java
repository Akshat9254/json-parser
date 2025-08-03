package com.parser.json.core.tokenizer.recognizer;

import com.parser.json.core.tokenizer.TokenizerCursor;
import com.parser.json.core.tokenizer.model.Token;
import com.parser.json.core.tokenizer.model.TokenType;

public class NullRecognizer implements TokenRecognizer {
    private static final String NULL = "null";

    @Override
    public boolean matches(TokenizerCursor cursor) {
        return cursor.startsWith(NULL);
    }

    @Override
    public Token recognize(TokenizerCursor cursor) {
        cursor.advance(NULL.length());
        return new Token(TokenType.NULL, null);
    }
}
