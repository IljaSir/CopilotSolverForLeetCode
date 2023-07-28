class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], 1000000);
        }
        dp[0][0] = grid[0][0];
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    dp[i + 1][k] = Math.min(dp[i + 1][k], dp[i][j] + grid[i + 1][k] + moveCost[grid[i][j]][k]);
                }
            }
        }
        int ans = 1000000;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[m - 1][i]);
        }
        return ans;
    }
}