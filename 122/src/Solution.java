public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp = prices[i] - prices[i - 1];
            if (temp > 0) ans += temp;
        }
        return ans;
    }
}
