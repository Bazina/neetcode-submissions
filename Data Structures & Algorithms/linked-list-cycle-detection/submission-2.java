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
    public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null || head.next.next == null) {
                return false;
            }

            ListNode slowPointer = head;
            ListNode fastPointer = head.next.next;

            while (fastPointer != null && fastPointer.next != null) {
                 if (fastPointer == slowPointer) {
                    return true;
                }

                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next.next;
            }

            return false;
        }
}
