class Solution {
    public int maxTrailingZeros(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][2];
        int[][][] dp2 = new int[m][n][2];
        int[][][] dp3 = new int[m][n][2];
        int[][][] dp4 = new int[m][n][2];
        dp[0][0][0] = dp[0][0][1] = dp2[0][0][0] = dp2[0][0][1] = dp3[0][0][0] = dp3[0][0][1] = dp4[0][0][0] = dp4[0][0][1] = 0;
        for (int i = 1; i < m; i++) {
            dp[i][0][0] = dp2[i][0][0] = dp3[i][0][0] = dp4[i][0][0] = dp[i - 1][0][0] + trailingZeros(grid[i - 1][0]);
            dp[i][0][1] = dp2[i][0][1] = dp3[i][0][1] = dp4[i][0][1] = dp[i - 1][0][1] + trailingZeros(grid[i - 1][0]);
        }
        for (int i = 1; i < n; i++) {
            dp[0][i][0] = dp2[0][i][0] = dp3[0][i][0] = dp4[0][i][0] = dp[0][i - 1][0] + trailingZeros(grid[0][i - 1]);
            dp[0][i][1] = dp2[0][i][1] = dp3[0][i][1] = dp4[0][i][1] = dp[0][i - 1][1] + trailingZeros(grid[0][i - 1]);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i][j - 1][
    }
}