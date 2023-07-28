class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        
        int[][][] dp = new int[m][n][target];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < target; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        dp[0][houses[0] - 1][0] = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < target; k++) {
                    if (dp[i - 1][j][k] == Integer.MAX_VALUE) {
                        continue;
                    }
                    if (houses[i] == 0) {
                        for (int j1 = 0; j1 < n; j1++) {
                            if (j1 != j) {
                                dp[i][j1][k] = Math.min(dp[i][j1][k], dp[i - 1][j][k] + cost[i][j1]);
                            } else {
                                dp[i][j1][k] = Math.min(dp[i][j1][k], dp[i - 1][j][k]);
                            }
                        }
                        if (k + 1 < target) {
                            for (int j1 = 0; j1 < n; j1++) {
                                if (j1 != j) {
                                    dp[i][j1][k + 1] = Math.min(dp[i][j1][k + 1], dp[i - 1][j][k] + cost[i][j1]);
                                }
                            }
                        }
                    } else {
                        if (j == houses[i] - 1) {
                            for (int j1 = 0; j1 < n; j1++) {
                                if (j1 != j) {
                                    dp[i][j1][k + 1] = Math.min(dp[i][j1][k + 1], dp[i - 1][j][k]);
                                } else {
                                    dp[i][j1][k] = Math.min(dp[i][j1][k], dp[i - 1][j][k]);
                                }
                            }
                        }
                    }
                }
    }
}