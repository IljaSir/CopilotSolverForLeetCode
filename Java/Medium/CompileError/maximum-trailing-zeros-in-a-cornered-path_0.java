class Solution {
    public int maxTrailingZeros(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][2];
        dp[0][0][0] = dp[0][0][1] = 0;
        int max = 0;
        for (int i = 1; i < m; i++) {
            dp[i][0][0] = dp[i - 1][0][0];
            while (grid[i][0] % 2 == 0) {
                grid[i][0] /= 2;
                dp[i][0][0] += 1;
            }
            dp[i][0][1] = dp[i - 1][0][1];
            while (grid[i][0] % 5 == 0) {
                grid[i][0] /= 5;
                dp[i][0][1] += 1;
            }
        }
        for (int i = 1; i < n; i++) {
            dp[0][i][0] = dp[0][i - 1][0];
            while (grid[0][i] % 2 == 0) {
                grid[0][i] /= 2;
                dp[0][i][0] += 1;
            }
            dp[0][i][1] = dp[0][i - 1][1];
            while (grid[0][i] % 5 == 0) {
                grid[0][i] /= 5;
                dp[0][i][1] += 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j][0] = Math.min(dp[i - 1][j][0], dp[i][j - 1][0]);
                while (grid[i][j] % 2 == 0) {
                    grid[i][j] /= 2;
                    dp[i][j][0] += 1;
                }
                dp[i][j][1] = Math.min(dp[i - 1][j][1], dp[i][j - 1][1]);
                while (grid[i][j] % 5 == 0) {
                    grid[i][j] /=
    }
}