public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ret = new int[2];
        int left = 0, right = 1;
        int curSum = 0;
        while (left < right && right < numbers.length){
            curSum = numbers[left] + numbers[right];
            if (curSum == target) {
                ret[0] = left + 1;
                ret[1] = right + 1;
                return ret;
            }
            else if (curSum > target) left--;
            else {
                left++;
                right++;
            }
        }
        return ret;
    }
}
