class Solution {
    public int cherryPickup(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        int[][][] dp = new int[rows][cols][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < cols; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        dp[0][0][cols - 1] = grid[0][0] + (cols - 1 == 0 ? 0 : grid[0][cols - 1]);
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < cols; k++) {
                    for (int j1 = j - 1; j1 <= j + 1; j1++) {
                        for (int k1 = k - 1; k1 <= k + 1; k1++) {
                            if (j1 >= 0 && j1 < cols && k1 >= 0 && k1 < cols) {
                                dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j1][k1]);
                            }
                        }
                    }
                    if (dp[i][j][k] >= 0) {
                        dp[i][j][k] += grid[i][j] + (j == k ? 0 : grid[i][k]);
                    }
                }
            }
        }
        int res = 0;
        for (int j = 0; j < cols; j++) {
            for (int k = 0; k < cols; k++) {
                res = Math.max(res, dp[rows - 1][j][k]);
            }
        }
        return res;
    }
}