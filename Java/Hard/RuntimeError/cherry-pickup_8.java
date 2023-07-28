class Solution {
    public int cherryPickup(int[][] grid) {
        
        int n = grid.length;
        int[][][] dp = new int[n + 1][n + 1][n + 1];
        for (int[][] d : dp) {
            for (int[] dd : d) {
                Arrays.fill(dd, Integer.MIN_VALUE);
            }
        }
        dp[0][0][0] = grid[0][0];
        for (int t = 1; t <= 2 * n - 2; ++t) {
            for (int i1 = Math.max(0, t - n + 1); i1 <= Math.min(n - 1, t); ++i1) {
                for (int i2 = Math.max(0, t - n + 1); i2 <= Math.min(n - 1, t); ++i2) {
                    if (grid[i1][t - i1] == -1 || grid[i2][t - i2] == -1) {
                        dp[i1 + 1][i2 + 1][t] = -1;
                        continue;
                    }
                    int val = grid[i1][t - i1];
                    if (i1 != i2) {
                        val += grid[i2][t - i2];
                    }
                    for (int p1 = i1; p1 <= i1 + 1; ++p1) {
                        for (int p2 = i2; p2 <= i2 + 1; ++p2) {
                            dp[i1 + 1][i2 + 1][t] = Math.max(dp[i1 + 1][i2 + 1][t], dp[p1][p2][t - 1] + val);
                        }
                    }
                }
            }
        }
        return Math.max(0, dp[n][n][2 * n - 2]);
    }
}