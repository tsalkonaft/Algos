package org.tsalko.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class LeetCode056_Test {

    static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}},    new int[][]{{1, 6}, {8, 10}, {15, 18}   }),
                Arguments.of(new int[][]{{1, 4}, {4, 5}},                       new int[][]{{1, 5}                      }),
                Arguments.of(new int[][]{{4, 7}, {1, 4}},                       new int[][]{{1, 7}                      }),
                Arguments.of(new int[][]{{1, 4}, {0, 0}},                       new int[][]{{0, 0}, {1, 4}              }),
                Arguments.of(new int[][]{{2, 3}, {5, 5}, {2, 2}, {3, 4}, {3, 4}},new int[][]{{2, 4}, {5, 5}              })
        );
    }


    @ParameterizedTest
    @MethodSource("dataProvider")
    public void test(int[][] intervals, int[][] expected) {
        Assertions.assertArrayEquals(expected, new LeetCode056_MergeIntervals().merge(intervals));
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void test2(int[][] intervals, int[][] expected) {
        Assertions.assertArrayEquals(expected, new LeetCode056_MergeIntervals().merge2(intervals));
    }

}
