class Solution {
    public int minFallingPathSum(int[][] grid) {
        
        int n = grid.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = grid[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    if (k == j) continue;
                    min = Math.min(min, dp[i - 1][k]);
                }
                dp[i][j] = min + grid[i][j];
            }
        }
        int ans = dp[n - 1][0];
        for (int i = 1; i < n; i++) {
            ans = Math.min(ans, dp[n - 1][i]);
        }
        return ans;
    }
}