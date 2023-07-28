class Solution {
    public int numberOfSets(int n, int k) {
        
        int MOD = 1_000_000_007;
        int[][] dp = new int[k + 1][n + 1];
        for (int i = 1; i <= k; i++) {
            for (int j = i; j <= n; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = (dp[i][j - 1] + dp[i - 1][j - 1]) % MOD;
                    dp[i][j] = (dp[i][j] + (int)((1L * j * dp[i][j - 1]) % MOD)) % MOD;
                }
            }
        }
        return dp[k][n];
    }
}