public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        String maxCommon = strs[0];
        for (int i = 1; i < strs.length; i++) {
            maxCommon = getCommon(maxCommon, strs[i]);
            if (maxCommon.equals("")) return "";
        }
        return maxCommon;
    }

    public String getCommon(String s1, String s2){
        if (s2.length() == 0) return "";
        StringBuilder max = new StringBuilder();
        for (int i = 0, j = 0; i < s1.length() && j < s2.length(); i++, j++){
            if (s1.charAt(i) != s2.charAt(j)) return max.toString();
            max.append(s1.charAt(i));
        }
        return max.toString();
    }
}
