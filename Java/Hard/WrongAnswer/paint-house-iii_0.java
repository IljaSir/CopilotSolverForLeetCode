class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        
        int[][][] dp = new int[m + 1][n + 1][target + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE / 2);
            }
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0][0] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= target; k++) {
                    if (houses[i - 1] != 0) {
                        if (houses[i - 1] == j) {
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j][k]);
                            if (k > 1) {
                                for (int l = 1; l <= n; l++) {
                                    if (l != j) {
                                        dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][l][k - 1]);
                                    }
                                }
                            }
                        }
                    } else {
                        dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j][k] + cost[i - 1][j - 1]);
                        if (k > 1) {
                            for (int l = 1; l <= n; l++) {
                                if (l != j) {
                                    dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][l][k - 1] + cost[i - 1][j - 1]);
                                }
                            }
                        }
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            ans = Math.min(ans, dp[m][i][target]);
        }
        return ans == Integer.MAX_VALUE / 2 ? -1 : ans;
    }
}