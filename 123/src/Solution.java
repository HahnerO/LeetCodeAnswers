public class Solution {
    public int maxProfit(int[] prices) {
        int days = prices.length;
        if (days <= 1) return 0;

        int[][][] dp = new int[days][3][2];

        for (int i = 0; i < days; i++){
            for (int j = 2; j >= 0; j--) {
                if (i == 0){
                    dp[0][j][0] = 0;
                    dp[0][j][1] = - prices[0];
                }else {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                }
            }
        }
        return dp[days - 1][2][0];
    }
}
