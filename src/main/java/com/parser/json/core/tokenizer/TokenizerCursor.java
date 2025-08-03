package com.parser.json.core.tokenizer;

public class TokenizerCursor {
    private final String input;
    private int position;

    public int getPosition() {
        return position;
    }

    public String getProcessedInput() {
        int start = Math.max(0, position - 10);
        return input.substring(start, position);
    }

    public TokenizerCursor(String input) {
        this.input = input;
    }

    public boolean hasNext() {
        return position < input.length();
    }

    public char peek() {
        return input.charAt(position);
    }

    public void advance() {
        advance(1);
    }

    public boolean startsWith(String value) {
        return input.startsWith(value, position);
    }

    public void advance(int length) {
        position += length;
    }
}
