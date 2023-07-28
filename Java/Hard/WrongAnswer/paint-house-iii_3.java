class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        
        int[][][] dp = new int[m][n][target];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < target; k++) {
                    if (houses[i] != 0 && houses[i] - 1 != j) {
                        continue;
                    }
                    int costHouse = houses[i] == 0 ? cost[i][j] : 0;
                    if (i == 0) {
                        if (k == 0) {
                            dp[i][j][k] = costHouse;
                        }
                    } else {
                        for (int j0 = 0; j0 < n; j0++) {
                            for (int k0 = 0; k0 < target; k0++) {
                                if (j == j0 && k == k0) {
                                    dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j0][k0] + costHouse);
                                } else if (j != j0 && k == k0 + 1) {
                                    dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j0][k0] + costHouse);
                                }
                            }
                        }
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[m - 1][j][target - 1]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}