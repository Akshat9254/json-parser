package com.parser.json.core.parser;

import com.parser.json.core.tokenizer.model.Token;
import com.parser.json.core.tokenizer.model.TokenType;

import java.util.List;

public class ParserCursor {
    private final List<Token> tokens;
    private int position;

    public ParserCursor(List<Token> tokens) {
        this.tokens = tokens;
    }

    public Token peek() {
        return tokens.get(position);
    }

    public boolean hasNext() {
        return position < tokens.size();
    }

    public boolean expect(TokenType tokenType) {
        return hasNext() && peek().type() == tokenType;
    }

    public void advance() {
        position++;
    }
}
