class Solution {
    public int maxTrailingZeros(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = grid[i][j];
                dp[i][j][1] = grid[i][j];
                if (i > 0) {
                    dp[i][j][0] = Math.max(dp[i][j][0], dp[i - 1][j][0] * grid[i][j]);
                    dp[i][j][1] = Math.max(dp[i][j][1], dp[i - 1][j][1] * grid[i][j]);
                }
                if (j > 0) {
                    dp[i][j][0] = Math.max(dp[i][j][0], dp[i][j - 1][0] * grid[i][j]);
                    dp[i][j][1] = Math.max(dp[i][j][1], dp[i][j - 1][1] * grid[i][j]);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int a = dp[i][j][0];
                int b = dp[i][j][1];
                while (a % 2 == 0) {
                    a /= 2;
                    res++;
                }
                while (b % 5 == 0) {
                    b /= 5;
                    res++;
                }
            }
        }
        return res;
    }
}