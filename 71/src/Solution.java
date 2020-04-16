import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        String[] pool = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : pool){
            if (s.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!s.equals(".") && !s.equals("..") && !s.equals("")) stack.push(s);
        }

        if (stack.isEmpty()) return "/";

        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()){
            res.insert(0, "/" + stack.pop());
        }
        return res.toString();
    }
}
