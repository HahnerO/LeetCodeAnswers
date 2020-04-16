import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    int res = 0;
    char[][] segment;
    int len;

    public int totalNQueens(int n) {
        if (n == 1) return 1;
        if (n < 4) return 0;

        len = n;
        initSeg();

        dfs(0);

        return res;
    }

    public void dfs(int start){
        if (start == len) {
            res++;
            return;
        }

        for (int i = 0; i < len; i++) {
            segment[start][i] = 'Q';
            if (isValidWith(start, i)){
                dfs(start + 1);
            }
            segment[start][i] = '.';
        }
    }


    public boolean isValidWith(int i, int j){
        //col
        for (int m = 0; m < i; m++){
            if (segment[m][j] == 'Q') return false;
        }
        //right-up
        for (int k = i - 1, l = j + 1; k >= 0 && l < len; k--, l++){
            if (segment[k][l] == 'Q') return false;
        }
        //left-up
        for (int p = i - 1, q = j - 1; p >= 0 && q >= 0; p --, q--){
            if (segment[p][q] == 'Q') return false;
        }
        return true;
    }

    public void initSeg(){
        segment = new char[len][len];
        char[] line = new char[len];
        Arrays.fill(line, '.');
        for (int i = 0; i < len; i++){
            segment[i] = line.clone();
        }
    }
}
