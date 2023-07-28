class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        
        int[][][] dp = new int[m + 1][n + 1][target + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE / 2);
            }
        }
        dp[0][0][0] = 0;
        for (int i = 1; i <= m; i++) {
            int color = houses[i - 1];
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= target; k++) {
                    if (color != 0) {
                        if (j == color) {
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j][k]);
                        }
                        dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j][k - 1]);
                    } else {
                        dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j][k] + cost[i - 1][j - 1]);
                        dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j][k - 1]);
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int j = 1; j <= n; j++) {
            res = Math.min(res, dp[m][j][target]);
        }
        return res == Integer.MAX_VALUE / 2 ? -1 : res;
    }
}