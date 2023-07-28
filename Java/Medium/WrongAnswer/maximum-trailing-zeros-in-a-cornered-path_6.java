class Solution {
    public int maxTrailingZeros(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = getTrailingZeros(grid[0][0]);
        for (int i = 1; i < m; i++) {
            dp[i][0] = getTrailingZeros(grid[i][0] * grid[i - 1][0]);
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = getTrailingZeros(grid[0][i] * grid[0][i - 1]);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + getTrailingZeros(grid[i][j]);
            }
        }
        return dp[m - 1][n - 1];
    }

    private int getTrailingZeros(int val) {
        int count = 0;
        while (val % 10 == 0) {
            count++;
            val /= 10;
        }
        return count;
    }
}