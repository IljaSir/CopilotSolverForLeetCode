class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        
        int[][][] dp = new int[m + 1][n + 1][target + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= target; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE / 2;
                }
            }
        }
        if (houses[0] == 0) {
            for (int i = 1; i <= n; i++) {
                dp[1][i][1] = cost[0][i - 1];
            }
        } else {
            dp[1][houses[0]][1] = 0;
        }
        for (int i = 2; i <= m; i++) {
            if (houses[i - 1] == 0) {
                for (int j = 1; j <= n; j++) {
                    for (int k = 1; k <= target; k++) {
                        for (int l = 1; l <= n; l++) {
                            if (j == l) {
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][l][k] + cost[i - 1][j - 1]);
                            } else {
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][l][k - 1] + cost[i - 1][j - 1]);
                            }
                        }
                    }
                }
            } else {
                int j = houses[i - 1];
                for (int k = 1; k <= target; k++) {
                    for (int l = 1; l <= n; l++) {
                        if (j == l) {
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][l][k]);
                        } else {
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][l][k - 1]);
                        }
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            ans = Math
    }
}