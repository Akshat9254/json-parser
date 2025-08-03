package com.parser.json.core.tokenizer.recognizer;

import com.parser.json.core.tokenizer.TokenizerCursor;
import com.parser.json.core.tokenizer.model.Token;

public interface TokenRecognizer {
    boolean matches(TokenizerCursor cursor);
    Token recognize(TokenizerCursor cursor);
}
