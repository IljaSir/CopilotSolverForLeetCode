class Solution {
    public int closedIsland(int[][] grid) {
        
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    if (dfs(grid, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    
    public boolean dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return false;
        }
        if (grid[i][j] == 1) {
            return true;
        }
        grid[i][j] = 1;
        boolean left = dfs(grid, i - 1, j);
        boolean right = dfs(grid, i + 1, j);
        boolean top = dfs(grid, i, j - 1);
        boolean bottom = dfs(grid, i, j + 1);
        return left && right && top && bottom;
    }
}