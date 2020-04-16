import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (len < 3) return ans;
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            //最左大于0，和一定大于0
            if (nums[i] > 0) break;
            //如果当前i处值和i-1处相同则跳过
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            //普遍情况的处理
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                //和为0，找到了
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else R--;
            }
        }
        return ans;
    }
}
