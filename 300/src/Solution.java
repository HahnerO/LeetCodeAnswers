public class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len <= 1) return len;

        int[] dp = new int[len];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < len; i++){
            int cur = 1;
            for (int j = i - 1; j >= 0; j--){
                if (nums[i] > nums[j]){
                    cur = Math.max(dp[j] + 1, cur);
                }
            }
            dp[i] = cur;
            max = Math.max(dp[i], max);
        }

        return max;
    }
}
