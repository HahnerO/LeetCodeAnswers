import java.util.Stack;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isValidBST(TreeNode root){
        //特判
        if (root == null || (root.left == null && root.right == null)) return true;

        //记录上一个值
        int pre = Integer.MIN_VALUE;
        //用以跳过第一次比较
        boolean isFirst = true;

        TreeNode cur = root;
        while (cur != null){
            if (cur.left == null){
                //第一个节点，也就是中序下第一个值，不比较，因为第一个值没有前驱
                if (isFirst) {
                    isFirst = false;
                }
                else if (cur.val <= pre) return false; //以后比较如果发现逆序，直接退出
                //更新前驱值
                pre = cur.val;
                cur = cur.right;
            }else {
                //找mostRight，也就是当前节点的前驱节点
                TreeNode mostRight = cur.left;
                while (mostRight.right != null && mostRight.right != cur) mostRight = mostRight.right;
                //如果是第二次回来，就比较前驱值
                if (mostRight.right == cur){
                    if (cur.val <= pre) return false;//比较发现逆序，直接退出
                    pre = cur.val;
                    cur = cur.right;
                    mostRight.right = null;
                }
                //如果是第一次来，就设置返回指针
                else {
                    mostRight.right = cur;
                    cur = cur.left;
                }
            }

        }
        return true;
    }
}
