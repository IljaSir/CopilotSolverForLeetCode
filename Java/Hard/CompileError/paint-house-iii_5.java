class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        
        int[][][] dp = new int[m][n][target];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        if (houses[0] == 0) {
            for (int i = 0; i < n; i++) {
                dp[0][i][0] = cost[0][i];
            }
        } else {
            dp[0][houses[0] - 1][0] = 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int preColor = houses[i - 1] == 0 ? j : houses[i - 1] - 1;
                for (int k = 0; k < target; k++) {
                    if (dp[i - 1][preColor][k] == Integer.MAX_VALUE) {
                        continue;
                    }
                    if (houses[i] == 0) {
                        for (int j2 = 0; j2 < n; j2++) {
                            if (j2 == j) {
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][preColor][k] + cost[i][j2]);
                            } else {
                                dp[i][j][k + 1] = Math.min(dp[i][j][k + 1], dp[i - 1][preColor][k] + cost[i][j2]);
                            }
                        }
                    } else {
                        int curColor = houses[i] - 1;
                        if (curColor == j) {
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][preColor][k]);
                        } else {
                            dp[i][curColor][k + 1] = Math.min(dp[i][curColor][k + 1], dp[i - 1][preColor][k]);
                        }
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp[m - 1
    }
}