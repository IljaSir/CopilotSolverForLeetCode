class Solution {
    public boolean hasValidPath(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs(grid, 0, 0, visited);
    }
    
    private boolean dfs(int[][] grid, int x, int y, boolean[][] visited) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || visited[x][y]) {
            return false;
        }
        visited[x][y] = true;
        if (grid[x][y] == 1) {
            return dfs(grid, x, y - 1, visited) || dfs(grid, x, y + 1, visited);
        }
        if (grid[x][y] == 2) {
            return dfs(grid, x - 1, y, visited) || dfs(grid, x + 1, y, visited);
        }
        if (grid[x][y] == 3) {
            return dfs(grid, x, y - 1, visited) || dfs(grid, x + 1, y, visited);
        }
        if (grid[x][y] == 4) {
            return dfs(grid, x, y + 1, visited) || dfs(grid, x + 1, y, visited);
        }
        if (grid[x][y] == 5) {
            return dfs(grid, x, y - 1, visited) || dfs(grid, x - 1, y, visited);
        }
        if (grid[x][y] == 6) {
            return dfs(grid, x, y + 1, visited) || dfs(grid, x - 1, y, visited);
        }
        return false;
    }
}