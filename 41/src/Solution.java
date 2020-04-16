class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) return 1;
        if (nums.length == 1) return nums[0] == 1 ? 2 : 1;

        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]){
                swap(nums, i, nums[i] - 1);
            }
        }

        for (int j = 0; j < nums.length; j++){
            if (nums[j] != j + 1)return j + 1;
        }
        return nums.length + 1;
    }

    public void swap(int[] arr, int i, int j){
        arr[i] = arr[i] + arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }
}