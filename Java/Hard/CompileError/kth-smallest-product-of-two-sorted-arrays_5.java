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
           urn cnt;
    }
}