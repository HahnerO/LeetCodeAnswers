public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //记录是否找到不成立的节点
    boolean findFalse = false;

    public boolean isValidBST(TreeNode root) {
        //特判，若空返回false
        if (root == null) return false;
        //开始递归
        getValid(root);
        //返回是否找到了错误节点
        return !findFalse;
    }

    //注意这里自定义返回值是一个存储两个元素的数组，前一个表示本树最小值，后一个表示本树最大值
    public int[] getValid(TreeNode root){
        //如果已经找到了错误节点，直接返回，可以跳过一些操作
        if (findFalse) return new int[2];

        int[] res = new int[2];
        //特判，叶子节点的最大最小值都是本身
        if (root.left == null && root.right == null) {
            res[0] = root.val;
            res[1] = root.val;
            return res;
        }

        //左子树为空的情况
        if (root.left == null){
            int[] rightRes = getValid(root.right);
            //如果自身值大于等于右子树最小值，设置标志为true并直接返回
            if (root.val >= rightRes[0]) {
                findFalse = true;
                return res;
            }
            //否则，设置返回值，本树最小为自身值，最大为子树最大值
            res[0] = root.val;
            res[1] = rightRes[1];
        }
        //右子树为空的情况
        else if (root.right == null){
            int[] leftRes = getValid(root.left);
            //如果自身值小与等于左子树最大值，设置标志为true并直接返回
            if (root.val <= leftRes[1]){
                findFalse = true;
                return res;
            }
            //否则，设置返回值，本树最小为左子树最小，最大为自身值
            res[0] = leftRes[0];
            res[1] = root.val;
        }
        //左右子树都不为空的情况
        else {
            int[] leftRes = getValid(root.left);
            int[] rightRes = getValid(root.right);
            //如果自身值小雨等于左子树最大值或者大于等于右子树最小值，设置标志并返回
            if (root.val <= leftRes[1] || root.val >= rightRes[0]) findFalse = true;
            //否则，设置返回值，本树最小为左子树最小，最大为右子树最大
            res[0] = leftRes[0];
            res[1] = rightRes[1];
        }
        return res;
    }
}
