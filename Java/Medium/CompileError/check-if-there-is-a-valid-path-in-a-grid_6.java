class Solution {
    public boolean hasValidPath(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, grid, visited);
    }
    
    private boolean dfs(int i, int j, int m, int n, int[][] grid, boolean[][] visited) {
        if (i == m - 1 && j == n - 1) {
            return true;
        }
        visited[i][j] = true;
        if (i > 0 && !visited[i - 1][j] && grid[i - 1][j] == 2 && grid[i][j] == 5) {
            if (dfs(i - 1, j, m, n, grid, visited)) {
                return true;
            }
        }
        if (j > 0 && !visited[i][j - 1] && grid[i][j - 1] == 1 && grid[i][j] == 3) {
            if (dfs(i, j - 1, m, n, grid, visited)) {
                return true;
            }
        }
        if (i < m - 1 && !visited[i + 1][j] && grid[i + 1][j] == 2 && grid[i][j] == 6) {
            if (dfs(i + 1, j, m, n, grid, visited)) {
                return true;
            }
        }
        if (j < n - 1 && !visited[i][j + 1] && grid[i][j + 1] == 1 && grid[i][j] == 4) {
            if (dfs(i, j + 1, m, n, grid, visited)) {
                return true;
            }
        }
        if (i > 0 && !visited[i - 1][j] && grid[i - 1][j] == 5 && grid[i][j] == 2) {
            if (dfs(i - 1, j, m, n, grid, visited)) {
                return true;
            }
        }
        if (j > 0 && !visited[i][j - 1] && grid[i][j - 1] == 3 && grid[i][j] == 1) {
            if (dfs(i, j - 1,
    }
}