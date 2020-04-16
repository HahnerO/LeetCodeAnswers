public class Solution {
    public String reverseString(char[] s) {
        char temp;
        int length = s.length;
        for (int i = 0 ,j = length -1; i < length / 2 ; i++,j--) {
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
        return new String(s);
    }
}
