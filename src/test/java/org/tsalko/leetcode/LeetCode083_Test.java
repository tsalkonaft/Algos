package org.tsalko.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.tsalko.leetcode.utils.ListNode;

import java.util.stream.Stream;

import static org.tsalko.leetcode.utils.ListNodeHelper.listNode;

public class LeetCode083_Test {

    static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(listNode(1, 1, 2), listNode(1, 2)),
                Arguments.of(listNode(1, 1, 2, 3, 3), listNode(1, 2, 3))
        );
    }


    @ParameterizedTest
    @MethodSource("dataProvider")
    public void test(ListNode list, ListNode expected) {
        Assertions.assertEquals(expected, new LeetCode083_RemoveDuplicatesFromSortedList().deleteDuplicates(list));
    }

}
