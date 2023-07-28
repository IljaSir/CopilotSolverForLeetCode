class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        
        int[][][] dp = new int[m][n][target];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        if (houses[0] == 0) {
            for (int j = 0; j < n; j++) {
                dp[0][j][0] = cost[0][j];
            }
        } else {
            dp[0][houses[0] - 1][0] = 0;
        }
        for (int i = 1; i < m; i++) {
            if (houses[i] == 0) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < target; k++) {
                        if (dp[i - 1][j][k] != Integer.MAX_VALUE) {
                            dp[i][j][k] = Math.min(dp[i - 1][j][k] + cost[i][j], dp[i][j][k]);
                        }
                        for (int j2 = 0; j2 < n; j2++) {
                            if (j != j2 && dp[i - 1][j2][k - 1] != Integer.MAX_VALUE) {
                                dp[i][j][k] = Math.min(dp[i - 1][j2][k - 1] + cost[i][j], dp[i][j][k]);
                            }
                        }
                    }
                }
            } else {
                for (int k = 0; k < target; k++) {
                    if (dp[i - 1][houses[i] - 1][k] != Integer.MAX_VALUE) {
                        dp[i][houses[i] - 1][k] = Math.min(dp[i - 1][houses[i] - 1][k], dp[i][houses[i] - 1][k]);
                    }
                    for (int j2 = 0; j2 < n; j2++) {
                        if (houses[i] - 1 != j2 && dp[i - 1][j2][k - 1] != Integer.MAX_VALUE) {
                            dp[i][houses[i] - 1][k] = Math.min(dp[i
    }
}