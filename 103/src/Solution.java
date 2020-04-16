import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            this.val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Stack<TreeNode> stackReverse = new Stack<>();
        Stack<TreeNode> stackNormal = new Stack<>();

        stackReverse.push(root);
        while (!stackReverse.isEmpty() || !stackNormal.isEmpty()){
            List<Integer> segment = new ArrayList<>();
            if (!stackReverse.isEmpty()){
                while (!stackReverse.isEmpty()){
                    TreeNode cur = stackReverse.pop();
                    segment.add(cur.val);
                    if (cur.left != null) stackNormal.push(cur.left);
                    if (cur.right != null) stackNormal.push(cur.right);
                }
            }else {
                while (!stackNormal.isEmpty()){
                    TreeNode cur = stackNormal.pop();
                    segment.add(cur.val);
                    if (cur.right != null) stackReverse.push(cur.right);
                    if (cur.left != null) stackReverse.push(cur.left);
                }
            }
            ans.add(segment);
        }
        return ans;
    }
}
