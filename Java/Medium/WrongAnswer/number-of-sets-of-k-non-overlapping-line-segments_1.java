class Solution {
    public int numberOfSets(int n, int k) {
        
        long[][] dp = new long[k + 1][n + 1];
        int mod = 1000000007;
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j - 1]) % mod;
                if (j >= 2) {
                    dp[i][j] = (dp[i][j] + dp[i][j - 2] * (j - 1)) % mod;
                }
            }
        }
        return (int)dp[k][n];
    }
}