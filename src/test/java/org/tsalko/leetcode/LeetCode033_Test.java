package org.tsalko.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class LeetCode033_Test {
    static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 0, 4),
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 3, -1),
                Arguments.of(new int[]{1}, 0, -1),
                Arguments.of(new int[]{3, 1}, 1, 1),
                Arguments.of(new int[]{1, 3, 5}, 3, 1),
                Arguments.of(new int[]{1, 3, 5}, 5, 2),
                Arguments.of(new int[]{3, 5, 1}, 3, 0),
                Arguments.of(new int[]{5, 1, 3}, 3, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void test(int[] nums, int target, int expected) {
        Assertions.assertEquals(expected, new LeetCode033_SearchInRotatedSortedArray().search(nums, target));
    }

}
