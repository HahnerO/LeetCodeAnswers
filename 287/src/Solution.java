public class Solution {
    public int findDuplicate(int[] nums) {
        if (nums.length <= 2) return nums[0];

        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        fast = nums[0];
        while (fast != slow){
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }
}
