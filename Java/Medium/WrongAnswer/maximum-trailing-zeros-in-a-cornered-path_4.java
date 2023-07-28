class Solution {
    public int maxTrailingZeros(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j][0] = dp[i][j][1] = countTrailingZeros(grid[i][j]);
                } else if (i == 0) {
                    dp[i][j][0] = countTrailingZeros(grid[i][j - 1] * grid[i][j]);
                    dp[i][j][1] = countTrailingZeros(grid[i][j]);
                } else if (j == 0) {
                    dp[i][j][0] = countTrailingZeros(grid[i][j]);
                    dp[i][j][1] = countTrailingZeros(grid[i - 1][j] * grid[i][j]);
                } else {
                    dp[i][j][0] = Math.max(countTrailingZeros(grid[i][j - 1] * grid[i][j]) + dp[i][j - 1][0], countTrailingZeros(grid[i][j]) + dp[i][j - 1][1]);
                    dp[i][j][1] = Math.max(countTrailingZeros(grid[i - 1][j] * grid[i][j]) + dp[i - 1][j][1], countTrailingZeros(grid[i][j]) + dp[i - 1][j][0]);
                }
            }
        }
        return Math.max(dp[m - 1][n - 1][0], dp[m - 1][n - 1][1]);
    }
    
    private int countTrailingZeros(int x) {
        int res = 0;
        while (x % 10 == 0) {
            res++;
            x /= 10;
        }
        return res;
    }
}