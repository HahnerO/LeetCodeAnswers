import java.util.HashSet;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i ++){
            for (int j = 0; j < 9; j++){
                if (board[i][j] != '.' && !isValid(board, i, j)) return false;
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int row, int col){
        for (int k = 0; k < 9; k++){
            if (k != col && board[row][k] == board[row][col]) return false;
            if (k != row && board[k][col] == board[row][col]) return false;
        }

        int m = row / 3, n = col / 3;
        HashSet<Character> set = new HashSet<>();
        for (int i = m * 3; i < (m + 1) * 3; i++){
            for (int j = n * 3; j < (n + 1) * 3; j++){
                if (board[i][j] != '.'){
                    if (set.contains(board[i][j])) return false;
                    else set.add(board[i][j]);
                }
            }
        }

        return true;
    }
}
