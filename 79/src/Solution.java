public class Solution {
    boolean flag = false;
    public boolean exist(char[][] board, String word) {
        if (word == null || word.equals("")) return true;
        if (board == null) return false;
        int rows = board.length - 1, cols = board[0].length - 1;

        for (int i = 0; i <= rows; i++){
            for (int j = 0; j <= cols; j++){
                if (findNext(board, i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean findNext(char[][] board, int i, int j, String word, int idx){
        if (idx == word.length()) {
            flag = true;
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(idx)) return false;
        if (!flag) {
            char c = board[i][j];
            board[i][j] = '.';
            boolean found = findNext(board, i + 1, j, word, idx + 1) ||
                    findNext(board, i - 1, j, word, idx + 1) ||
                    findNext(board, i, j + 1, word, idx + 1) ||
                    findNext(board, i, j - 1, word, idx + 1);
            board[i][j] = c;
            return found;
        }
        return true;
    }
}
