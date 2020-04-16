import java.util.ArrayList;
import java.util.List;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        while (root != null){
            if (root.left == null) {
                ans.add(root.val);
                root = root.right;
            }else {
                TreeNode pre = root.left;
                while (pre.right != null && pre.right != root) pre = pre.right;
                if (pre.right == null){
                    ans.add(root.val);
                    pre.right = root;
                    root = root.left;
                }else {
                    pre.right = null;
                    root = root.right;
                }
            }
        }
        return ans;
    }
}
