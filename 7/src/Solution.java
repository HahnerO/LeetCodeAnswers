public class Solution {
    public static void main(String[] args) {
        System.out.println(reverse2(123));
    }

    public int reverse(int x) {
        int ans = 0;
        while (x != 0) {
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            ans = ans * 10 + pop;
            x /= 10;
        }
        return ans;
    }

    public static int reverse2(int x){
        int prefix = 1;
        if (x < 0) prefix = -1;
        String s = String.valueOf(Math.abs(x));
        char[] a = s.toCharArray();
        int ans = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            if (ans == 0 && a[i] == '0') continue;
            ans = ans * 10 + (a[i] - '0');
            if (ans > Integer.MAX_VALUE / 10) return 0;
            if (-ans < Integer.MIN_VALUE /10) return 0;
        }
        return ans * prefix;
    }
}
