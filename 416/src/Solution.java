class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int n : nums) {
            sum += n;
        }
        if ((sum % 2) == 1) return false;
        int target = sum/2;

        boolean[] dpFind = new boolean[target + 1];
        dpFind[0] = true;

        for (int num : nums) {
            for (int j = target; num <= j; j--) {
                if (dpFind[target]) {
                    return true;
                }
                dpFind[j] = dpFind[j] || dpFind[j - num];
            }
        }

        return dpFind[target];
    }
}