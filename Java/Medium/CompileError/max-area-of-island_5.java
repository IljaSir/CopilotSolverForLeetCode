class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (intj = 0; j < grid[0].length; j++) {
                if (grid[i][j] ==  {
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }
        return max
        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
            area += dfs(grid, i - 1, j);
        }
        if (j + 1 < grid[i].length && grid[i][j + 1] == 1) {
            area += dfs(grid, i, j + 1);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
            area += dfs(grid, i, j - 1);
        }
        return area;
    }
}