public class Solution{
    public int[] Solution(String s1, String s2, int n){
        int[] ab1 = new int[26];
        int[] ab2 = new int[26];
        //第一个字符串对于的字符计数数组
        for (char c : s1.toCharArray()){
            ab1[c - 'a']++;
        }
        //第二个字符串对应的字符计数数组
        for (char c: s2.toCharArray()){
            ab2[c - 'a']++;
        }

        //开始dp
        int[][] dp = new int[n][26];
        //base case
        dp[0] = ab1;
        dp[1] = ab2;
        //状态转移 dp[i] = dp[i - 1] + dp[i - 2]
        for (int i = 2; i < n; i++){
            for (int j = 0; j < 26; j++){
                dp[i][j] = dp[i - 1][j] + dp[i - 2][j];
            }
        }
        //返回最后的字符计数数组
        return dp[n - 1];
    }
}