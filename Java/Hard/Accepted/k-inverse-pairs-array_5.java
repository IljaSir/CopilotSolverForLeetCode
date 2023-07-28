class Solution {
    public int kInversePairs(int n, int k) {
        
        int mod = (int) 1e9 + 7;
        int[][] dp = new int[n + 1][k + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                if (dp[i][j] >= mod) {
                    dp[i][j] -= mod;
                }
                if (j >= i) {
                    dp[i][j] -= dp[i - 1][j - i];
                    if (dp[i][j] < 0) {
                        dp[i][j] += mod;
                    }
                }
            }
        }
        return dp[n][k];
    }
}