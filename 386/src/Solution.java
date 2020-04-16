import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        if (n == 0) return ans;
        for (int i = 1; i < 10; i++){
            if (i <= n){
                ans.add(i);
                dfs(ans, i, n);
            }else {
                break;
            }
        }

        return ans;
    }

    public void dfs(List<Integer> list, int start, int n){
        start *= 10;
        for (int i = 0; i < 10; i++, start++){
            if (start <= n){
                list.add(start);
                dfs(list, start, n);
            }
            else return;
        }
    }
}
