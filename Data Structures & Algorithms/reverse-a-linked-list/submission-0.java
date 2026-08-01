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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
                return head;

            ListNode previousNode = head;
            ListNode currentNode = head.next;
            ListNode nextNode = head.next.next;

            previousNode.next = null;

            while (nextNode != null) {
                ListNode nextDummy = nextNode;
                ListNode currentDummy = currentNode;

                currentNode.next = previousNode;

                nextNode = nextNode.next;
                currentNode = nextDummy;
                previousNode = currentDummy;
            }

            currentNode.next = previousNode;

            return currentNode;
        }
}
