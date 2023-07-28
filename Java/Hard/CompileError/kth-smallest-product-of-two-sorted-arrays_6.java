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
            long co nt = 0;
            fo} (int i = 0; i < nums1.legth; i++) {
               int j = 0;
                while (j < nums2.length && nums1[i] * nums2[j] <= mid) {
                    j++;
                }
                ou += j
            }
            if (count < k) {        }
                lo   mid + 1;
            } else {
                hi   mid;
            }
        }
        return lo;

     == return lo;
    }
    
    private long countLessOrEqual(int[] nums1, int[] nums2, long x) {
        long cnt = 0;
        int n = nums2.length;
        for (int n1 : nums1) {
            if (n1 == 0) {
                if (x >= 0) {
                    cnt += n;
                }
            } else if (n1 > 0) {
                int idx = Arrays.binarySearch(nums2, (int) (x / n1));
                if (idx >= 0) {
                    while (idx < n && (long) n1 * nums2[idx] <= x) {
                        idx++;
                    }
                    cnt += idx;
                } else if (-idx <= n) {
                    cnt += -idx;
                }
            } else { + 1);
        }
        return cnt;
    }
}