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
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < target; k++) {
                    if (houses[i] != 0 && houses[i] != j + 1) {
                        continue;
                    }
                    if (i == 0) {
                        if (k == 0) {
                            dp[i][j][k] = houses[i] == 0 ? cost[i][j] : 0;
                        }
                    } else {
                        for (int p = 0; p < n; p++) {
                            if (p == j) {
                                if (k < target - 1) {
                                    dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][p][k + 1] + (houses[i] == 0 ? cost[i][j] : 0));
                                }
                            } else {
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][p][k] + (houses[i] == 0 ? cost[i][j] : 0));
                            }
                        }
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp[m - 1][i][0]);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}