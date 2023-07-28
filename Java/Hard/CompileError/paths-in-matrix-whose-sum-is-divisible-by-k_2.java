class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        
        int mod = 1000000007;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + grid[i][j];
            }
        }
        int[][][] cache = new int[m][n][k];
        return numberOfPaths(grid, dp, cache, m - 1, n - 1, k);
    }
    private int numberOfPaths(int[][] grid, int[][] dp, int[][][] cache, int i, int j, int k) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (cache[i][j][k] > 0) {
            return cache[i][j][k];
        }
        int mod = 1000000007;
        int result = 0;
        if (i == 0 && j == 0) {
            result = dp[i][j] % k == 0 ? 1 : 0;
        } else {
            int left = j == 0 ? 0 : dp[i][j - 1];
            int top = i == 0 ? 0 : dp[i - 1][j];
            int sum = dp[i][j] - left - top + grid[i][j];
            if (sum % k == 0) {
                result = (1 + numberOfPaths(grid, dp, cache, i - 1, j, k) + numberOfPaths(grid, dp, cache, i, j - 1, k)) % mod;
            } else {
                result = (numberOfPaths(grid, dp, cache, i -
    }
}