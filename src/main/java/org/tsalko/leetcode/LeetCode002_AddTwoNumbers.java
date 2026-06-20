package org.tsalko.leetcode;

import org.tsalko.leetcode.utils.ListNode;

/**
 * Add two numbers
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * <p>
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * <p>
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */
public class LeetCode002_AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Adjust by adding missing zeros to senior digits of smaller number
        ListNode current1 = l1;
        ListNode current2 = l2;
        while (current1.next != null || current2.next != null) {
            if (current1.next == null) {
                current1.next = new ListNode(0, null);
            } else if (current2.next == null) {
                current2.next = new ListNode(0, null);
            }

            current1 = current1.next;
            current2 = current2.next;
        }

        // Summarize
        int overflowed = 0;
        current1 = l1;
        current2 = l2;
        while (current1 != null) {
            int sum = current1.val + current2.val + overflowed;
            current1.val = sum % 10;
            overflowed = sum / 10;

            if (current1.next == null && overflowed == 1) {
                current1.next = new ListNode(1, null);
                current1 = current1.next;
            }

            current1 = current1.next;
            current2 = current2.next;
        }

        return l1;
    }
}