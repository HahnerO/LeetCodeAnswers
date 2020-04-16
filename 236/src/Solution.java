public class Solution {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }

    TreeNode ans = null;
    boolean findAns = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return ans;
        findCount(root, p, q);
        return ans;
    }

    public int findCount(TreeNode root, TreeNode p, TreeNode q){
        if (root == null) return 0;
        if (findAns) return 0;
        else {
            int mid = (root == p || root == q) ? 1 : 0;
            int left = findCount(root.left, p, q);
            int right = findCount(root.right, p ,q);
            if (mid + left + right >= 2) {
                ans = root;
                findAns = true;
            }
            return (mid + left + right) > 0 ? 1 : 0;
        }
    }
}
