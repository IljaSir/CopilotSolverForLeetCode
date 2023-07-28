class Solution {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[] result = new int[hits.length];
        for (int i = 0; i < hits.length; i++) {
            int x = hits[i][0];
            int y = hits[i][1];
            if (grid[x][y] == 1) {
                grid[x][y] = 2;
            }
        }
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 1) {
                dfs(grid, 0, i);
            }
        }
        for (int i = hits.length - 1; i >= 0; i--) {
            int x = hits[i][0];
            int y = hits[i][1];
            if (grid[x][y] == 2) {
                grid[x][y] = 1;
                if (canFall(grid, x, y)) {
                    result[i] = dfs(grid, x, y) - 1;
                }
            }
        }
        return result;
    }
    
    private int dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1) {
            return 0;
        }
        int result = 1;
        grid[x][y] = 3;
        result += dfs(grid, x - 1, y);
        result += dfs(grid, x + 1, y);
        result += dfs(grid, x, y - 1);
        result += dfs(grid, x, y + 1);
        return result;
    }
    
    private boolean canFall(int[][] grid, int x, int y) {
        if (x == 0) {
            return true;
        }
        if (x > 0 && grid[x - 1][y] == 3) {
            return true;
        }
        if (x < grid.length - 1 && grid[x + 1][y] == 3) {
            return true;
        }
        if (y > 0 && grid[x][y - 1] == 3) {
            return true;
        }
        if (y < grid[0].length - 1 && grid
    }
}