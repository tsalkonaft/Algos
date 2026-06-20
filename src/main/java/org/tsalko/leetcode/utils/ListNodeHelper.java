package org.tsalko.leetcode.utils;

public class ListNodeHelper {

    public static ListNode listNode(int... nums) {
        ListNode head = new ListNode(nums[nums.length - 1]);
        for (int i = nums.length - 2; i >= 0; i--) {
            ListNode prev = head;
            head = new ListNode(nums[i], prev);
        }
        return head;
    }

}
