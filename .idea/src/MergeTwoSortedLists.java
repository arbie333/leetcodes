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
class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode cur = head;

        while (list1 != null || list2 != null) {
            if (list1 == null) {
                ListNode newNode = new ListNode(list2.val);
                cur.next = newNode;
                cur = newNode;
                list2 = list2.next;
            } else if (list2 == null) {
                ListNode newNode = new ListNode(list1.val);
                cur.next = newNode;
                cur = newNode;
                list1 = list1.next;
            } else if (list1.val <= list2.val) {
                ListNode newNode = new ListNode(list1.val);
                cur.next = newNode;
                cur = newNode;
                list1 = list1.next;
            } else {
                ListNode newNode = new ListNode(list2.val);
                cur.next = newNode;
                cur = newNode;
                list2 = list2.next;
            }
        }

        return head.next;
    }
}