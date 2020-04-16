public class Solution {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ this.val = x; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode cur = head;
        int len = 1;
        while (cur.next != null){
            cur = cur.next;
            len++;
        }
        cur.next = head;

        int offset = k % len;
        ListNode newHead = head;
        for (int i = 0; i <  len - offset; i++){
            cur = newHead;
            newHead = newHead.next;
        }
        cur.next = null;
        return newHead;
    }
}
