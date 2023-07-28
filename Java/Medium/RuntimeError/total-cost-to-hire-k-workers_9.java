class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        
        // DP
        // dp[i][j] = min(dp[i][j], dp[i-1][j-1] + costs[i-1])
        // dp[i][j] = min(dp[i][j], dp[i-1][j] + costs[i-1])
        // dp[i][j] = min(dp[i][j], dp[i-1][j] + costs[i-1])
        // dp[i][j] = min(dp[i][j], dp[i-1][j+1] + costs[i-1])
        // dp[i][j] = min(dp[i][j], dp[i-1][j+2] + costs[i-1])
        // ...
        // dp[i][j] = min(dp[i][j], dp[i-1][j+candidates] + costs[i-1])
        int n = costs.length;
        long[][] dp = new long[n+1][k+1];
        for (int i = 0; i < n+1; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 1; i < n+1; i++) {
            for (int j = 0; j < k+1; j++) {
                for (int c = 1; c <= candidates; c++) {
                    if (j-c < 0) break;
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j-c] + costs[i-1]);
                }
            }
        }
        return dp[n][k];
    }
}