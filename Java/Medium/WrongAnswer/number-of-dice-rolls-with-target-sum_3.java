class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (j <= k) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - k - 1];
                }
                dp[i][j] = (dp[i][j] + 1000000007) % 1000000007;
            }
        }
        return dp[n][target];
    }
}