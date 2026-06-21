package org.tsalko.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class LeetCode004_Test {

    static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 3}, new int[]{2}, 2.0),
                Arguments.of(new int[]{1, 2}, new int[]{3, 4}, 2.5),
                Arguments.of(new int[]{1, 3, 8, 9, 15}, new int[]{7, 11, 19, 21, 25, 30}, 11.0),
                Arguments.of(new int[]{2}, new int[]{}, 2.0),
                Arguments.of(new int[]{1, 3}, new int[]{2}, 2.0),
                Arguments.of(new int[]{-10, -9, -8}, new int[]{1, 2}, -8.0)
        );
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void test(int[] nums1, int[] nums2, double expected) {
        Assertions.assertEquals(expected, new LeetCode004_MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2));
        Assertions.assertEquals(expected, new LeetCode004_MedianOfTwoSortedArrays().findMedianSortedArraysByMerge(nums1, nums2));
    }

}
