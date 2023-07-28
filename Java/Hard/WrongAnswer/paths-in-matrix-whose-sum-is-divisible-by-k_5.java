class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        
        int m = grid.length;
        int n = grid[0].length;
        int mod = 1000000007;
        long[][][] dp = new long[m][n][k];
        dp[0][0][grid[0][0] % k] = 1;
        for (int i = 1; i < m; i++) {
            dp[i][0][grid[i][0] % k] = dp[i - 1][0][grid[i][0] % k] + 1;
        }
        for (int i = 1; i < n; i++) {
            dp[0][i][grid[0][i] % k] = dp[0][i - 1][grid[0][i] % k] + 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                for (int r = 0; r < k; r++) {
                    dp[i][j][r] = (dp[i - 1][j][(r - grid[i][j] % k + k) % k] + dp[i][j - 1][(r - grid[i][j] % k + k) % k]) % mod;
                }
            }
        }
        return (int) dp[m - 1][n - 1][0];
    }
}