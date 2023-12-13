package com.xma.task4;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    void search() {
        String pattern = "xxx";
        StringUtils utils = new StringUtils("aaaxxxcccXXX");

        assertArrayEquals(new int[]{3, 4, 5, 9, 10, 11},  utils.search(pattern, true));
        assertArrayEquals(new int[]{3, 4, 5}, utils.search(pattern, false));
    }

    @Test
    void replace() {
        String pattern = "xxx";
        String replacement = "yyy";

        StringUtils utils = new StringUtils("aaaxxxcccXXX");
        assertEquals(2,  utils.replace(pattern, replacement, true));

        utils = new StringUtils("aaaxxxcccXXX");
        assertEquals(1, utils.replace(pattern, replacement, false));
    }

}