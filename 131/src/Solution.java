import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0) return false;
        if (s.length() == 1) return true;
        for (int i = 0; i < (s.length()/2 + 1); i++){
            if (s.charAt(i) != s.charAt(s.length() - i- 1)){
                return false;
            }
        }
        return true;
    }

    Deque<String> curPartition = new ArrayDeque<>();
    String string;

    public List<List<String>> getPartition(int index, List<List<String>> output){
        if (index == string.length()) {
            output.add(new ArrayList<>(curPartition));
            return output;
        }
        for (int i = 0; i < string.substring(index).length(); i++) {
            String section  = string.substring(index, index + i + 1);
            if (isValid(section)) {
                curPartition.add(section);
                getPartition(index + i + 1, output);
                curPartition.removeLast();
            }
        }
        return output;
    }

    public List<List<String>> partition(String s) {
        this.string = s;
        List<List<String>> out = new ArrayList<>();
        return getPartition(0, out);
    }
}
