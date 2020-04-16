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

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left = dummy;
        ListNode right = head;
        while (right != null){
            if (right.val != left.next.val) {
                if (right != left.next.next) {
                    left.next = right;
                }else {
                    left = left.next;
                }
            }
            right = right.next;
        }
        if (left.next.next != null) left.next = null;
        return dummy.next;
    }
}
