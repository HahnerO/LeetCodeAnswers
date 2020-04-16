public class Solution {
    public class ListNode{
        int val;
        ListNode next;
        public ListNode(int v) {
            this.val = v;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        ListNode q = dummy;
        for (int i = n; i >= 0; i--){
            q = q.next;
        }
        while (q != null) {
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return dummy.next;
    }
}
