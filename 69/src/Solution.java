public class Solution {
    public int mySqrt(int x){
        if (x == 0) return 0;
        long left = 1;
        long right = x >> 1;
        while (left < right){
            long mid = (left + right + 1) >> 1;
            long sqr = mid * mid;
            if (sqr < x) left = mid;
            else if (sqr > x ) right = mid - 1;
            else return (int) mid;
        }
        return (int) left;
    }
}
