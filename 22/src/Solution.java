import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) return ans;
        dfs(ans, "", n, n);
        return ans;
    }

    public void dfs(List<String> ans, String curStr, int resLeft, int resRight){
        if (resLeft > resRight) return;
        if (resLeft == 0 && resRight == 0){
            ans.add(curStr);
            return;
        }
        if (resLeft > 0) dfs(ans, curStr + "(", resLeft - 1, resRight);
        if (resRight > 0) dfs(ans, curStr + ")", resLeft, resRight - 1);
    }
}
