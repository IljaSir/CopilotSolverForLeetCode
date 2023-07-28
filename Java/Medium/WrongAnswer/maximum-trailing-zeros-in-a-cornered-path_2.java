class Solution {
    public int maxTrailingZeros(int[][] grid) {
        
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
        return Math.min(dfs(grid, 0, 0, 0, dp), dfs(grid, 0, 0, 1, dp));
    }
    private int dfs(int[][] grid, int i, int j, int dir, int[][][] dp) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if (dp[i][j][dir] != -1) {
            return dp[i][j][dir];
        }
        int res = 0;
        if (dir == 0) {
            res = Math.min(dfs(grid, i, j + 1, 0, dp), dfs(grid, i + 1, j, 1, dp));
        } else {
            res = Math.min(dfs(grid, i, j - 1, 1, dp), dfs(grid, i + 1, j, 0, dp));
        }
        if (res == Integer.MAX_VALUE) {
            res = 0;
        }
        int cnt = 0;
        int val = grid[i][j];
        while (val % 5 == 0) {
            cnt++;
            val /= 5;
        }
        dp[i][j][dir] = res + cnt;
        return res + cnt;
    }
}