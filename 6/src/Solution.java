import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        if (s.length() <= 2) return s;

        List<StringBuilder> row = new ArrayList<>();
        for (int m = 0; m < numRows; m++) row.add(new StringBuilder());
        int direction = 1;
        int j = 0;
        for (int i = 0; i < s.length(); i++){
            if (j == 0) direction = 1;
            if (j == numRows - 1) direction = -1;
            row.get(j).append(s.charAt(i));
            j += direction;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder r : row) res.append(r.toString());
        return res.toString();
    }
}
