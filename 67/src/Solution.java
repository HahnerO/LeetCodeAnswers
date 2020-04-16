import java.util.Stack;

public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int up = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = up;
            sum += (i >= 0 ? a.charAt(i) - '0' : 0);
            sum += (j >= 0 ? b.charAt(j) - '0' : 0);
            sb.insert(0, sum % 2);
            up = sum / 2;
        }
        if (up == 1) sb.insert(0, 1);
        return sb.toString();
    }
}
