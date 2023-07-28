class Solution {
    public int countPaths(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        int mod = 1000000007;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 1;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && grid[i][j] < grid[i - 1][j]) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j]) % mod;
                }
                if (j > 0 && grid[i][j] < grid[i][j - 1]) {
                    dp[i][j] = (dp[i][j] + dp[i][j - 1]) % mod;
                }
                if (i < m - 1 && grid[i][j] < grid[i + 1][j]) {
                    dp[i][j] = (dp[i][j] + dp[i + 1][j]) % mod;
                }
                if (j < n - 1 && grid[i][j] < grid[i][j + 1]) {
                    dp[i][j] = (dp[i][j] + dp[i][j + 1]) % mod;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = (ans + dp[i][j]) % mod;
            }
        }
        return ans;
    }
}