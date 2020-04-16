import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution {
    public static class Node{
        int value;
        Node left;
        Node right;
        public Node(int val){
            this.value = val;
        }
    }

    public void Solution(Node root){
        Node cur = root;
        Node mostRight = null;

        String s = "ssssadsd";
        HashMap h = new HashMap();
        Deque deque = new LinkedList();
        

        while (cur != null){
            if (cur.left == null){
                System.out.println(cur.value);
                cur = cur.right;
            }
            else {
                mostRight = cur.left;
                while (mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                }
                if (mostRight.right == cur) {
                    mostRight.right = null;
                    System.out.println(cur.value);
                    cur = cur.right;
                }
            }
        }
    }
}
