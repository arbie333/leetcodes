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
class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode temp = new ListNode();
        ListNode curr = head;

        while (curr != null) {

            ListNode prev = temp;

            // comparison
            while (prev.next != null && prev.next.val <= curr.val) {
                prev = prev.next;
            }

            ListNode next = curr.next;

            curr.next = prev.next;
            prev.next = curr;
            curr = next;
        }

        return temp.next;
    }
}