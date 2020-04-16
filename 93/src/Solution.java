import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    LinkedList<String> segments = new LinkedList<String>();
    ArrayList<String> output = new ArrayList<String>();

    public List<String> restoreIpAddresses(String s) {
        findIp(3, s);
        return output;
    }

    public void findIp(int dotsNum, String resString){
        if (resString.equals("")) return;
        if (dotsNum == 0) {
            if (isValid(resString)){
                segments.add(resString);
                output.add(String.join(".", segments));
                segments.removeLast();
            }
            return;
        }
        for (int i = 0; i < resString.length(); i++){
            if (isValid(resString.substring(0, i + 1))){
                segments.add(resString.substring(0, i + 1));
                findIp(dotsNum - 1, resString.substring(i + 1));
                segments.removeLast();
            }
        }
    }

    public boolean isValid(String substring){
        return substring.length() <= 3 && Integer.parseInt(substring) <= 255 && substring.equals(String.valueOf(Integer.parseInt(substring)));
    }
}
