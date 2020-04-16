public class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0) return 0;
        if (len == 1) return s.equals("0") ? 0 : 1;

        if (s.charAt(0) == '0') return 0;
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i - 1) == '0'){
                if (s.charAt(i) == '0') return 0;
                else dp[i] = dp[i - 1];
            }else {
                if (s.charAt(i) == '0') {
                    if (s.charAt(i - 1) > '2') return 0;
                    else dp[i] = (i - 2) >= 0 ? dp[i - 2] : 1;
                }
                else {
                    if (Integer.parseInt(s.substring(i - 1, i + 1)) > 26) dp[i] = dp[i - 1];
                    else dp[i] = dp[i - 1] + ((i - 2) > 0 ? dp[i - 2] : 1);
                }
            }
        }
        return dp[len - 1];
    }
}
