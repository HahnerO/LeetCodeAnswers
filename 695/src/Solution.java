public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length <= 0) return 0;
        int max = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) continue;
                max = Math.max(max, areaCount(grid, i, j));
            }
        }
        return max;
    }

    public int areaCount(int[][] grid , int i, int j){
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return 0;
        if (grid[i][j] == 0) return 0;
        grid[i][j] = 0;
        return 1 + areaCount(grid, i - 1, j) + areaCount(grid, i + 1, j)
                + areaCount(grid, i, j - 1) + areaCount(grid, i, j + 1);
    }
}
