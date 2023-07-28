class Solution {
    public int cherryPickup(int[][] grid) {
        
        int n = grid.length;
        int[][][] dp = new int[n][n][n];
        for (int[][] d : dp) {
            for (int[] d1 : d) {
                Arrays.fill(d1, Integer.MIN_VALUE);
            }
        }
        dp[0][0][0] = grid[0][0];
        for (int t = 1; t <= 2 * n - 2; ++t) {
            for (int i = Math.min(n - 1, t); i >= 0; --i) {
                for (int p = Math.min(n - 1, t); p >= 0; --p) {
                    int j = t - i, q = t - p;
                    if (j < 0 || j >= n || q < 0 || q >= n || grid[i][j] == -1 || grid[p][q] == -1) {
                        dp[i][p][t] = -1;
                        continue;
                    }
                    if (i > 0) dp[i][p][t] = Math.max(dp[i][p][t], dp[i - 1][p][t - 1]);
                    if (p > 0) dp[i][p][t] = Math.max(dp[i][p][t], dp[i][p - 1][t - 1]);
                    if (i > 0 && p > 0) dp[i][p][t] = Math.max(dp[i][p][t], dp[i - 1][p - 1][t - 1]);
                    if (dp[i][p][t] >= 0) dp[i][p][t] += grid[i][j] + (i != p ? grid[p][q] : 0);
                }
            }
        }
        return Math.max(dp[n - 1][n - 1][2 * n - 2], 0);
    }
}