class Solution {
    public int maxProductPath(int[][] grid) {
        
        int n = grid.length;
        long[][][] dp = new long[n][n][2];
        dp[0][0][0] = grid[0][0];
        dp[0][0][1] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i][0] = dp[0][i-1][0] * grid[0][i];
            dp[0][i][1] = dp[0][i-1][1] * grid[0][i];
            dp[i][0][0] = dp[i-1][0][0] * grid[i][0];
            dp[i][0][1] = dp[i-1][0][1] * grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j][0] = Math.min(Math.min(dp[i-1][j][0] * grid[i][j], dp[i][j-1][0] * grid[i][j]), Math.min(dp[i-1][j][1] * grid[i][j], dp[i][j-1][1] * grid[i][j]));
                dp[i][j][1] = Math.max(Math.max(dp[i-1][j][0] * grid[i][j], dp[i][j-1][0] * grid[i][j]), Math.max(dp[i-1][j][1] * grid[i][j], dp[i][j-1][1] * grid[i][j]));
            }
        }
        if (dp[n-1][n-1][1] < 0) return -1;
        return (int)(dp[n-1][n-1][1] % 1000000007);
    }
}