class Solution {
    public int cherryPickup(int[][] grid) {
        
        int n = grid.length;
        int[][] dp = new int[n][n];
        dp[0][0] = grid[0][0];
        for (int t = 1; t < 2 * n - 1; ++t) {
            int[][] dp2 = new int[n][n];
            for (int i = 0; i < n; ++i) {
                for (int p = 0; p < n; ++p) {
                    int j = t - i, q = t - p;
                    if (j < 0 || j >= n || q < 0 || q >= n || grid[i][j] < 0 || grid[p][q] < 0) {
                        dp2[i][p] = -1;
                        continue;
                    }
                    if (i > 0) {
                        dp2[i][p] = Math.max(dp2[i][p], dp[i - 1][p]);
                    }
                    if (p > 0) {
                        dp2[i][p] = Math.max(dp2[i][p], dp[i][p - 1]);
                    }
                    if (i > 0 && p > 0) {
                        dp2[i][p] = Math.max(dp2[i][p], dp[i - 1][p - 1]);
                    }
                    if (dp2[i][p] >= 0) {
                        dp2[i][p] += grid[i][j];
                        if (i != p) {
                            dp2[i][p] += grid[p][q];
                        }
                    }
                }
            }
            dp = dp2;
        }
        return Math.max(dp[n - 1][n - 1], 0);
    }
}