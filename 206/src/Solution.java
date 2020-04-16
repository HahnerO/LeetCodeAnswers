import java.util.List;

public class Solution {
    public static void main(String[] args) {
        ListNode test = new ListNode(2);
        test.next = new ListNode(3);
        Solution solution = new Solution();
        test = solution.reverseList(test);
        while (test != null){
            System.out.println(test.val);
            test = test.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode cur = head.next;
        ListNode pre = head;
        ListNode temp;
        while (true){
            if (pre == head){
                pre.next = null;
            }
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            if (temp == null) break;
            cur = temp;
        }
        return cur;
    }
}
