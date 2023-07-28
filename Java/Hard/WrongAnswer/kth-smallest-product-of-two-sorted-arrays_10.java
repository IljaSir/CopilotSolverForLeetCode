class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        
        long lo = Long.MAX_VALUE, hi = Long.MIN_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            lo = Math.min(lo, nums1[i]);
            hi = Math.max(hi, nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            lo = Math.min(lo, nums2[i]);
            hi = Math.max(hi, nums2[i]);
        }
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            long count = 0;
            for (int i = 0; i < nums1.length; i++) {
                int j = 0;
                while (j < nums2.length && nums1[i] * nums2[j] <= mid) {
                    j++;
                }
                count += j;
            }
            if (count < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}