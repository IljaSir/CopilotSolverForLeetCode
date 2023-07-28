class Solution {
    public boolean isPossibleToCutPath(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        dfs(grid, 0, 0, visited);
        if (visited[m - 1][n - 1]) {
            return false;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    visited = new boolean[m][n];
                    dfs(grid, 0, 0, visited);
                    if (!visited[m - 1][n - 1]) {
                        return true;
                    }
                    grid[i][j] = 1;
                }
            }
        }
        return false;
    }
    
    private void dfs(int[][] grid, int i, int j, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        dfs(grid, i + 1, j, visited);
        dfs(grid, i, j + 1, visited);
    }
}