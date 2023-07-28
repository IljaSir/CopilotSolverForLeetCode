class Solution {
    public int uniquePathsIII(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int total = 0;
        int starti = 0;
        int startj = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    total++;
                } else if (grid[i][j] == 1) {
                    starti = i;
                    startj = j;
                }
            }
        }
        return dfs(grid, starti, startj, total);
    }

    public int dfs(int[][] grid, int i, int j, int total) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == -1) {
            return 0;
        }
        if (grid[i][j] == 2) {
            return total == 0 ? 1 : 0;
        }
        grid[i][j] = -1;
        int res = dfs(grid, i - 1, j, total - 1) + dfs(grid, i + 1, j, total - 1)
                + dfs(grid, i, j - 1, total - 1) + dfs(grid, i, j + 1, total - 1);
        grid[i][j] = 0;
        return res;
    }
}