public class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0] == val ? 0 : 1;

        int i = 0, j = 0;
        while (j < len){
            if (nums[i] != val) {
                i++;
                if (j < i) j = i;
            }
            else if (nums[i] == val) {
                while (j < len && nums[j] == val) j++;
                if (j == len) return i;
                swap(nums, i, j);
                i++;
            }
        }

        return i;
    }

    public void swap(int[] nums, int i, int j){
        nums[i] = nums[i] + nums[j];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }
}
