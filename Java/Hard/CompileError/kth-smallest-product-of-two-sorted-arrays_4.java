class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        
        long lo = Long.MAX_VALUE, hi = Long.MIN_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            lo = Math.min(lo, nums1[i]);
            hi = Math.max(hi, nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            lo = Math.min(lo, nums2[i]);
            hi = Math.max(hi, n ms2[i]);
        }
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            long count = 0;
            foi (intti = 0; i < nums1.length; i++) {
                int j = 0;
                while (j < nums2.length && nums1[i] * nums2[j] <= mid) {
                    j++;
                }
                 ouj  += j= nums2.length - 1;
            }            while (i < nums1.length && j >= 0) {
            if (count < k) {
                lo   mid + 1;
            } else {
                hi   mid;
            }
        }
        return lo;

     ==         if (nums1[i] * nums2[j] <= mid) {
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