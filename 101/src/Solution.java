import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) {
            this.val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode cur1 = queue.poll();
            TreeNode cur2 = queue.poll();
            if (cur1 == null && cur2 == null) continue;
            if (cur1 == null || cur2 ==null) return false;
            if (cur1.val != cur2.val) return false;
            queue.offer(cur1.right);
            queue.offer(cur2.left);
            queue.offer(cur1.left);
            queue.offer(cur2.right);
        }
        return true;
    }
}
