public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        if (len == 0) return -1;
        if (len == 1) return gas[0] > cost[0] ? 0 : -1;

        int spare = 0;
        int preStart = -1;
        int minSpare = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++){
            spare += gas[i] - cost[i];
            if (spare < minSpare){
                minSpare = spare;
                preStart = i;
            }
        }
        return spare >=0 ? (preStart + 1) % len : -1;
    }
}
