class Solution {
    public int closedIsland(int[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                if (grid[i][j] == 0) {
                    if (dfs(grid, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    
    private boolean dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return false;
        }
        if (grid[i][j] == 1) {
            return true;
        }
        grid[i][j] = 1;
        return dfs(grid, i + 1, j) && dfs(grid, i - 1, j) && dfs(grid, i, j + 1) && dfs(grid, i, j - 1);
    }
}