import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public int candy(int[] ratings) {
        int total = 0;
        int len = ratings.length;
        int[] candyFor = new int[len];
        candyFor[0] = 1;
        for (int i = 1; i < len; i++) {
            if (ratings[i - 1] < ratings[i]) {
                candyFor[i] = candyFor[i - 1] + 1;
            }
            else candyFor[i] = 1;
        }
        total += candyFor[len - 1];
        for (int j = len - 2; j >= 0; j--){
            if (ratings[j] > ratings[j + 1]){
                candyFor[j] = Math.max(candyFor[j + 1] + 1, candyFor[j]);
            }
            total += candyFor[j];
        }
        return total;
    }
}
