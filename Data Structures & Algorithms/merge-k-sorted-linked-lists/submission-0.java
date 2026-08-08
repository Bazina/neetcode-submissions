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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
                return null;
            }
            return divideAndConquer(lists, 0, lists.length - 1);
        }

        public ListNode divideAndConquer(ListNode[] lists, int l, int r) {
            if (l == r)
                return lists[l];

            int mid = (l + r) / 2;

            lists[l] = divideAndConquer(lists, l, mid);
            lists[r] = divideAndConquer(lists, mid + 1, r);

            return mergeTwoLists(lists[l], lists[r]);
        }

        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode currentNode = new ListNode();
            ListNode head = currentNode;

            while (list1 != null && list2 != null) {
                if (list1.val > list2.val) {
                    currentNode.next = list2;
                    list2 = list2.next;
                } else {
                    currentNode.next = list1;
                    list1 = list1.next;
                }
                currentNode = currentNode.next;
            }

            if (list1 != null) {
                currentNode.next = list1;
            } else if (list2 != null) {
                currentNode.next = list2;
            }

            return head.next;
        }
}
