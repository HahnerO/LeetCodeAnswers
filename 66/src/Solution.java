public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if (len == 0) return new int[]{1};

        int cr = 1, idx = len - 1;
        while (idx >= 0 && cr == 1){
            int temp = digits[idx] + cr;
            digits[idx] = temp % 10;
            cr = temp / 10;
            idx--;
        }
        if (cr == 1) {
            int[] rtv = new int[len + 1];
            rtv[0] = 1;
            System.arraycopy(digits, 0, rtv, 1, len);
            return rtv;
        }
        return digits;
    }
}
