class Solution {
    public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
        
        int[][] grid = new int[m][n];
        int[][][] memo = new int[m][n][1 << (m * n)];
        return dfs(grid, 0, 0, introvertsCount, extrovertsCount, memo);
    }
    
    private int dfs(int[][] grid, int i, int j, int introvertsCount, int extrovertsCount, int[][][] memo) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        if (introvertsCount == 0 && extrovertsCount == 0) {
            return 0;
        }
        if (memo[i][j][introvertsCount | (extrovertsCount << 6)] != 0) {
            return memo[i][j][introvertsCount | (extrovertsCount << 6)];
        }
        if (i == m) {
            return dfs(grid, 0, j + 1, introvertsCount, extrovertsCount, memo);
        }
        if (grid[i][j] == 0) {
            if (introvertsCount > 0) {
                grid[i][j] = 1;
                max = Math.max(max, dfs(grid, i + 1, j, introvertsCount - 1, extrovertsCount, memo) + getHappiness(grid, i, j));
                grid[i][j] = 0;
            }
            if (extrovertsCount > 0) {
                grid[i][j] = 2;
                max = Math.max(max, dfs(grid, i + 1, j, introvertsCount, extrovertsCount - 1, memo) + getHappiness(grid, i, j));
                grid[i][j] = 0;
            }
        }
        return memo[i][j][introvertsCount | (extrovertsCount << 6)] = Math.max(max, dfs(grid, i + 1, j, introvertsCount, extrovertsCount, memo));
    }
}