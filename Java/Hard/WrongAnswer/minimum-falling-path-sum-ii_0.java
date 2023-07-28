class Solution {
    public int minFallingPathSum(int[][] grid) {
        
        int n = grid.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = grid[i][j];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] += Math.min(dp[i - 1][j], Math.min(dp[i - 1][(j + 1) % n], dp[i - 1][(j - 1 + n) % n]));
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp[n - 1][i]);
        }
        return res;
    }
}