import java.util.*;

public class Solution {
    List<List<Integer>> output = new ArrayList<>();
    List<Integer> segment = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target);
        return output;
    }

    public void dfs(int[] candidates, int target){
        if (target < 0) return;
        if (target == 0) {
            Collections.sort(segment);
            if (!output.contains(segment)) output.add(new ArrayList<>(segment));
            return;
        }

        for (int c : candidates){
            segment.add(c);
            dfs(candidates, target - c);
            segment.remove(segment.lastIndexOf(c));
        }
    }
}
