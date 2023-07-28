class Solution {
    public int cherryPickup(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        dp[0][0][n - 1] = grid[0][0] + grid[0][n - 1];
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (dp[i - 1][j][k] == -1) {
                        continue;
                    }
                    for (int d1 = -1; d1 <= 1; d1++) {
                        for (int d2 = -1; d2 <= 1; d2++) {
                            int x1 = j + d1;
                            int x2 = k + d2;
                            if (x1 >= 0 && x1 < n && x2 >= 0 && x2 < n) {
                                dp[i][x1][x2] = Math.max(dp[i][x1][x2], dp[i - 1][j][k] + grid[i][x1] + (x1 == x2 ? 0 : grid[i][x2]));
                            }
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dp[m - 1][i][j]);
            }
        }
        return res;
    }
}