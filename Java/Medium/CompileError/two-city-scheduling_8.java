class Solution {
    public int twoCitySchedCost(int[][] costs) {
        
        int n = costs.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = costs[0][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + costs[i][0];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j] + costs[i][0], dp[i-1][j-1] + costs[i][1]);
                }
            }
        }
        return dp[n-1][n/2];
    }
}
    }
}