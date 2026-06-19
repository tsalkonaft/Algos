package org.tsalko.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class LeetCode003_Test {

    static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of("abcabcbb", "abc"),
                Arguments.of("bbbbbb", "b"),
                Arguments.of("pwwkew", "wke")

        );
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void testMaxUniqueSubstringNaive(String input, String expected) {
        Assertions.assertEquals(expected, new LeetCode003_LongestSubstringWithoutRepeatingCharacters().getMaxUniqueSubStringNaive(input));
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void testMaxUniqueSubstringSlidingWindow(String input, String expected) {
        Assertions.assertEquals(expected, new LeetCode003_LongestSubstringWithoutRepeatingCharacters().getMaxUniqueSubStringSlidingWindow(input));
    }
}
