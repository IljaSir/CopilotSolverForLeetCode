class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        
        if (houses.length == 0) return 0;
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
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j][k] + cost[i][j]);
                            for (int l = 0; l < n; l++) {
                                if (l != j) {
                                    dp[i][j][k + 1] = Math.min(dp[i][j][k + 1], dp[i - 1][l][k] + cost[i][j]);
                                }
                            }
                        }
                    }
                }
            } else {
                int j = houses[i] - 1;
                for (int k = 0; k < target; k++) {
                    if (dp[i - 1][j][k] != Integer.MAX_VALUE) {
                        dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j][k]);
                        for (int l = 0; l < n; l++) {
                            if (l != j) {
                                dp[i][j][k + 1] = Math.min(dp[i][j][k + 1], dp[i - 1][l][k]);
                            }
                        }
                    }
                }
            }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n;
    }
}