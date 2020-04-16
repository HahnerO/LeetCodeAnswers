public class Solution {
    public int maxArea(int[] height) {
        if (height.length == 2) {
            return Math.min(height[0], height[1]);
        }
        int i = 0, j = height.length - 1;
        int res = 0, area = 0;
        while (i < j){
            if (height[i] < height[j]) {
                area = height[i] * (j - i);
                i++;
            }
            else {
                area = height[j] * (j - i);
                j--;
            }

            res = Math.max(res, area);
        }
        return res;
    }
}
