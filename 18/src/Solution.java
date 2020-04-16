import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int length = nums.length;
        if (length < 4) return ans;

        Arrays.sort(nums);
        for (int p = 0; p < length - 3; p++){
            if (p > 0 && nums[p] == nums[p - 1]) continue;
            if (nums[p] + nums[p + 1] + nums[p + 2] + nums[p + 3] > target) break;
            if (nums[p] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) continue;

            for (int q = p + 1; q < length - 2; q++) {
                if (q > p + 1 && nums[q - 1] == nums[q]) continue;
                if (nums[p] + nums[q] + nums[length - 2] + nums[length - 1] < target) continue;
                if (nums[p] + nums[q] + nums[q + 1] + nums[q + 2] > target) continue;

                int res = target - nums[p] - nums[q];
                int i = q + 1, j = length - 1;
                while (i < j) {
                    int cur = nums[i] + nums[j];
                    if (cur == res) {
                        ans.add(Arrays.asList(nums[p], nums[q], nums[i], nums[j]));
                        i++;
                        while (i < j && nums[i] == nums[i - 1]) i++;
                        j--;
                        while (i < j && nums[j] == nums[j + 1]) j--;
                    }
                    else if (cur < res) i++;
                    else j--;
                }
            }
        }
        return ans;
    }
}
