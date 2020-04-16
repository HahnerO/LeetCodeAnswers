public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        int len = nums.length;
        if (len == 0) return ans;

        int left = 0;
        int right = len - 1;
        int mid = (left + right) >> 1;
        while (left <= right){
            mid = (left + right) >> 1;
            if (nums[mid] == target) break;
            if (nums[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        if (left > right) return ans;
        left = mid;
        right = mid;
        while (left - 1 >= 0 && nums[left -1] == nums[mid]) left--;
        while (right + 1 < nums.length && nums[right + 1] == nums[mid]) right++;
        ans[0] = left;
        ans[1] = right;
        return ans;
    }
}
