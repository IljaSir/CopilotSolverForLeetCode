class Solution {
    public int kInversePairs(int n, int k) {
        
        int mod = 1000000007;
        int[][] dp = new int[n+1][k+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
                if (j >= i) {
                    dp[i][j] -= dp[i-1][j-i];
                }
                dp[i][j] = (dp[i][j] + mod) % mod;
            }
        }
        return dp[n][k];
    }
}