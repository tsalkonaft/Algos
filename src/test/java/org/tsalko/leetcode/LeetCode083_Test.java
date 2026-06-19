package org.tsalko.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.tsalko.leetcode.LeetCode083_RemoveDuplicatesFromSortedList.ListNode;

import java.util.stream.Stream;

public class LeetCode083_Test {

    static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(new ListNode(1, new ListNode(1, new ListNode(2))),
                        new ListNode(1, new ListNode(2))
                )
        );
    }


    @ParameterizedTest
    @MethodSource("dataProvider")
    public void test(ListNode list, ListNode expected) {
        Assertions.assertEquals(expected, new LeetCode083_RemoveDuplicatesFromSortedList().deleteDuplicates(list));
    }
}
