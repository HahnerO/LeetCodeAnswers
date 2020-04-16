public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        ListNode mid;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
            if (fast.next == null) break;
            fast = fast.next;
        }
        mid = slow;
        slow = slow.next;
        mid.next = null;
        merge(head, reverse(slow));
    }

    public ListNode reverse(ListNode head){
        if (head == null) return null;
        ListNode pre = null;
        while (head!= null){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

    public ListNode merge(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (l1 != null && l2 != null){
            cur.next = l1;
            l1 = l1.next;
            cur = cur.next;
            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
        }
        if (l1 == null) cur.next = l2;
        else cur.next = l1;
        return head.next;
    }
}
