public class Solution {
    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        if (len == 0) return null;
        if (len == 1) return new int[]{0};

        int[] daysUp = new int[len];
        daysUp[len - 1] = 0;
        for (int i = len - 2; i >= 0; i--){
            for (int j = i + 1; j < len; j += daysUp[j]){
                if (T[j] > T[i]) {
                    daysUp[i] = j - i;
                    break;
                }else if (daysUp[j] == 0) {
                    daysUp[i] = 0;
                    break;
                }
            }
        }
        return daysUp;
    }
}
