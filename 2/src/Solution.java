import javax.swing.*;
import java.util.List;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        public ListNode(int v){
            this.val = v;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode curNode = head;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        int add = 0;
        int sum = 0;
        while (cur1 != null || cur2 != null) {
            if(cur1 == null) {
                sum = cur2.val + add;
                add = sum / 10;
                curNode.next = new ListNode(sum % 10);
                curNode = curNode.next;
                cur2 = cur2.next;
            }
            else if(cur2 == null) {
                sum = cur1.val + add;
                add = sum / 10;
                curNode.next = new ListNode(sum % 10);
                curNode = curNode.next;
                cur1 = cur1.next;
            }
            else {
                sum = cur1.val + cur2.val + add;
                add = sum / 10;
                curNode.next = new ListNode(sum % 10);
                curNode = curNode.next;
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
        }
        if (add == 1){
            curNode.next = new ListNode(1);
        }
        return head.next;
    }
}
