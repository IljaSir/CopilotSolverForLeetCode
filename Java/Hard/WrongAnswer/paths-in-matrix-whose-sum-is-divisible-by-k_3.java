class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][k];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < k; l++) {
                    dp[i][j][l] = -1;
                }
            }
        }
        return dfs(grid, 0, 0, k, dp);
    }

    private int dfs(int[][] grid, int i, int j, int k, int[][][] dp) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j] % k == 0 ? 1 : 0;
        }
        if (dp[i][j][grid[i][j] % k] != -1) {
            return dp[i][j][grid[i][j] % k];
        }
        int res = 0;
        if (i < grid.length - 1) {
            res += dfs(grid, i + 1, j, k, dp);
        }
        if (j < grid[0].length - 1) {
            res += dfs(grid, i, j + 1, k, dp);
        }
        res %= 1000000007;
        dp[i][j][grid[i][j] % k] = res;
        return res;
    }
}