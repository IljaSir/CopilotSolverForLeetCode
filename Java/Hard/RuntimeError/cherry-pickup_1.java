class Solution {
    public int cherryPickup(int[][] grid) {
        
        int n = grid.length;
        int[][][] dp = new int[n][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }
        dp[0][0][0] = grid[0][0];
        for (int t = 1; t <= 2 * n - 2; t++) {
            for (int i = Math.max(0, t - (n - 1)); i <= Math.min(n - 1, t); i++) {
                for (int j = Math.max(0, t - (n - 1)); j <= Math.min(n - 1, t); j++) {
                    int pi = t - j;
                    int pj = t - i;
                    if (grid[i][pi] == -1 || grid[j][pj] == -1) {
                        continue;
                    }
                    int val = grid[i][pi];
                    if (i != j) {
                        val += grid[j][pj];
                    }
                    for (int p = i - 1; p <= i; p++) {
                        for (int q = j - 1; q <= j; q++) {
                            if (p >= 0 && q >= 0) {
                                dp[i][j][t] = Math.max(dp[i][j][t], dp[p][q][t - 1] + val);
                            }
                        }
                    }
                }
            }
        }
        return Math.max(0, dp[n - 1][n - 1][2 * n - 2]);
    }
}