public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0] >= s ? 1 : 0;

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int curSum = 0;
        for (int i = 0; i < len; i++) {
            curSum += nums[i];
            while (curSum >= s){
                minLen = Math.min(minLen, i - left + 1);
                curSum -= nums[left++];
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
