public class Solution {
    public boolean isMatch(String s, String p) {
        int pLen = p.length(), sLen = s.length();
        if (pLen == 0) return sLen == 0;

        boolean[][] dp = new boolean[sLen + 1][pLen + 1];
        dp[0][0] = true;
        for (int k = 1; k <= pLen; k++) {
            if (p.charAt(k - 1) == '*') dp[0][k] = dp[0][k - 1];
        }

        for (int i = 1; i <= sLen; i++){
            for (int j = 1; j <=pLen; j++) {
                if (s.charAt(i - 1) == p.charAt(j -1) || p.charAt(j - 1) == '?') dp[i][j] = dp[i - 1][j - 1];
                else if (p.charAt(j - 1) == '*') dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
            }
        }
        return dp[sLen][pLen];
    }
}
