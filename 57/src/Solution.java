import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int length = intervals.length;
        if (length == 0) return new int[][]{newInterval};

        List<int[]> ans = new ArrayList<>();
        int idx = 0;
        while (idx < length && newInterval[0] > intervals[idx][1]){
            ans.add(intervals[idx++]);
        }
        while (idx < length && newInterval[1] >= intervals[idx][0]){
            newInterval[0] = Math.min(newInterval[0], intervals[idx][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[idx][1]);
            idx++;
        }
        ans.add(newInterval);
        while (idx < length){
            ans.add(intervals[idx++]);
        }

        return ans.toArray(new int[0][]);
    }
}
