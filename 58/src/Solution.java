public class Solution {
    public int lengthOfLastWord(String s) {
        if (s.length() == 0) return 0;
        String[] sa = s.split(" ");
        if (sa.length == 0) return 0;

        return sa[sa.length - 1].equals("") ? 0 : sa[sa.length - 1].length();
    }
}
