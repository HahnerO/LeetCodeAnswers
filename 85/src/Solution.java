public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) return 0;
        int col = matrix[0].length;
        int area = 0;

        int[][] height = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j< col; j++){
                if (i == 0){
                    if (matrix[i][j] == '0') height[i][j] = 0;
                    else height[i][j] = 1;
                }else {
                    if (matrix[i][j] == '1'){
                        height[i][j] = height[i - 1][j] + 1;
                    }
                    else {
                        height[i][j] = 0;
                    }
                }
            }
        }

        for (int k = 0; k < row; k++){
            area = Math.max(area, getMaxArea(height[k], col));
        }
        return area;
    }

    public int getMaxArea(int[] line, int len){
        int ans  = 0;
        for (int i = 0; i < len; i++){
            int left = i, right = i;
            while (true){
                if (left - 1 >= 0 && line[left - 1] >= line[i]) left--;
                else if (right + 1 < len && line[right + 1] >= line[i]) right++;
                else break;
            }
            ans = Math.max(ans, (right - left + 1) * line[i]);
        }
        return ans;
    }
}
