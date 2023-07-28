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
                if (grid[i][j] == 0) {
                    if (j + 1 < n && grid[i][j + 1] == 0) {
                        if (i + 1 < n && grid[i + 1][j] == 0 && grid[i + 1][j + 1] == 0) {
                            dp[i + 1][j][0] = Math.min(dp[i + 1][j][0], dp[i][j][0] + 1);
                            dp[i][j + 1][0] = Math.min(dp[i][j + 1][0], dp[i][j][0] + 1);
                            dp[i + 1][j][1] = Math.min(dp[i + 1][j][1], dp[i][j][0] + 1);
                        }
                        dp[i][j + 1][0] = Math.min(dp[i][j + 1][0], dp[i][j][1] + 1);
                    }
                    if (i + 1 < n && grid[i + 1][j] == 0) {
                        if (j + 1 < n && grid[i][j + 1] == 0 && grid[i + 1][j + 1] == 0) {
                            dp[i][j + 1][1] = Math.min(dp[i][j + 1][1], dp[i][j][1] + 1);
                            dp[i + 1][j][1] = Math.min(dp[i + 1][j][1], dp[i][j][1] + 1);
                            dp[i][j + 1][0] = Math.min(dp[i][j + 1][0], dp[i][
    }
}