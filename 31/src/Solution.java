public class Solution {
    public void nextPermutation(int[] nums) {
        int j = nums.length - 2;
        while (j >= 0) {
            if (nums[j] < nums[j + 1]) break;
            j--;
        }
        if (j == -1) {
            reverse(nums, 0);
            return;
        }
        int changePoint = j + 1;
        while (changePoint < nums.length){
            if (nums[changePoint] > nums[j]) changePoint++;
            else break;
        }
        swap(nums, j, --changePoint);
        reverse(nums, j+1);
    }

    public void reverse(int[] nums, int start){
        int end = nums.length - 1;
        while (start <= end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
