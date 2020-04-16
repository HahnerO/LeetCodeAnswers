public class Solution {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        int prefix = 1;
        while (cur < k){
            int tmp = getCount(prefix, n);
            if ((cur + tmp) > k) {
                prefix *= 10;
                cur++;
            } else {
                prefix++;
                cur += tmp;
            }
        }
        return prefix;
    }

    public int getCount(int prefix, int n){
        long cur = prefix;
        long next = cur +1;
        int count = 0;
        while (cur <= n) {
            count += Math.min(n + 1, next) - cur;
            cur *= 10;
            next *= 10;
        }
        return count;
    }
}
