package org.tsalko.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class LeetCode001_Test {

    static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(array(2,7,11,15),  9,  array(0, 1)),
                Arguments.of(array(3,2,4),      6,  array(1, 2)),
                Arguments.of(array(3,3),        6,  array(0, 1))

        );
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void test(int[] nums, int target,  int[] expected) {
        Assertions.assertArrayEquals(expected, new LeetCode001_TwoSum().twoSum(nums, target));
    }

    private static int[] array(int... array) {
        return array;
    }

}
