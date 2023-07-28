class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        
        long lo = Long.MAX_VALUE, hi = Long.MIN_VALUE;
        for (int n1 : nums1) {
            lo = Math.min(lo, n1);
            hi = Math.max(hi, n1);
        }
        for (int n2 : nums2) {
            lo = Math.min(lo, n2);
            hi = Math.max(hi, n2);
        }
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long cnt = countLessOrEqual(nums1, nums2, mid);
            if (cnt < k) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
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
            } else {
                int idx = Arrays.binarySearch(nums2, (int) (x / n1));
                if (idx >= 0) {
                    while (idx >= 0 && (long) n1 * nums2[idx] > x) {
                        idx--;
                    }
                    cnt += n - idx - 1;
                } else if (-idx <= n) {
                    cnt += n + idx + 1;
                }
            }
        }
        return cnt;
    }
}