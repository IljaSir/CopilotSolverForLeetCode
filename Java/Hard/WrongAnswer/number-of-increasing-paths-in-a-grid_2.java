class Solution {
    public int countPaths(int[][] grid) {
        
        int mod = 1_000_000_007;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 1;
                for (int k = 0; k < i; k++) {
                    if (grid[k][j] < grid[i][j]) {
                        dp[i][j] = (dp[i][j] + dp[k][j]) % mod;
                    }
                }
                for (int k = 0; k < j; k++) {
                    if (grid[i][k] < grid[i][j]) {
                        dp[i][j] = (dp[i][j] + dp[i][k]) % mod;
                    }
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