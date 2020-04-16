import java.security.PublicKey;
import java.util.List;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        public ListNode(int v){
            this.val = v;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 0) return null;
        ListNode pre = null;
        ListNode tail = head;
        if (k == -1) {
            while (head != null) {
                ListNode temp = head.next;
                head.next = pre;
                pre = head;
                head = temp;
            }
            return pre;
        }
        else {
            int cnt = 0;
            while (head != null && cnt != k){
                ListNode temp = head.next;
                head.next = pre;
                pre = head;
                head = temp;
                cnt++;
            }
            if (cnt == k){
                tail.next = reverseKGroup(head, k);
                return pre;
            }
            else {
                return reverseKGroup(pre, -1);
            }
        }
    }
}
