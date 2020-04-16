import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> res = new ArrayList<>();
    HashSet<Integer> visited = new HashSet<>();
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        getSets(0);
        return ans;
    }
    public void getSets(int cnt) {
        if (cnt == nums.length){
            ans.add(new ArrayList<>(res));
        }
        for (int n: nums) {
            if (!visited.contains(n)) {
                visited.add(n);
                res.add(n);
                cnt++;
                getSets(cnt);
                res.remove(res.size() - 1);
                visited.remove(n);
                cnt--;
            }
        }
    }
}
