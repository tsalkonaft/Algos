package org.tsalko.leetcode.utils;

public class ListNode {
    public int val;
    public ListNode next;

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
