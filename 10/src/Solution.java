public class Solution {
    public boolean isMatch(String s, String p) {
        if (p == null) return false;
        if (p.equals(".*")) return true;
        int lenS = s.length(), lenP = p.length();
        boolean[][] dp = new boolean[lenS + 1][lenP + 1];
        dp[0][0] = true;
        for (int i = 2; i <= lenP; i += 2) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
        }
        for (int i = 1; i <= lenS; i++) {
            for (int j = 1; j <= lenP; j++){
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j -1) == '.'){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if (p.charAt(j - 1) == '*'){
                    if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) =='.'){
                        dp[i][j] = dp[i][j - 2] || dp[i][j - 1] || dp[i - 1][j];
                    }
                    else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[lenS][lenP];
    }
}
