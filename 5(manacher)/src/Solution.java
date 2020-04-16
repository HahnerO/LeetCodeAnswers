import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("babadada"));
    }

    public String longestPalindrome(String s){
        if (s.length() <= 1) return s;
        return manacher(s);
    }

    public String manacher(String s){
        String mS = preProcess(s);
        char[] mArray = mS.toCharArray();
        int c = 0, R = 0, maxIdx = 0;
        int[] r = new int[mArray.length];
        for (int i = 1; i < mArray.length; i++) {
            if(i > R) {
                r[i] = findRadius(mS, i, 0);
            }else if (r[2 * c - i] + i >= R){
                r[i] = findRadius(mS, i, R - i);
            }else {
                r[i] = r[2 * c - i];
            }
            if (i + r[i] > R) {
                c = i;
                R = i + r[i];
            }
            maxIdx = r[i] > r[maxIdx] ? i : maxIdx;
        }


        if (r[maxIdx] == 0) {
            return s.substring(0, 1);
        }
        return afterProcess(s, maxIdx, r[maxIdx]);
    }

    public int findRadius(String str, int idx, int radius){

        if (idx == str.length() - 1) return 0;
        while (true) {
            int i = idx - radius - 1;
            int j = idx + radius + 1;
            if (i < 0 || j >= str.length()) break;
            if (str.charAt(i) != str.charAt(j)) break;
            radius ++;
        }
        return radius;
    }

    public String afterProcess(String s, int idx, int radius) {
        int start = (idx - radius + 1) / 2;
        int end = (idx + radius - 1) / 2;
        return s.substring(start, end + 1);
    }

    public String preProcess(String s){
        int len = 2 * s.length() + 1;
        char[] res = new char[len];
        for (int i = 0; i < s.length(); i++) {
            res[2 * i] = '#';
            res[2 * i + 1] = s.charAt(i);
        }
        res[len - 1] = '#';
        return String.valueOf(res);
    }
}
