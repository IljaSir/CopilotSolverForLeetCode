class Solution {
    public int minFallingPathSum(int[][] grid) {
        
        int n = grid.length;
        int[][] dp = new int[n+1][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (k == j) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][k]);
                }
                dp[i][j] += grid[i-1][j];
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[n][i]);
        }
        return ans;
    }
}