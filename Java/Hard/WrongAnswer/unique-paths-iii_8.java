class Solution {
    public int uniquePathsIII(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][1 << m * n];
        return dfs(grid, 0, 0, 0, dp);
    }
    private int dfs(int[][] grid, int x, int y, int mask, int[][][] dp) {
        int m = grid.length;
        int n = grid[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == -1) {
            return 0;
        }
        if (grid[x][y] == 2) {
            return mask == (1 << m * n) - 1 ? 1 : 0;
        }
        if (dp[x][y][mask] != 0) {
            return dp[x][y][mask];
        }
        grid[x][y] = -1;
        dp[x][y][mask] = dfs(grid, x + 1, y, mask | (1 << (x * n + y)), dp)
            + dfs(grid, x - 1, y, mask | (1 << (x * n + y)), dp)
            + dfs(grid, x, y + 1, mask | (1 << (x * n + y)), dp)
            + dfs(grid, x, y - 1, mask | (1 << (x * n + y)), dp);
        grid[x][y] = 0;
        return dp[x][y][mask];
    }
}