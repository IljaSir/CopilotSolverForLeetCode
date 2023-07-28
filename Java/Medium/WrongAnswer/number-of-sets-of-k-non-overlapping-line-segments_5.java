class Solution {
    public int numberOfSets(int n, int k) {
        
        int[][] dp = new int[n + 1][k + 1];
        int mod = 1_000_000_007;
        for (int i = 1; i <= n; i++) {
            dp[i][1] = i * (i - 1) / 2;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - 1]) % mod;
                if (i >= 2) {
                    dp[i][j] = (dp[i][j] + dp[i - 2][j - 1]) % mod;
                }
            }
        }
        return dp[n][k];
    }
}