package org.tsalko.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Stream;

public class AllSubstringsOfGivenLengthWithUniqueCharsTest {

    static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of("abcabcbb",    3,  new LinkedHashSet<>(List.of("abc", "bca", "cab"))   ),
                Arguments.of("aaabc",       3,  new LinkedHashSet<>(List.of("abc"))             )
        );
    }


    @ParameterizedTest
    @MethodSource("dataProvider")
    public void test(String s, int k, LinkedHashSet<String> expected) {
        Assertions.assertEquals(expected, AllSubstringsOfGivenLengthWithUniqueChars.findSubstringsWithUniqueChars(s, k));
    }
}
