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
                    if (j > i || k > i || n - 1 - j > i || n - 1 - k > i) continue;
                    int max = -1;
                    for (int p = j - 1; p <= j + 1; p++) {
                        for (int q = k - 1; q <= k + 1; q++) {
                            if (p < 0 || q < 0 || p >= n || q >= n) continue;
                            max = Math.max(max, dp[i - 1][p][q]);
                        }
                    }
                    if (max >= 0) {
                        dp[i][j][k] = max + grid[i][j] + grid[i][k];
                        if (j == k) dp[i][j][k] -= grid[i][j];
                    }
                }
            }
        }
        int res = 0;
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                res = Math.max(res, dp[m - 1][j][k]);
            }
        }
        return res;
    }
}