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
    public ListNode removeNthFromEnd(ListNode head, int n) {
ListNode slowPointer = head;
            ListNode fastPointer = head;
            int size = 0;

            while (fastPointer != null && fastPointer.next != null) {
                fastPointer = fastPointer.next.next;
                size += 2;
            }

            if (fastPointer != null) {
                size++;
            }

            int i = size;
            ListNode previousNode = slowPointer;
            ListNode currentNode = slowPointer;
            while (i >= n) {
                if (i == n) {
                    if (currentNode != head) {
                        previousNode.next = currentNode.next;
                    } else {
                        return head.next;
                    }
                    currentNode.next = null;
                    break;
                }
                previousNode = currentNode;
                currentNode = currentNode.next;
                i--;
            }

            return head;
    }
}
