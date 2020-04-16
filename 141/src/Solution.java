public class Solution {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        while (head != null){
            if (head == head.next) return true;
            if (head.next != null){
                head.next = head.next.next;
            }
            head = head.next;
        }
        return false;
    }
}
