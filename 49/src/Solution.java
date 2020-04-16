import java.util.*;

public class Solution {
    List<List<String>> ans = new ArrayList<>() ;
    HashMap<String,List<String>> map = new HashMap<>() ;
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return ans ;
        for(String s:strs){
            String temp = getString(s) ;
            if(!map.containsKey(temp)){
                map.put(temp,new ArrayList<>()) ;
            }
            map.get(temp).add(s) ;
        }
        for(Map.Entry<String,List<String>> entry:map.entrySet()){
            ans.add(entry.getValue()) ;
        }
        return ans ;
    }
    public String getString(String s){
        char[] ss = s.toCharArray() ;
        Arrays.sort(ss) ;
        return String.valueOf(ss) ;
    }
}
