public class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0] >= target ? 0 : 1;

        int left = 0;
        int right = len - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid - 1;
            else  return mid;
        }
        return left;
    }
}
