public class Solution {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return k == nums[0] ? 1 : 0;

        int[] sum = new int[len + 1];
        sum[0] = 0;
        for (int n = 1; n <= len; n++) {
            sum[n] = sum[n - 1] + nums[n - 1];
        }
        int ans = 0;

        for (int i = 0; i <= len; i++){
            for (int j = i + 1; j <= len; j++){
                if (sum[j] - sum[i] == k) ans++;
            }
        }
        return ans;
    }
}
