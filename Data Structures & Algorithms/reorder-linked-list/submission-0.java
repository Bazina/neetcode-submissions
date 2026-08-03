/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode slowPointer = head;
            ListNode fastPointer = head.next;

            while (fastPointer != null && fastPointer.next != null) {
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next.next;
            }

            ListNode currentNode = slowPointer.next;
            ListNode previousNode = null;

            slowPointer.next = null;

            while (currentNode != null) {
                ListNode nextNode = currentNode.next;

                currentNode.next = previousNode;
                previousNode = currentNode;
                currentNode = nextNode;
            }

            ListNode firstHalfHead = head;
            ListNode secondHalfNode = previousNode;
            while (secondHalfNode != null) {
                ListNode tmp1 = firstHalfHead.next;
                ListNode tmp2 = secondHalfNode.next;

                firstHalfHead.next = secondHalfNode;
                secondHalfNode.next = tmp1;

                firstHalfHead = tmp1;
                secondHalfNode = tmp2;
            }
    }
}