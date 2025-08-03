package com.parser.json.core.tokenizer.recognizer;

import com.parser.json.core.tokenizer.TokenizerCursor;
import com.parser.json.core.tokenizer.model.Token;
import com.parser.json.core.tokenizer.model.TokenType;

public class BooleanRecognizer implements TokenRecognizer {
    @Override
    public boolean matches(TokenizerCursor cursor) {
        return cursor.startsWith(Boolean.TRUE.toString()) ||
                cursor.startsWith(Boolean.FALSE.toString());
    }

    @Override
    public Token recognize(TokenizerCursor cursor) {
        Boolean value = cursor.startsWith(Boolean.TRUE.toString()) ? Boolean.TRUE : Boolean.FALSE;
        cursor.advance(value.toString().length());
        return new Token(TokenType.BOOLEAN, value.toString());
    }
}
