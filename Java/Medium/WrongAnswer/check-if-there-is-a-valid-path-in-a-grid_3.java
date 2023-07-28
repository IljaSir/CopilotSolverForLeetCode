class Solution {
    public boolean hasValidPath(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs(grid, 0, 0, visited);
    }
    
    public boolean dfs(int[][] grid, int i, int j, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        }
        if (i == m - 1 && j == n - 1) {
            return true;
        }
        if (visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        int cur = grid[i][j];
        if (cur == 1) {
            return dfs(grid, i, j - 1, visited) || dfs(grid, i, j + 1, visited);
        } else if (cur == 2) {
            return dfs(grid, i - 1, j, visited) || dfs(grid, i + 1, j, visited);
        } else if (cur == 3) {
            return dfs(grid, i, j - 1, visited) || dfs(grid, i + 1, j, visited);
        } else if (cur == 4) {
            return dfs(grid, i, j + 1, visited) || dfs(grid, i + 1, j, visited);
        } else if (cur == 5) {
            return dfs(grid, i, j - 1, visited) || dfs(grid, i - 1, j, visited);
        } else if (cur == 6) {
            return dfs(grid, i, j + 1, visited) || dfs(grid, i - 1, j, visited);
        }
        return false;
    }
}