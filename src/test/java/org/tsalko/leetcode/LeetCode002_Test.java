package org.tsalko.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.tsalko.leetcode.utils.ListNode;

import java.util.stream.Stream;

import static org.tsalko.leetcode.utils.ListNodeHelper.listNode;

public class LeetCode002_Test {

    static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(listNode(2, 4, 3), listNode(5, 6, 4), listNode(7, 0, 8)),
                Arguments.of(listNode(0), listNode(0), listNode(0)),
                Arguments.of(listNode(9, 9, 9, 9, 9, 9, 9), listNode(9, 9, 9, 9), listNode(8, 9, 9, 9, 0, 0, 0, 1)),
                Arguments.of(listNode(9, 1, 1), listNode(2), listNode(1, 2, 1)),
                Arguments.of(listNode(9, 9), listNode(2), listNode(1, 0, 1))
        );
    }


    @ParameterizedTest
    @MethodSource("dataProvider")
    public void test(ListNode list1, ListNode list2, ListNode expected) {
        Assertions.assertEquals(expected, new LeetCode002_AddTwoNumbers().addTwoNumbers(list1, list2));
    }


}
