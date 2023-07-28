class Solution {
    public int countPaths(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result = (result + dfs(grid, i, j, dp)) % 1000000007;
            }
        }
        return result;
    }
    
    private int dfs(int[][] grid, int i, int j, int[][] dp) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int result = 1;
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] > grid[i][j]) {
                result = (result + dfs(grid, x, y, dp)) % 1000000007;
            }
        }
        dp[i][j] = result;
        return result;
    }
}