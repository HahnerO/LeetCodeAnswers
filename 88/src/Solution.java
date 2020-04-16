public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2 == null || nums2.length < 1) return;
        int firstEnd = nums1.length - nums2.length - 1;
        int secondEnd = nums1.length - 1;
        int j = nums2.length - 1;
        while (firstEnd < secondEnd && firstEnd >= 0) {
            if (nums1[firstEnd] <= nums2[j]){
                nums1[secondEnd] = nums2[j];
                j--;
            }
            else {
                nums1[secondEnd] = nums1[firstEnd];
                firstEnd--;
            }
            secondEnd--;
        }
        if (firstEnd == -1){
            while (secondEnd >= 0){
                nums1[secondEnd] = nums2[j];
                secondEnd--;
                j--;
            }
        }
    }
}
