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

        ListNode sorted = new ListNode();
        ListNode cur = sorted;

        boolean finished = false;
        int n = lists.length;
        int[] index = new int[n];
        int[] nums = new int[n];

        while (!finished) {
            for (int i = 0; i < n; i ++) {
                ListNode curList = lists[i];

                int j = 0;
                // System.out.println("list: " + i);
                if (lists[i] == null) {
                    // System.out.println("set index = -1, i: " + i + " index[i]: " + index[i]);
                    index[i] = -1;
                } else {
                    nums[i] = lists[i].val;
                }
            }
            // System.out.println(Arrays.toString(nums));

            finished = true;
            for (int i = 0; i < n; i ++) {
                if (index[i] >= 0) {
                    finished = false;
                }
            }
            if (finished)
                break;

            int minIdx = 0;
            int min = 10001;
            for (int i = 0; i < n; i++) {
                if (index[i] >= 0 && nums[i] < min) {
                    // System.out.println("nums[i]: " + nums[i] + ", index[i]: " + index[i] + ", min: " + min + ", i:" + i);
                    min = nums[i];
                    minIdx = i;
                }
            }

            // System.out.println("min: " + min);
            // System.out.println("minIdx: " + minIdx);
            // System.out.println("nums: " + Arrays.toString(nums));

            if (lists[minIdx] != null) {
                lists[minIdx] = lists[minIdx].next;
            }

            // System.out.println("nums after update: " + Arrays.toString(nums));

            ListNode newNode = new ListNode(min);
            cur.next = newNode;
            cur = cur.next;
        }

        return sorted.next;
    }
}