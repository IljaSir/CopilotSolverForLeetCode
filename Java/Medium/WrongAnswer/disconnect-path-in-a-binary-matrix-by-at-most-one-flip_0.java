class Solution {
    public boolean isPossibleToCutPath(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 2; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return dfs(grid, 0, 0, 0, dp) == 1;
    }

    private int dfs(int[][] grid, int i, int j, int k, int[][][] dp) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return 1;
        }
        if (i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        if (dp[i][j][k] != -1) {
            return dp[i][j][k];
        }
        int ans = 0;
        if (k == 0) {
            ans = Math.max(dfs(grid, i + 1, j, 1, dp), dfs(grid, i, j + 1, 1, dp));
        } else {
            ans = Math.max(dfs(grid, i + 1, j, 1, dp), dfs(grid, i, j + 1, 1, dp));
            ans = Math.max(ans, Math.max(dfs(grid, i + 1, j, 0, dp), dfs(grid, i, j + 1, 0, dp)));
        }
        dp[i][j][k] = ans;
        return ans;
    }
}