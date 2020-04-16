public class Solution {
    public int jump(int[] nums) {
        int old = 0, late = 0, step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            late = Math.max(late, nums[i] + i);
            if (old == i) {
                old = late;
                step++;
            }
        }
        return step;
    }
}
