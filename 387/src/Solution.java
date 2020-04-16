class Solution {
    public int firstUniqChar(String s) {
        int res = s.length();
        for (int i = 'a'; i <= 'z'; i++) {
            int firstIndex = s.indexOf((char)i);
            if (firstIndex == -1) continue;
            int lastIndex = s.lastIndexOf((char)i);
            if (firstIndex == lastIndex) {//两次索引值相同则证明该字母只出现一次
                res = Math.min(firstIndex, res);//res 为只出现一次的字母中索引值最小的
            }
        }
        return res == s.length() ? -1 : res;
    }
}