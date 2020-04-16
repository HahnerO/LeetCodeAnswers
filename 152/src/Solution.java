class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];

        int ans = nums[0];
        int max = nums[0];
        int min = nums[0];

        for (int i = 1; i < len; i++){
            int temp = max;
            max = Math.max(Math.max(max * nums[i], nums[i]), min * nums[i]);
            min = Math.min(Math.min(temp * nums[i], nums[i]), min * nums[i]);
            ans = Math.max(ans, max);
        }
        return ans;
    }
}

