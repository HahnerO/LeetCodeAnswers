public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode firstEnd = dummy;
        ListNode midEnd = dummy;
        for (int i = 0; i < n; i++){
            if (i < m - 1){
                firstEnd = firstEnd.next;
            }
            midEnd = midEnd.next;
        }
        ListNode midStart = firstEnd.next;
        ListNode lastStart = midEnd.next;
        firstEnd.next = null;
        midEnd.next = null;
        ListNode[] mid = reverse(midStart);
        firstEnd.next = mid[0];
        mid[1].next = lastStart;
        return dummy.next;
    }

    public ListNode[] reverse(ListNode l){
        ListNode[] res = new ListNode[2];
        res[1] = l;
        ListNode pre = null;
        while (l != null){
            ListNode temp = l.next;
            l.next = pre;
            pre = l;
            l = temp;
        }
        res[0] = pre;
        return res;
    }
}
