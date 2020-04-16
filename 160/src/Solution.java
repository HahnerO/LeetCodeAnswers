public class Solution {
    public class ListNode{
        int val;
        ListNode next;
        public ListNode(int v){
            this.val = v;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode A = headA;
        ListNode B = headB;
        int sndRun = 0;
        while (A != B) {
            A = A.next;
            B = B.next;
            if (A == null && B == null) return null;
            if (A == null) A = headB;
            if (B == null) B = headA;
        }
        return A;
    }
}
