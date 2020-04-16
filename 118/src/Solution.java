import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 0) return ans;

        //类dp
        int[][] triangle = new int[numRows][2 * numRows + 1];
        triangle[0][numRows] = 1;
        List<Integer> first = new ArrayList<>();
        first.add(1);
        ans.add(first);
        for (int i = 1; i < numRows; i++) {
            List<Integer> line = new ArrayList<>();
            for (int j = 1; j < 2 * numRows; j++){
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j + 1];
                if (triangle[i][j] != 0) line.add(triangle[i][j]);
            }
            ans.add(line);
        }
        return ans;
    }
}
