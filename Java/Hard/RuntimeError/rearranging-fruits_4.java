class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        
        int n = basket1.length;
        long[][] dp = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                int k = i + j;
                if (i > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + basket1[k - 1]);
                }
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + basket2[k - 1]);
                }
                if (i > 0 && j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + Math.min(basket1[k - 1], basket2[k - 1]));
                }
            }
        }
        return dp[n][n] == Long.MAX_VALUE ? -1 : dp[n][n];
    }
}