import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return ans;
        ans = goCircle(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1);
        return ans;

    }

    public List<Integer> goCircle(int[][] matrix, int startRow, int endRow, int startCol, int endCol){
        List<Integer> circle = new ArrayList<>();
        if (startRow > endRow || startCol > endCol) return circle;
        if (startRow == endRow) {
            for (int i = startCol; i <= endCol; i++){
                circle.add(matrix[startRow][i]);
            }
            return circle;
        }
        if (startCol == endCol) {
            for (int i = startRow; i <= endRow; i++){
                circle.add(matrix[i][endCol]);
            }
            return circle;
        }
        for (int i = startCol; i <= endCol - 1; i++){
            circle.add(matrix[startRow][i]);
        }
        for (int i = startRow; i <= endRow - 1; i++) {
            circle.add(matrix[i][endCol]);
        }
        for (int i  = endCol; i >= startCol + 1; i--){
            circle.add(matrix[endRow][i]);
        }
        for (int i = endRow; i >= startRow + 1; i--){
            circle.add(matrix[i][startCol]);
        }

        circle.addAll(goCircle(matrix, startRow + 1, endRow - 1, startCol + 1, endCol - 1));
        return circle;
    }

}
