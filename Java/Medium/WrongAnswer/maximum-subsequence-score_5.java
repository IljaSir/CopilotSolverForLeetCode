class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        
        long[][] dp = new long[k + 1][k + 1];
        for (int i = 0; i <= k; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = 0;
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= k; j++) {
                if (i + j > k) {
                    continue;
                }
                if (i > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + nums1[i + j - 1]);
                }
                if (j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + nums2[i + j - 1]);
                }
            }
        }
        return dp[k][k];
    }
}