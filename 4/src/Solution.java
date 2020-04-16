class Solution {
    public static void main(String[] args) {

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int left = (n + m + 1) / 2;
        //总数是偶数，返回1/2
        if ((m + n) % 2 == 0){
            int right = (n + m + 2) / 2;
            return (getKth(nums1, nums2, left, 0, m - 1, 0, n - 1) +
                    getKth(nums1, nums2, right, 0, m - 1, 0, n - 1)) / 2;
        }
        //总数是奇数
        return getKth(nums1, nums2, left, 0, m - 1, 0, n - 1);
    }

    public double getKth(int[] nums1, int[] nums2, int k, int start1, int end1, int start2, int end2) {
        int len1 = end1 - start1 + 1, len2 = end2 - start2 + 1;
        //让len1保持较小
        if (len1 > len2) return getKth(nums2, nums1, k, start2, end2, start1, end1);
        //len1到头了， 返回len2中剩下的
        if (len1 == 0) return nums2[start2 + k -1];
        //只剩下一个要找的，返回较小的
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);
        //开始处理一般情况
        //找到两个比较点
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;
        //淘汰j左方的部分
        if (nums1[i] > nums2[j]) {
            return getKth(nums1, nums2, k - (j - start2 + 1), start1, end1, j + 1, end2);
        }
        //淘汰i左方的部分
        else {
            return getKth(nums1, nums2, k - (i - start1 + 1), i + 1, end1, start2, end2);
        }
    }
}
