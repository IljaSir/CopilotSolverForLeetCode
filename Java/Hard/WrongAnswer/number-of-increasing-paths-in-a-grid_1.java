class Solution {
    public int countPaths(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        int mod = 1000000007;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 1;
                if (i > 0 && grid[i - 1][j] < grid[i][j]) {
                    dp[i][j] += dp[i - 1][j];
                    dp[i][j] %= mod;
                }
                if (j > 0 && grid[i][j - 1] < grid[i][j]) {
                    dp[i][j] += dp[i][j - 1];
                    dp[i][j] %= mod;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result += dp[i][j];
                result %= mod;
            }
        }
        return result;
    }
}