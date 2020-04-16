import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (len == 0) return ans;
        dfs(nums, 0, ans, new ArrayList<>());
        return ans;
    }

    public void dfs(int[] nums, int idx, List<List<Integer>> res, ArrayList<Integer> segment){
        res.add(new ArrayList<>(segment));
        for (int j = idx; j < nums.length; j++) {
            segment.add(nums[j]);
            dfs(nums, j + 1, res, segment);
            segment.remove(segment.size() - 1);
        }
    }
}
