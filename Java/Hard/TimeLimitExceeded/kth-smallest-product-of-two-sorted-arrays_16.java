class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        
        long min = Long.MIN_VALUE;
        long max = Long.MAX_VALUE;
        while (min < max) {
            long mid = min + (max - min) / 2;
            long cnt = count(nums1, nums2, mid);
            if (cnt < k) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }
    
    private long count(int[] nums1, int[] nums2, long target) {
        long cnt = 0;
        for (int i = 0; i < nums1.length; i++) {
            int j = nums2.length - 1;
            while (j >= 0 && nums1[i] * (long)nums2[j] > target) {
                j--;
            }
            cnt += (j + 1);
        }
        return cnt;
    }
}