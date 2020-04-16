import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public int[] getAllEvenNumber (int a_nMax) {
        // write code here
        if (a_nMax < 4) return new int[]{};
        int len = a_nMax / 2;
        int[] res = new int[len];
        for (int i = 0; i < len; i ++){
            res[i] = (i + 1) << 1;
        }
        return res;
    }

}
