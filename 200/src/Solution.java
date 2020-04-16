public class Solution {
    int row;
    int col;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int cnt = 0;
        this.row = grid.length;
        this.col = grid[0].length;

        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j ++){
                if (grid[i][j] == '1'){
                    cnt++;
                    spread(grid, i, j);
                }
            }
        }
        return cnt;
    }

    public void spread(char[][] grid, int i, int j){
        if (i < 0 || i >= row || j < 0 || j >= col) return;
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            spread(grid, i - 1, j);
            spread(grid, i + 1, j);
            spread(grid, i, j + 1);
            spread(grid, i, j - 1);
        }
    }
}
