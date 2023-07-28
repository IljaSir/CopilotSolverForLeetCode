class Solution {
    public boolean hasValidPath(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs(grid, 0, 0, visited);
    }
    
    private boolean dfs(int[][] grid, int i, int j, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) return false;
        visited[i][j] = true;
        if (i == m - 1 && j == n - 1) return true;
        int val = grid[i][j];
        if (val == 1) {
            return dfs(grid, i, j + 1, visited) || dfs(grid, i, j - 1, visited);
        } else if (val == 2) {
            return dfs(grid, i + 1, j, visited) || dfs(grid, i - 1, j, visited);
        } else if (val == 3) {
            return dfs(grid, i, j - 1, visited) || dfs(grid, i + 1, j, visited);
        } else if (val == 4) {
            return dfs(grid, i, j + 1, visited) || dfs(grid, i + 1, j, visited);
        } else if (val == 5) {
            return dfs(grid, i, j - 1, visited) || dfs(grid, i - 1, j, visited);
        } else {
            return dfs(grid, i, j + 1, visited) || dfs(grid, i - 1, j, visited);
        }
    }
}