public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        int cur = x;
        int reX = 0;
        while (cur != 0){
            int last = cur % 10;
            if (reX == 0 && last == 0) return false;
            reX *= 10;
            reX += last;
            cur /= 10;
        }
        return reX == x;
    }
}
