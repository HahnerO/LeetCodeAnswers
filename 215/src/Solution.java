import java.util.PriorityQueue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length < k) return -1;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            heap.add(nums[i]);
        }
        for (int j = k; j < nums.length; j++){
            if (heap.peek() < nums[j]) {
                heap.poll();
                heap.add(nums[j]);
            }
        }
        return heap.poll();
    }
}
