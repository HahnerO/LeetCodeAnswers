import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0 || wordDict.size() == 0)  return false;

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
            if (dp[s.length()]) return true;
        }
        return false;
    }
}
