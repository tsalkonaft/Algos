package org.tsalko.uniquisubstring;

public class LeetCode083_RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode tempNode = new ListNode(head.val);

        ListNode nextNode = head.next;;
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

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
