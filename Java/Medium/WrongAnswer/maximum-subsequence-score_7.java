class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        
        int[] min = nums1;
        int[] max = nums2;
        if (nums1.length < nums2.length) {
            min = nums2;
            max = nums1;
        }
        int n = min.length;
        int m = max.length;
        long[] dp = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + min[i - 1];
        }
        long ans = 0;
        for (int i = 0; i <= k; i++) {
            int j = k - i;
            if (j > m) {
                continue;
            }
            long sum = dp[i];
            if (j > 0) {
                sum += max[j - 1];
            }
            ans = Math.max(ans, sum * (i + j));
        }
        return ans;
    }
}