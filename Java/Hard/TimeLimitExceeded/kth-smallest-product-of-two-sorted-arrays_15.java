class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        
        long l = Long.MIN_VALUE;
        long r = Long.MAX_VALUE;
        while (l < r) {
            long m = l + (r - l) / 2;
            if (count(nums1, nums2, m) < k) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
    private long count(int[] nums1, int[] nums2, long m) {
        long cnt = 0;
        for (int i = 0; i < nums1.length; i++) {
            int l = 0;
            int r = nums2.length - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (nums1[i] * (long) nums2[mid] <= m) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            cnt += nums1[i] * (long) nums2[l] <= m ? l + 1 : l;
        }
        return cnt;
    }
}