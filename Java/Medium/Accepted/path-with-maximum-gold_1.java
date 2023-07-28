class Solution {
    public int getMaximumGold(int[][] grid) {
        
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }
        return max;
    }
    
    private int dfs(int[][] grid, int i, int j) {
        int val = grid[i][j];
        grid[i][j] = 0;
        int max = 0;
        if (i > 0 && grid[i-1][j] != 0) {
            max = Math.max(max, dfs(grid, i-1, j));
        }
        if (j > 0 && grid[i][j-1] != 0) {
            max = Math.max(max, dfs(grid, i, j-1));
        }
        if (i < grid.length-1 && grid[i+1][j] != 0) {
            max = Math.max(max, dfs(grid, i+1, j));
        }
        if (j < grid[i].length-1 && grid[i][j+1] != 0) {
            max = Math.max(max, dfs(grid, i, j+1));
        }
        grid[i][j] = val;
        return val + max;
    }
}