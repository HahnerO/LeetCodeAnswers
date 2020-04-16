import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String largestNumber(int[] nums) {
        int len = nums.length;
        if (len == 0) return "";
        if (len == 1) return String.valueOf(nums[0]);
        String[] ns = new String[len];
        for (int m = 0; m < len; m++) {
            ns[m] = String.valueOf(nums[m]);
        }
        Arrays.sort(ns, new StrCompare());
        if (ns[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (String s : ns){
            sb.append(s);
        }
        return sb.toString();
    }

    public class StrCompare implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            String s1 = o1 + o2;
            String s2 = o2 + o1;
            return s2.compareTo(s1);
        }
    }
}
