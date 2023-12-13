package com.xma.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnicodeCharInfoTest {

    UnicodeCharInfo[] infos = {
            new UnicodeCharInfo('0'),
            new UnicodeCharInfo('N'),
            new UnicodeCharInfo('z'),
            new UnicodeCharInfo('Ж'),
            new UnicodeCharInfo(' '),
            new UnicodeCharInfo('\t'),
            new UnicodeCharInfo('&'),
            new UnicodeCharInfo('λ')
    };

    @Test
    void unicodeInt() {
        int[] ints = new int[]{48, 78, 122, 1046, 32, 9, 38, 955};
        for (int i = 0; i < ints.length; i++) {
            assertEquals(ints[i], infos[i].unicodeInt());
        }
    }

    @Test
    void unicodeHex() {
        String[] hexs = new String[]{"U+0030", "U+004E", "U+007A", "U+0416", "U+0020", "U+0009", "U+0026", "U+03BB"};
        for (int i = 0; i < hexs.length; i++) {
            assertEquals(hexs[i], infos[i].unicodeHex());
        }
    }

    @Test
    void nextChar() {
        char[] chars = new char[]{'1', 'O', '{', 'З', '!', '\n', '\'', 'μ'};
        for (int i = 0; i < chars.length; i++) {
            assertEquals(chars[i], infos[i].nextChar());
        }
    }

    @Test
    void prevChar() {
        char[] chars = new char[]{'/', 'M', 'y', 'Е', '\u001F', '\u0008', '%', 'κ'};
        for (int i = 0; i < chars.length; i++) {
            assertEquals(chars[i], infos[i].prevChar());
        }
    }

    @Test
    void charType() {
        UnicodeCharInfo.CharType[] types = new UnicodeCharInfo.CharType[]{
                UnicodeCharInfo.CharType.DIGIT,
                UnicodeCharInfo.CharType.LETTER_UPPER,
                UnicodeCharInfo.CharType.LETTER_LOWER,
                UnicodeCharInfo.CharType.LETTER_UPPER,
                UnicodeCharInfo.CharType.SPACE,
                UnicodeCharInfo.CharType.SPACE,
                UnicodeCharInfo.CharType.OTHER,
                UnicodeCharInfo.CharType.LETTER_LOWER
        };
        for (int i = 0; i < types.length; i++) {
            assertEquals(types[i], infos[i].charType());
        }
    }

    @Test
    void alphabetNumber() {
        int[] nums = new int[]{-1, 14, 26, -1, -1, -1, -1, -1};
        for (int i = 0; i < nums.length; i++) {
            assertEquals(nums[i], infos[i].alphabetNumber());
        }
    }
}