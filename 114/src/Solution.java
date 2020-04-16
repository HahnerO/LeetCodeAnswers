public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void flatten(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return;

        TreeNode cur = root;
        while (cur != null){
            if (cur.left != null) {
                TreeNode mostRight = cur.left;
                while (mostRight.right != null && mostRight.right != cur) mostRight = mostRight.right;
                mostRight.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
}
