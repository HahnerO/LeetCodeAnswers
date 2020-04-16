import java.util.HashMap;

public class Solution {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        if (len <= 2) return nums[0];

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums){
            if (map.containsKey(n)){
                if (map.get(n) + 1 > len / 2) return n;
                map.put(n, map.get(n) + 1);
            }else {
                map.put(n, 1);
            }
        }
        return -1;
    }
}
