package com.xma.task1;

public class UnicodeCharInfo {
    public static final int UNICODE_MIN_CHAR = 0;
    public static final int UNICODE_MAX_CHAR = 0x10FFFF;
    private char symbol;

    public UnicodeCharInfo(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int unicodeInt() {
        return symbol;
    }

    public String unicodeHex() {
        return "U+%04X".formatted(unicodeInt());
    }

    public char nextChar() {
        if (unicodeInt() == UNICODE_MAX_CHAR) {
            throw new IllegalStateException("Для данного символа не сужествует следующего");
        }
        return (char) (symbol + 1);
    }

    public char prevChar() {
        if (unicodeInt() == UNICODE_MIN_CHAR) {
            throw new IllegalStateException("Для данного символа не сужествует пердыдущего");
        }
        return (char) (symbol - 1);
    }

    public CharType charType() {
        if (Character.isDigit(symbol)) return CharType.DIGIT;
        if (Character.isWhitespace(symbol)) return CharType.SPACE;
        if (Character.isLetter(symbol)) {
            return Character.isUpperCase(symbol) ? CharType.LETTER_UPPER : CharType.LETTER_LOWER;
        }
        return CharType.OTHER;
    }

    public int alphabetNumber() {
        if ('A' <= symbol && symbol <= 'Z') return symbol - 'A' + 1;
        if ('a' <= symbol && symbol <= 'z') return symbol - 'a' + 1;
        return -1;
    }


    public enum CharType {
        DIGIT,
        LETTER_UPPER,
        LETTER_LOWER,
        SPACE,
        OTHER
    }
}
