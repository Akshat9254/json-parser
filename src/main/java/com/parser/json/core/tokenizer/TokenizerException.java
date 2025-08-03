package com.parser.json.core.tokenizer;

public class TokenizerException extends RuntimeException {
    public TokenizerException(String s, TokenizerCursor cursor) {
        super(s + "\nat:\n" + cursor.getProcessedInput());
    }
}
