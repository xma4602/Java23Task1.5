package com.xma.task3;

public class Transliteration {
    private static final String[] ENG = {
            "shh", "sh", "zh", "ch", "cz", "yu", "ya", "yo",
            "``", "e`", "y`",
            "a", "b", "v", "g",
            "d", "e", "z", "i",
            "j", "k", "l", "m",
            "n", "o", "p", "r",
            "s", "t", "u", "f",
            "x", "`",
    };
    private static final String[] RUS = {
            "щ", "ш", "ж", "ч", "ц", "ю", "я", "ё",
            "ъ", "э", "ы",
            "а", "б", "в", "г",
            "д", "е", "з", "и",
            "й", "к", "л", "м",
            "н", "о", "п", "р",
            "с", "т", "у", "ф",
            "х", "ь",
    };

    public static String translateRusToEng(String string) {
        return translate(RUS, ENG, string);

    }

    public static String translateEngToRus(String string) {
        return translate(ENG, RUS, string);
    }

    private static String translate(String[] from, String[] to, String source) {
        String clone = source.toLowerCase();
        StringBuilder result = new StringBuilder();

        for (int offset = 0; offset < source.length(); ) {
            int j = 0;
            for (; j < from.length; j++) {
                if (clone.startsWith(from[j], offset)) {
                    StringBuilder replace = new StringBuilder(to[j]);
                    if (Character.isUpperCase(source.charAt(offset))) {
                        replace.setCharAt(0, Character.toUpperCase(to[j].charAt(0)));
                    }
                    result.append(replace);
                    offset += from[j].length();
                    break;
                }
            }
            if (j == from.length) {
                result.append(source.charAt(offset));
                offset++;
            }
        }
        return result.toString();
    }

}
