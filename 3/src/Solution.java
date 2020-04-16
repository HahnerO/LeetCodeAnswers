import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        int maxUniq = 1;
        int curUniq = 1;
        char[] sArray = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        set.add(sArray[0]);
        int left = 0;
        int right = 1;
        while (left < right && right < sArray.length) {
            if (set.contains(sArray[right])) {
                while (sArray[left] != sArray[right]){
                    set.remove(sArray[left]);
                    left++;
                    curUniq--;
                }
                if (left != right) {
                    left++;
                }
                right++;
            }
            else {
                set.add(sArray[right]);
                right++;
                curUniq++;
            }
            maxUniq = Math.max(maxUniq, curUniq);
        }
        return maxUniq;
    }
}
