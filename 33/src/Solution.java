public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return target == nums[0] ? 0 : -1;
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = (left + right) >> 1;
            if (nums[mid] == target) return mid;
            if (
                    (nums[left] < nums[mid] && nums[left] <= target && target < nums[mid]) ||
                            (nums[left] > nums[mid] && (target < nums[mid] || target >= nums[left]))
            ) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }
        return -1;
    }
}
