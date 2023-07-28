class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        
        long lo = (long)nums1[0] * nums2[0];
        long hi = (long)nums1[nums1.length - 1] * nums2[nums2.length - 1];
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            long count = 0;
            for (int i = 0; i < nums1.length; i++) {
                int j = upperBound(nums2, mid / nums1[i]);
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
    
    private int upperBound(int[] nums, long target) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] <= target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}