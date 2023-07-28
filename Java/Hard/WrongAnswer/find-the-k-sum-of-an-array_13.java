class Solution {
    public long kSum(int[] nums, int k) {
        
        long sum = 0;
        int n = nums.length;
        long[][] dp = new long[n][k + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                if (i > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                }
                if (j == 1) {
                    dp[i][j] = Math.max(dp[i][j], nums[i]);
                } else {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 2] + nums[i]);
                }
            }
        }
        return dp[n - 1][k];
    }
}