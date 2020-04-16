public class Solution {
    public int trap(int[] height) {
        int total = 0;
        int len = height.length;
        int[] left = new int[len];
        int leftMax = 0, rightMax = 0;
        for (int i = 0; i < len; i++) {
            leftMax = Math.max(height[i], leftMax);
            left[i] = leftMax;
        }
        for (int j = len - 1; j >= 0; j--){
            rightMax = Math.max(height[j], rightMax);
            //同时计算
            total += Math.min(left[j], rightMax) - height[j];
        }
        return total;
    }
}
