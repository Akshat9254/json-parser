package com.parser.json.core.tokenizer;

import com.parser.json.core.tokenizer.handler.ColonTokenHandler;
import com.parser.json.core.tokenizer.handler.CommaTokenHandler;
import com.parser.json.core.tokenizer.handler.LeftBracketTokenHandler;
import com.parser.json.core.tokenizer.handler.LeftParenthesisTokenHandler;
import com.parser.json.core.tokenizer.handler.RightBracketTokenHandler;
import com.parser.json.core.tokenizer.handler.RightParenthesisTokenHandler;
import com.parser.json.core.tokenizer.handler.TokenHandler;
import com.parser.json.core.tokenizer.model.Token;
import com.parser.json.core.tokenizer.model.TokenType;
import com.parser.json.core.tokenizer.recognizer.BooleanRecognizer;
import com.parser.json.core.tokenizer.recognizer.NullRecognizer;
import com.parser.json.core.tokenizer.recognizer.NumberRecognizer;
import com.parser.json.core.tokenizer.recognizer.StringRecognizer;
import com.parser.json.core.tokenizer.recognizer.TokenRecognizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Tokenizer {
    private final Map<Character, TokenHandler> tokenHandlers = Map.of(
            '{', new LeftParenthesisTokenHandler(),
            '}', new RightParenthesisTokenHandler(),
            '[', new LeftBracketTokenHandler(),
            ']', new RightBracketTokenHandler(),
            ':', new ColonTokenHandler(),
            ',', new CommaTokenHandler()
    );

    private final List<TokenRecognizer> tokenRecognizers = List.of(
            new StringRecognizer(),
            new NumberRecognizer(),
            new BooleanRecognizer(),
            new NullRecognizer()
    );

    private final TokenizerCursor cursor;

    public Tokenizer(String input) {
        this.cursor = new TokenizerCursor(input);
    }

    public List<Token> tokenize() {
        List<Token> tokens = new ArrayList<>();

        while(cursor.hasNext()) {
            char ch = cursor.peek();
            if (Character.isWhitespace(ch)) {
                cursor.advance();
                continue;
            }

            Token token;
            if (tokenHandlers.containsKey(ch)) {
                token = tokenHandlers.get(ch).handle(cursor);
            } else {
                token = tokenRecognizers.stream()
                        .filter(tokenRecognizer -> tokenRecognizer.matches(cursor))
                        .findFirst()
                        .map(tokenRecognizer -> tokenRecognizer.recognize(cursor))
                        .orElse(null);
            }

            if (token != null) {
                tokens.add(token);
            }
        }

        tokens.add(new Token(TokenType.EOF, null));
        return tokens;
    }
}
