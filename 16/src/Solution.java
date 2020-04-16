import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length <= 2) return -1;

        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++){
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum - target == 0) return sum;
                else if (sum - target < 0) {
                    res = Math.abs(res - target) < Math.abs(sum - target) ? res : sum;
                    left++;
                }
                else if (sum - target > 0) {
                    res = Math.abs(res - target) < Math.abs(sum - target) ? res : sum;
                    right--;
                }
            }
        }
        return res;
    }
}
