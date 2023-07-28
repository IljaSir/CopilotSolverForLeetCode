class Solution {
    public int uniquePathsIII(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int startI = 0, startJ = 0;
        int endI = 0, endJ = 0;
        int total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    startI = i;
                    startJ = j;
                } else if (grid[i][j] == 2) {
                    endI = i;
                    endJ = j;
                } else if (grid[i][j] == 0) {
                    total++;
                }
            }
        }
        return dfs(grid, startI, startJ, endI, endJ, total);
    }
    private int dfs(int[][] grid, int i, int j, int endI, int endJ, int total) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == -1) {
            return 0;
        }
        if (i == endI && j == endJ) {
            return total == 0 ? 1 : 0;
        }
        grid[i][j] = -1;
        int result = dfs(grid, i + 1, j, endI, endJ, total - 1)
            + dfs(grid, i - 1, j, endI, endJ, total - 1)
            + dfs(grid, i, j + 1, endI, endJ, total - 1)
            + dfs(grid, i, j - 1, endI, endJ, total - 1);
        grid[i][j] = 0;
        return result;
    }
}