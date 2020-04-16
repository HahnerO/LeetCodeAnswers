import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> inOut = new HashMap<>();
        inOut.put(')', '(');
        inOut.put('}', '{');
        inOut.put(']', '[');
        char[] sA = s.toCharArray();
        int cnt = 0;
        for (char c : sA) {
            if (inOut.containsKey(c)){
                if (stack.isEmpty()) return false;
                if (inOut.get(c) != stack.pop()) return false;
            } else {
                stack.push(c);
                if (++cnt > sA.length / 2) return false;
            }
        }
        return stack.isEmpty();
    }
}
