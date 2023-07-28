class Solution {
    public boolean containsCycle(char[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (dfs(grid, visited, i, j, -1, -1, grid[i][j])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] grid, boolean[][] visited, int i, int j, int pi, int pj, char c) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != c) {
            return false;
        }
        if (visited[i][j]) {
            return true;
        }
        visited[i][j] = true;
        boolean flag = dfs(grid, visited, i + 1, j, i, j, c) || dfs(grid, visited, i - 1, j, i, j, c) || dfs(grid, visited, i, j + 1, i, j, c) || dfs(grid, visited, i, j - 1, i, j, c);
        visited[i][j] = false;
        return flag;
    }
}