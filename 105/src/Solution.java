import java.util.Arrays;

public class Solution {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < inorder.length; i++){
            if (inorder[i] == preorder[0]){
                int[] preLeft = Arrays.copyOfRange(preorder, 1, i+ 1);
                int[] preRight = Arrays.copyOfRange(preorder, i + 1, preorder.length);
                int[] inLeft = Arrays.copyOfRange(inorder, 0, i);
                int[] inRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);
                root.left = buildTree(preLeft, inLeft);
                root.right = buildTree(preRight, inRight);
                break;
            }
        }
        return root;
    }
}
