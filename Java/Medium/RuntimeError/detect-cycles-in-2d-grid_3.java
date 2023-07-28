class Solution {
    public boolean containsCycle(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && dfs(grid, i, j, visited, -1, -1)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] grid, int i, int j, boolean[][] visited, int pi, int pj) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j]) {
            return false;
        }
        if (grid[i][j] != grid[pi][pj]) {
            return false;
        }
        visited[i][j] = true;
        if (dfs(grid, i - 1, j, visited, i, j) || dfs(grid, i + 1, j, visited, i, j) || dfs(grid, i, j - 1, visited, i, j) || dfs(grid, i, j + 1, visited, i, j)) {
            return true;
        }
        return false;
    }
}