class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        
        int n = nums1.length;
        int m = nums2.length;
        if (n > m) {
            return kthSmallestProduct(nums2, nums1, k);
        }
        long lo = Long.MAX_VALUE;
        long hi = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            lo = Math.min(lo, nums1[i] * (long) nums2[0]);
            hi = Math.max(hi, nums1[i] * (long) nums2[m - 1]);
        }
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            int count = 0;
            for (int i = 0; i < n; i++) {
                int j = m - 1;
                while (j >= 0 && nums1[i] * (long) nums2[j] > mid) {
                    j--;
                }
                count += j + 1;
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