import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "#/";
        String str = root.val + "/";
        str += serialize(root.left);
        str += serialize(root.right);
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split("/");
        Queue<String> queue = new LinkedList<>();
        for (String s : strings) queue.offer(s);
        return deTree(queue);
    }

    public TreeNode deTree(Queue<String> queue){
        if (queue.isEmpty()) return null;
        String root = queue.poll();
        if (root.equals("#")) return null;
        TreeNode rootTree = new TreeNode(Integer.parseInt(root));
        rootTree.left = deTree(queue);
        rootTree.right = deTree(queue);
        return rootTree;
    }
}
