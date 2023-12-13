package com.xma.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    private String string;

    public StringUtils(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public int[] search(String pattern) {
        return search(pattern, true);
    }

    public int[] search(String pattern, boolean ignoreCase) {
        int flags = ignoreCase ? Pattern.CASE_INSENSITIVE : 0;
        Matcher matcher = Pattern.compile(pattern, flags).matcher(string);
        List<Integer> nums = new ArrayList<>();
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            while (start < end) {
                nums.add(start);
                start++;
            }
        }
        return nums.stream().mapToInt(i -> i).toArray();
    }

    public int replace(String search, String replacement) {
        return replace(search, replacement, true);
    }

    public int replace(String search, String replacement, boolean ignoreCase) {
        int flags = ignoreCase ? Pattern.CASE_INSENSITIVE : 0;
        Pattern pattern = Pattern.compile(search, flags);
        Matcher matcher = pattern.matcher(string);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        string = string.replaceAll(search, replacement);
        return count;
    }


}
