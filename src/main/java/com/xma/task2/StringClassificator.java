package com.xma.task2;

import java.util.regex.Pattern;

public class StringClassificator {

    private final static Pattern innPattern = Pattern.compile("(^\\d{10}$)|(^\\d{12}$)");
    private final static Pattern emailPattern = Pattern.compile("^[a-z][a-z0-9._]*@[a-z.]+\\.[a-z]+$");
    private final static Pattern phonePattern = Pattern.compile("^\\+\\d{11}$");
    private final static Pattern namePattern = Pattern.compile("^[A-Za-z][A-Za-z0-9_$.]*$");

    public static String parse(String token) {
        token = token.trim();
        if (innPattern.matcher(token).find()) {
            return "ИНН";
        }
        if (emailPattern.matcher(token).find()) {
            return "email";
        }
        if (token.length() >= 8 && namePattern.matcher(token).find()) {
            return "username";
        }
        token = token.replaceAll("[()\\- ]", "");
        if (phonePattern.matcher(token).find()) {
            return "телефон";
        }
        return "none";
    }

}
