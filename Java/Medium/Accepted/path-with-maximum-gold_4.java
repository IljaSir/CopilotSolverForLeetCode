class Solution {
    public int getMaximumGold(int[][] grid) {
        
        int maxGold = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    maxGold = Math.max(maxGold, dfs(grid, i, j));
                }
            }
        }
        return maxGold;
    }
    
    private int dfs(int[][] grid, int i, int j) {
        int maxGold = 0;
        int temp = grid[i][j];
        grid[i][j] = 0;
        if (i > 0 && grid[i - 1][j] != 0) {
            maxGold = Math.max(maxGold, dfs(grid, i - 1, j));
        }
        if (i < grid.length - 1 && grid[i + 1][j] != 0) {
            maxGold = Math.max(maxGold, dfs(grid, i + 1, j));
        }
        if (j > 0 && grid[i][j - 1] != 0) {
            maxGold = Math.max(maxGold, dfs(grid, i, j - 1));
        }
        if (j < grid[0].length - 1 && grid[i][j + 1] != 0) {
            maxGold = Math.max(maxGold, dfs(grid, i, j + 1));
        }
        grid[i][j] = temp;
        return maxGold + temp;
    }
}