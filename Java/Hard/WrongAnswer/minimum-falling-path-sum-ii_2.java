class Solution {
    public int minFallingPathSum(int[][] grid) {
        
        int n = grid.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[0][j] = grid[0][j];
            }
            for (int j = 1; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (k == j) {
                        continue;
                    }
                    dp[j][k] = Math.min(dp[j][k], dp[j-1][j] + grid[j][k]);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[n-1][i]);
        }
        return ans;
    }
}