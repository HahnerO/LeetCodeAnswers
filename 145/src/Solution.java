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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        TreeNode head = root;

        while (root != null){
            if (root.left == null){
                root = root.right;
            }else {
                TreeNode pre = root.left;
                while (pre.right != null && pre.right != root) pre = pre.right;
                if (pre.right == null){
                    pre.right = root;
                    root = root.left;
                }else {
                    pre.right = null;
                    addEdge(root.left, ans);
                    root = root.right;
                }
            }
        }

        addEdge(head, ans);

        return ans;
    }

    public void addEdge(TreeNode root, List<Integer> ans){
        TreeNode pre = null;
        while (root != null){
            TreeNode next = root.right;
            root.right = pre;
            pre = root;
            root = next;
        }
        while (pre != null){
            ans.add(pre.val);
            pre = pre.right;
        }
    }
}
