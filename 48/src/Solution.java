public class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        if (len == 0) return;

        rotateEdge(matrix, 0, len);
    }

    public void rotateEdge(int[][] matrix, int start, int len){
        if (len <= 1) return;
        for (int i = 0; i < len - 1; i++) rotatePoint(matrix, start, i, len);
        rotateEdge(matrix, start + 1, len - 2);
    }

    public void rotatePoint(int[][] matrix, int start, int offset, int len){
        int upRow = start;
        int upCol = start + offset;
        int leftRow = start + len - 1 - offset;
        int leftCol = start;
        int rightRow = upCol;
        int rightCol = start + len - 1;
        int downRow = rightCol;
        int downCol = leftRow;

        swap(matrix, upRow, upCol, rightRow, rightCol);
        swap(matrix, leftRow, leftCol, downRow, downCol);
        swap(matrix, upRow, upCol, downRow, downCol);
    }

    public void swap(int[][] matrix, int i, int j, int m, int n){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[m][n];
        matrix[m][n] = temp;
    }
}
