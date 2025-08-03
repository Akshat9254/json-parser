package com.parser.json.core.tokenizer.handler;

import com.parser.json.core.tokenizer.TokenizerCursor;
import com.parser.json.core.tokenizer.model.Token;

public interface TokenHandler {
    Token handle(TokenizerCursor cursor);
}
