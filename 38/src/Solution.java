public class Solution {
    public String countAndSay(int n) {
        String nums = "1";
        for (int i = 1; i < n; i++) nums = describe(nums.toCharArray());
        return nums;
    }

    public static String describe(char[] chars) {
        StringBuilder string = new StringBuilder();
        char ch = chars[0];
        int temp = 1, i = 1;
        while (i < chars.length){
            if (chars[i] == ch) {
                temp++;
            } else {
                string.append(temp).append(chars[i - 1]);
                ch = chars[i];
                temp = 1;
            }
            i++;
        }
        string.append(temp).append(chars[i - 1]);
        return string.toString();
    }
}
