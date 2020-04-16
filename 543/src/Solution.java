public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static class retVal{
        int maxInSub;
        int maxWithRoot;
        public retVal(int sub, int root) {
            this.maxInSub = sub;
            this.maxWithRoot = root;
        }
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        retVal res = maxPath(root);
        return Math.max(res.maxWithRoot, res.maxInSub) - 1;
    }

    public retVal maxPath(TreeNode root) {
        if (root == null) return new retVal(0, 0);
        if (root.left == null && root.right ==null) return new retVal(1, 1);
        retVal leftR = maxPath(root.left);
        retVal rightR = maxPath(root.right);
        int sub = Math.max(Math.max(leftR.maxWithRoot + rightR.maxWithRoot + 1, leftR.maxInSub), rightR.maxInSub);
        int withRoot = Math.max(leftR.maxWithRoot, rightR.maxWithRoot) + 1;
        return new retVal(sub, withRoot);
    }
}
