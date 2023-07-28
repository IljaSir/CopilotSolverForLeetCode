class Solution {
    public boolean hasValidPath(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        return dfs(grid, 0, 0, visited);
    }
    boolean dfs(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return true;
        }
        int type = grid[i][j];
        if (type == 1) {
            return dfs(grid, i, j + 1, visited) || dfs(grid, i, j - 1, visited);
        }
        if (type == 2) {
            return dfs(grid, i + 1, j, visited) || dfs(grid, i - 1, j, visited);
        }
        if (type == 3) {
            return dfs(grid, i, j - 1, visited) || dfs(grid, i + 1, j, visited);
        }
        if (type == 4) {
            return dfs(grid, i, j + 1, visited) || dfs(grid, i + 1, j, visited);
        }
        if (type == 5) {
            return dfs(grid, i, j - 1, visited) || dfs(grid, i - 1, j, visited);
        }
        if (type == 6) {
            return dfs(grid, i, j + 1, visited) || dfs(grid, i - 1, j, visited);
        }
        return false;
    }
}