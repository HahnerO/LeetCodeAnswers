public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode left = head;
        ListNode right = head.next;

        while (right != null){
            if (left.val != right.val){
                left.next = right;
                left = left.next;
            }
            right = right.next;
        }
        left.next = null;
        return head;
    }
}
