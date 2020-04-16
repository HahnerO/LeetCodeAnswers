public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
            if (fast.next == null) break;
            fast = fast.next;
        }

        ListNode re = reverse(slow);
        while (re!=null && head != null) {
            if (re.val != head.val) return false;
            re = re.next;
            head = head.next;
        }
        return true;
    }

    public ListNode reverse(ListNode head){
        ListNode pre = null;
        while (head != null){
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}
