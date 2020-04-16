public class Solution {
    public int maxProfit(int[] prices) {
        //dp 当前持有/不持有问题
        if (prices.length <=1){
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i ++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i -1][1], - prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}