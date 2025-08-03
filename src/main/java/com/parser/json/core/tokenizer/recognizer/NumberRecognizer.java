package com.parser.json.core.tokenizer.recognizer;

import com.parser.json.core.tokenizer.TokenizerCursor;
import com.parser.json.core.tokenizer.model.Token;
import com.parser.json.core.tokenizer.model.TokenType;
import com.parser.json.core.tokenizer.TokenizerException;

public class NumberRecognizer implements TokenRecognizer {
    @Override
    public boolean matches(TokenizerCursor cursor) {
        char ch = cursor.peek();
        return Character.isDigit(ch) || ch == '-';
    }

    @Override
    public Token recognize(TokenizerCursor cursor) {
        StringBuilder numberBuilder = new StringBuilder();

        if (cursor.peek() == '-') {
            numberBuilder.append(cursor.peek());
            cursor.advance();
        }

        if (!cursor.hasNext() || !Character.isDigit(cursor.peek())) {
            throw new TokenizerException("Unexpected end of number at: " + cursor.getPosition(), cursor);
        }

        if (cursor.peek() == '0') {
            if (!numberBuilder.isEmpty() && numberBuilder.charAt(numberBuilder.length() - 1) == '-') {
                throw new TokenizerException("Invalid number at: " + cursor.getPosition(), cursor);
            }
            numberBuilder.append(cursor.peek());
            cursor.advance();

            if (cursor.hasNext() && Character.isDigit(cursor.peek())) {
                throw new TokenizerException("Invalid number: leading zeros at: " + cursor.getPosition(), cursor);
            }

            return null;
        } else if (Character.isDigit(cursor.peek())) {
            while (cursor.hasNext() && Character.isDigit(cursor.peek())) {
                numberBuilder.append(cursor.peek());
                cursor.advance();
            }
        } else {
            throw new TokenizerException("Unexpected character at: " + cursor.getPosition(), cursor);
        }

        if (cursor.hasNext() && cursor.peek() == '.') {
            numberBuilder.append(cursor.peek());
            cursor.advance();
            if (!cursor.hasNext() || !Character.isDigit(cursor.peek())) {
                throw new TokenizerException("Unexpected end of number at: " + cursor.getPosition(), cursor);
            }

            do {
                numberBuilder.append(cursor.peek());
                cursor.advance();
            } while (cursor.hasNext() && Character.isDigit(cursor.peek()));
        }

        return new Token(TokenType.NUMBER, numberBuilder.toString());
    }
}
