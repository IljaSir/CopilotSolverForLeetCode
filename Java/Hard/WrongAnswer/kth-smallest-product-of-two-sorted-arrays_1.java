class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            min = Math.min(min, nums1[i]);
            max = Math.max(max, nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            min = Math.min(min, nums2[i]);
            max = Math.max(max, nums2[i]);
        }
        long low = min * max;
        long high = max * max;
        while (low < high) {
            long mid = low + (high - low) / 2;
            long count = 0;
            int i = 0;
            int j = nums2.length - 1;
            while (i < nums1.length && j >= 0) {
                if (nums1[i] * nums2[j] <= mid) {
                    count += j + 1;
                    i++;
                } else {
                    j--;
                }
            }
            if (count >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}