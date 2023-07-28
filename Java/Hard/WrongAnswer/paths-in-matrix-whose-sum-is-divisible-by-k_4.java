class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        
        int m = grid.length, n = grid[0].length;
        int[][][] dp = new int[m][n][k];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < k; l++) {
                    dp[i][j][l] = -1;
                }
            }
        }
        return numberOfPaths(grid, m, n, k, 0, 0, 0, dp);
    }
    private int numberOfPaths(int[][] grid, int m, int n, int k, int i, int j, int sum, int[][][] dp) {
        if (i >= m || j >= n) return 0;
        sum += grid[i][j];
        if (i == m - 1 && j == n - 1) {
            return sum % k == 0 ? 1 : 0;
        }
        if (dp[i][j][sum % k] != -1) return dp[i][j][sum % k];
        int res = numberOfPaths(grid, m, n, k, i + 1, j, sum, dp) + numberOfPaths(grid, m, n, k, i, j + 1, sum, dp);
        dp[i][j][sum % k] = res;
        return res;
    }
}