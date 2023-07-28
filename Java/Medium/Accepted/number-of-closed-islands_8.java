class Solution {
    public int closedIsland(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for(int i = 1; i < n - 1; i++) {
            for(int j = 1; j < m - 1; j++) {
                if(grid[i][j] == 0) {
                    if(dfs(grid, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    
    public boolean dfs(int[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return false;
        }
        if(grid[i][j] == 1) {
            return true;
        }
        grid[i][j] = 1;
        boolean up = dfs(grid, i - 1, j);
        boolean down = dfs(grid, i + 1, j);
        boolean left = dfs(grid, i, j - 1);
        boolean right = dfs(grid, i, j + 1);
        return up && down && left && right;
    }
}