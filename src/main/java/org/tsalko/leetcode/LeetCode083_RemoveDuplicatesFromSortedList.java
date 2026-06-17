package org.tsalko.leetcode;

public class LeetCode083_RemoveDuplicatesFromSortedList {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode tempNode = new ListNode(head.val);

        ListNode nextNode = head.next;

        while (nextNode != null) {
            if (nextNode.val != tempNode.val) {
                tempNode = new ListNode(nextNode.val, tempNode);
            }
            nextNode = nextNode.next;
        }

        ListNode resultNode = new ListNode(tempNode.val);
        ListNode nextResultNode = tempNode.next;
        while (nextResultNode != null) {
            resultNode = new ListNode(nextResultNode.val, resultNode);
            nextResultNode = nextResultNode.next;
        }
        return resultNode;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof ListNode listNode) {
                return this.val == listNode.val
                        && (this.next == null && listNode.next == null
                        || this.next != null && this.next.equals(listNode.next)
                );
            }
            return false;
        }
    }

}
