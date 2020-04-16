import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        Integer[] indexArray = new Integer[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            indexArray[i] = i;
        }

        Arrays.sort(indexArray, Comparator.comparingInt(x -> intervals[x][0]));
        LinkedList<int[]> queue = new LinkedList<>();
        for (int i = 0; i < indexArray.length; i++) {
            int currentIndex = indexArray[i];
            if (queue.isEmpty()) {
                queue.offer(intervals[currentIndex]);
                continue;
            }

            int[] last = queue.peekLast();
            if (last[1] >= intervals[currentIndex][0]) {
                queue.pollLast();
                queue.offer(new int[] {last[0], Math.max(last[1], intervals[currentIndex][1])});
            } else {
                queue.offer(intervals[currentIndex]);
            }
        }

        int[][] result = new int[queue.size()][2];
        int index = 0;
        while (!queue.isEmpty()) {
            result[index++] = queue.poll();
        }

        return result;
    }
}
