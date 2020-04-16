public class Solution {
    public class ListNode{
        ListNode next;
        int val;
        public ListNode(int v) {
            this.val = v;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode next = head;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                next.next = l1;
                next = l1;
                l1 = l1.next;
            }else {
                next.next = l2;
                next = l2;
                l2 = l2.next;
            }
        }
        if (l1 == null){
            next.next = l2;
        } else {
            next.next = l1;
        }
        return head.next;
    }

}
