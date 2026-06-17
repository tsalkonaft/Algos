package org.tsalko.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class LeetCode009_Test {

    static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(121, true),
                Arguments.of(-121, false),
                Arguments.of(10, false),
                Arguments.of(1234567899, false),
                Arguments.of(1000000001, true)
        );
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void test(int input, boolean expected) {
        Assertions.assertEquals(expected, LeetCode009_PalindromeNumber.isPalindromeUsingString(input));
        Assertions.assertEquals(expected, LeetCode009_PalindromeNumber.isPalindrome(input));
    }

}
