import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> table = new HashMap();

        if(s.length() != t.length()) return false;

        for (char c : s.toCharArray()) {
            if (table.containsKey(c)) {
                table.put(c, table.get(c) + 1);
            }
            table.put(c, 1);
        }

        for (char i : t.toCharArray()) {
            int times = 0;
            if (!table.containsKey(i)) return false;
            if ((times = table.get(i) - 1) < 0) return false;
            table.put(i, times);
        }

        return true;
    }
}