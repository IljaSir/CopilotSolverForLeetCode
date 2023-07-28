class Solution {
    public boolean containsCycle(char[][] grid) {
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (dfs(grid, i, j, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] grid, int i, int j, int pi, int pj, int count) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != grid[pi][pj]) {
            return false;
        }
        if (count >= 4) {
            return true;
        }
        char temp = grid[i][j];
        grid[i][j] = '0';
        boolean res = dfs(grid, i + 1, j, i, j, count + 1) ||
            dfs(grid, i - 1, j, i, j, count + 1) ||
            dfs(grid, i, j + 1, i, j, count + 1) ||
            dfs(grid, i, j - 1, i, j, count + 1);
        grid[i][j] = temp;
        return res;
    }
}