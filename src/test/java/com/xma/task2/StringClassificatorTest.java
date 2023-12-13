package com.xma.task2;

import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class StringClassificatorTest {

    SortedMap<String, String> map = new TreeMap<>(Map.ofEntries(
            new AbstractMap.SimpleEntry<>("user.name@example.com", "email"),
            new AbstractMap.SimpleEntry<>("@example.com", "none"),
            new AbstractMap.SimpleEntry<>("user.name.example.com", "username"),
            new AbstractMap.SimpleEntry<>("user.name@example", "none"),
            new AbstractMap.SimpleEntry<>("user_name1@some.example.com", "email"),
            new AbstractMap.SimpleEntry<>("+7-(123)-456-78-90", "телефон"),
            new AbstractMap.SimpleEntry<>("+7(123)456-78-90", "телефон"),
            new AbstractMap.SimpleEntry<>("+7-123-456-78-90", "телефон"),
            new AbstractMap.SimpleEntry<>("  +71234567890  ", "телефон"),
            new AbstractMap.SimpleEntry<>("71234567890", "none"),
            new AbstractMap.SimpleEntry<>("1234567890", "ИНН"),
            new AbstractMap.SimpleEntry<>("000000000000", "ИНН"),
            new AbstractMap.SimpleEntry<>("7777-8888-9999", "none"),
            new AbstractMap.SimpleEntry<>("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz.$1234_", "username"),
            new AbstractMap.SimpleEntry<>("aaaa1111", "username"),
            new AbstractMap.SimpleEntry<>("a", "none"),
            new AbstractMap.SimpleEntry<>("qwerty 456", "none"),
            new AbstractMap.SimpleEntry<>("4abc", "none"),
            new AbstractMap.SimpleEntry<>("$asdfghjk", "none"),
            new AbstractMap.SimpleEntry<>("", "none")
    ));

    @Test
    void parse() {
        for (var item : map.entrySet()) {
            String parse = StringClassificator.parse(item.getKey());
            //System.out.printf("\"%30s\" - \"%7s\" -> \"%7s\"\n", item.getKey(), item.getValue(), parse);
            assertEquals(item.getValue(), parse);
        }
    }
}