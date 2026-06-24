package org.tsalko.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class LeetCode006_Test {

    static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"),
                Arguments.of("PAYPALISHIRING", 4, "PINALSIGYAHRPI"),
                Arguments.of("A", 1, "A")
        );
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void test(String s, int numRows, String expected) {
        Assertions.assertEquals(expected, new LeetCode006_ZigzagConversion().convert(s, numRows));
    }

}
