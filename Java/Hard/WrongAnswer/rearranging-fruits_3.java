class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        
        int n = basket1.length;
        int m = basket2.length;
        long[][] dp = new long[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (dp[i][j] == Long.MAX_VALUE) {
                    continue;
                }
                if (i < n) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + basket1[i]);
                }
                if (j < m) {
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + basket2[j]);
                }
                if (i < n && j < m) {
                    dp[i + 1][j + 1] = Math.min(dp[i + 1][j + 1], dp[i][j] + Math.min(basket1[i], basket2[j]));
                }
            }
        }
        return dp[n][m] == Long.MAX_VALUE ? -1 : dp[n][m];
    }
}