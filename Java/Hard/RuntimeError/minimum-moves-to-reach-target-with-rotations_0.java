class Solution {
    public int minimumMoves(int[][] grid) {
        
        int n = grid.length;
        int[][][] dp = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = dp[i][j][1] = Integer.MAX_VALUE;
            }
        }
        dp[0][0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 || grid[i][j + 1] == 1) {
                    dp[i][j][0] = dp[i][j][1] = Integer.MAX_VALUE;
                }
                if (i > 0) {
                    dp[i][j][0] = Math.min(dp[i][j][0], dp[i - 1][j][0] + 1);
                    dp[i][j][1] = Math.min(dp[i][j][1], dp[i - 1][j][1] + 1);
                }
                if (j > 0) {
                    dp[i][j][0] = Math.min(dp[i][j][0], dp[i][j - 1][0] + 1);
                    dp[i][j][1] = Math.min(dp[i][j][1], dp[i][j - 1][1] + 1);
                }
                if (i > 0 && j > 0 && grid[i - 1][j] == 0 && grid[i][j - 1] == 0) {
                    dp[i][j][0] = Math.min(dp[i][j][0], dp[i - 1][j - 1][1] + 1);
                    dp[i][j][1] = Math.min(dp[i][j][1], dp[i - 1][j - 1][0] + 1);
                }
            }
        }
        return Math.min(dp[n - 1][n - 2][0], dp[n - 2][n - 1][1]);
    }
}