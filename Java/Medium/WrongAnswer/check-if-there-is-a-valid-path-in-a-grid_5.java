class Solution {
    public boolean hasValidPath(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        return dfs(grid, 0, 0, visited);
    }

    private boolean dfs(int[][] grid, int i, int j, boolean[][] visited) {
        int n = grid.length;
        int m = grid[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m) return false;
        if (visited[i][j]) return false;
        visited[i][j] = true;
        if (i == n - 1 && j == m - 1) return true;
        if (grid[i][j] == 1) {
            return dfs(grid, i, j + 1, visited) || dfs(grid, i, j - 1, visited);
        } else if (grid[i][j] == 2) {
            return dfs(grid, i + 1, j, visited) || dfs(grid, i - 1, j, visited);
        } else if (grid[i][j] == 3) {
            return dfs(grid, i, j - 1, visited) || dfs(grid, i + 1, j, visited);
        } else if (grid[i][j] == 4) {
            return dfs(grid, i, j + 1, visited) || dfs(grid, i + 1, j, visited);
        } else if (grid[i][j] == 5) {
            return dfs(grid, i, j - 1, visited) || dfs(grid, i - 1, j, visited);
        } else if (grid[i][j] == 6) {
            return dfs(grid, i, j + 1, visited) || dfs(grid, i - 1, j, visited);
        } else {
            return false;
        }
    }
}