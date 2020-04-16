public class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            while (!dp[i]){
                if (j < 0) break;
                if (dp[j] && j + nums[j] >= i){
                    dp[i] = true;
                }
                j--;
            }
        }

        return dp[nums.length - 1];
    }
}
