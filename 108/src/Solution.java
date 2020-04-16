public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return getTree(nums, 0, nums.length - 1);
    }

    public TreeNode getTree(int[] nums, int left, int right){
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = getTree(nums, left, mid - 1);
        root.right = getTree(nums, mid + 1, right);
        return root;
    }
}
