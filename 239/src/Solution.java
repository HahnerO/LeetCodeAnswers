import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
//    }

    Deque<Integer> max = new LinkedList<>();

    public int[] maxSlidingWindow(int[] nums, int k){
        int len = nums.length;
        if (len == 0 || k == 0) return new int[]{};
        if (len == 1 || k == 1) return nums;


        for (int n = 0; n < k; n++){
            addToMax(nums[n]);
        }
        int[] window = new int[len - k + 1];
        for (int i = 0, j = k - 1; j < len - 1; i++, j++){
            window[i] = max.getFirst();
            deleteMax(nums[i]);
            addToMax(nums[j + 1]);
        }
        window[len - k] = max.getFirst();
        return window;
    }

    public void addToMax(int k){
        if (max.size() == 0){
            max.addLast(k);
            return;
        }
        if (max.getFirst() < k){
            max = new LinkedList<>();
            max.addLast(k);
            return;
        }
        while (max.getLast() < k){
            max.removeLast();
        }
        max.addLast(k);

    }

    public void deleteMax(int k){
        if (max.getFirst() == k) max.removeFirst();
    }
}
