import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    List<List<Integer>> output = new ArrayList<>();
    List<Integer> segment = new ArrayList<>();
    int[] nums;
    boolean[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {
        int len = nums.length;
        if (len == 0) return output;

        this.nums = nums;
        visited = new boolean[len];
        dfs(len);
        return output;
    }

    public void dfs(int resLen){
        if (resLen == 0) {
            output.add(new ArrayList<>(segment));
            return;
        }

        HashSet<Integer> uniq = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            if (!uniq.contains(nums[i]) && !visited[i]){
                uniq.add(nums[i]);
                visited[i] = true;
                segment.add(nums[i]);
                dfs(resLen - 1);
                segment.remove(segment.size() - 1);
                visited[i] = false;
            }
        }
    }
}
