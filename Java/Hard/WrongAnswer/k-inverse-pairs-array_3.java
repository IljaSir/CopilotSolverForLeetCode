class Solution {
    public int kInversePairs(int n, int k) {
        
        int[][] dp = new int[n + 1][k + 1];
        int mod = 1000000007;
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= i) {
                    dp[i][j] -= dp[i - 1][j - i];
                } else {
                    dp[i][j] -= 0;
                }
                dp[i][j] += dp[i][j - 1];
                dp[i][j] = (dp[i][j] + mod) % mod;
            }
        }
        return dp[n][k];
    }
}