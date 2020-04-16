import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] rtv = new int[2];
        for(int i = 0; i <= nums.length - 1; i++) {
            if(map.containsKey(target - nums[i])){
                int j = map.get(target - nums[i]);
                if (i < j){
                    rtv[0] = i;
                    rtv[1] = j;
                }
                else {
                    rtv[1] = i;
                    rtv[0] = j;
                }
                return rtv;
            }
            map.put(nums[i], i);
        }
        return rtv;
    }
}