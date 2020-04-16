public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (true){
            if (fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
            if (fast == slow) break;
        }

        fast = head;
        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
