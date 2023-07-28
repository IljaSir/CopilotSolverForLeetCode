class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        
        int n = nums1.length;
        long[] sorted = new long[n];
        for (int i = 0; i < n; ++i) {
            sorted[i] = 1L * nums1[i] * nums2[i] + 1L * nums2[i] * 100000;
        }
        Arrays.sort(sorted);
        long res = 0;
        for (int i = 0; i <= k; ++i) {
            int j = k - i;
            if (i <= n && j <= n) {
                res = Math.max(res, sum(sorted, 0, i) + sum(sorted, n - j, n));
            }
        }
        return res;
    }
    long sum(long[] nums, int l, int r) {
        long res = 0;
        for (int i = l; i < r; ++i) {
            res += nums[i] / 100000;
        }
        return res;
    }
}