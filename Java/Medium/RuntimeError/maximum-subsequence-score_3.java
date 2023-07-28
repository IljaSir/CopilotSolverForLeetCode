class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        
        int n = nums1.length;
        long[] dp = new long[k+1];
        Arrays.fill(dp, Long.MIN_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; ++i) {
            long[] dp2 = new long[k+1];
            Arrays.fill(dp2, Long.MIN_VALUE);
            for (int j = 0; j <= k; ++j) {
                if (j > 0 && i < n - 1) dp2[j] = Math.max(dp2[j], dp[j-1] + nums1[i]);
                if (j < k) dp2[j] = Math.max(dp2[j], dp[j] + nums2[i]);
            }
            dp = dp2;
        }
        return dp[k];
    }
}