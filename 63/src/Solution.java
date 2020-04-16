public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        if (row == 0) return 0;
        if (obstacleGrid[0][0] == 1) return 0;
        if (row == 1) {
            for (int c : obstacleGrid[0]){
                if (c == 1) return 0;
            }
            return 1;
        }
        int col = obstacleGrid[0].length;
        if (col == 1) {
            for (int[] ints : obstacleGrid) {
                if (ints[0] == 1) return 0;
            }
            return 1;
        }

        int[][] dp = new int[row][col];
        dp[0][0] = 1;
        for (int m = 1; m < row; m++) dp[m][0] = (dp[m - 1][0] != 0 && obstacleGrid[m][0] != 1) ? 1 : 0;
        for (int n = 1; n < col; n++) dp[0][n] = (dp[0][n - 1] != 0 && obstacleGrid[0][n] != 1) ? 1 : 0;
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++){
                if (obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[row - 1][col - 1];
    }
}
