public class Solution {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next.next;
        ListNode pre = head;
        head = head.next;
        head.next = pre;
        pre.next = swapPairs(next);
        return head;
    }
}
