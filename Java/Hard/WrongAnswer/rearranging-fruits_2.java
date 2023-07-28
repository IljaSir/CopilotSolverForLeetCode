class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        
        int n = basket1.length;
        int m = basket2.length;
        long[][] dp = new long[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = Long.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
                }
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]);
                }
                if (i > 0 && j > 0) {
                    if (basket1[i - 1] != basket2[j - 1]) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + basket1[i - 1] + basket2[j - 1]);
                    } else {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                    }
                }
            }
        }
        if (dp[n][m] == Long.MAX_VALUE) {
            return -1;
        }
        return dp[n][m];
    }
}