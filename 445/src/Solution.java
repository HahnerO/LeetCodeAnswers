import java.util.Stack;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;

        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        Stack<ListNode> res = new Stack<>();

        int up = 0;
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int temp = stack1.pop().val + stack2.pop().val + up;
            res.push(new ListNode(temp % 10));
            up = temp / 10;
        }
        if (stack1.isEmpty()) {
            while (!stack2.isEmpty()){
                int temp = stack2.pop().val + up;
                res.push(new ListNode(temp % 10));
                up = temp / 10;
            }
        }
        else {
            while (!stack1.isEmpty()){
                int temp = stack1.pop().val + up;
                res.push(new ListNode(temp % 10));
                up = temp / 10;
            }
        }

        if (up == 1) res.push(new ListNode(1));
        ListNode dummy = new ListNode(0);
        dummy.next = res.pop();
        ListNode cur = dummy.next;
        while (!res.isEmpty()){
            cur.next = res.pop();
            cur = cur.next;
        }
        return dummy.next;
    }
}
