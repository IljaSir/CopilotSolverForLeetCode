class Solution {
    public int maxTrailingZeros(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[2][m][n];
        int[][][] dp2 = new int[2][m][n];
        int[][][] dp3 = new int[2][m][n];
        int[][][] dp4 = new int[2][m][n];
        dp[0][0][0] = grid[0][0];
        dp2[0][0][0] = grid[0][0];
        dp3[0][0][0] = grid[0][0];
        dp4[0][0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[0][i][0] = dp[0][i - 1][0] * grid[i][0];
            dp2[0][i][0] = dp2[0][i - 1][0] * grid[i][0];
            dp3[0][i][0] = dp3[0][i - 1][0] * grid[i][0];
            dp4[0][i][0] = dp4[0][i - 1][0] * grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][0][i] = dp[0][0][i - 1] * grid[0][i];
            dp2[0][0][i] = dp2[0][0][i - 1] * grid[0][i];
            dp3[0][0][i] = dp3[0][0][i - 1] * grid[0][i];
            dp4[0][0][i] = dp4[0][0][i - 1] * grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[0][i][j] = Math.max(dp[0][i - 1][j], dp[0][i][j - 1]) * grid[i][j];
                dp2[0][i][j] = Math
    }
}