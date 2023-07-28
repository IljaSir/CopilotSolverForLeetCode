class Solution {
    public int maxTrailingZeros(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][2];
        dp[0][0][0] = dp[0][0][1] = trailingZeros(grid[0][0]);
        for (int i = 1; i < m; i++) {
            dp[i][0][0] = trailingZeros(grid[i][0]);
            dp[i][0][1] = trailingZeros(grid[i][0] * grid[i - 1][0]);
        }
        for (int j = 1; j < n; j++) {
            dp[0][j][0] = trailingZeros(grid[0][j] * grid[0][j - 1]);
            dp[0][j][1] = trailingZeros(grid[0][j]);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i][j - 1][0]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i][j - 1][1]);
                dp[i][j][0] = Math.max(dp[i][j][0], trailingZeros(grid[i][j]) + dp[i - 1][j][1]);
                dp[i][j][0] = Math.max(dp[i][j][0], trailingZeros(grid[i][j]) + dp[i][j - 1][1]);
                dp[i][j][1] = Math.max(dp[i][j][1], trailingZeros(grid[i][j] * grid[i - 1][j]) + dp[i - 1][j][0]);
                dp[i][j][1] = Math.max(dp[i][j][1], trailingZeros(grid[i][j] * grid[i][j - 1]) + dp[i][j - 1][0]);
            }
        }
        return Math.max(dp[m - 1][n - 1][0], dp[m - 1][n - 1][1]);
    }
}