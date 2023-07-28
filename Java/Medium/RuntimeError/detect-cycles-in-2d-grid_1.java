class Solution {
    public boolean containsCycle(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (dfs(grid, visited, i, j, -1, -1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] grid, boolean[][] visited, int i, int j, int pi, int pj) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return false;
        }
        if (visited[i][j]) {
            return true;
        }
        if (grid[i][j] == grid[pi][pj]) {
            visited[i][j] = true;
            if (dfs(grid, visited, i + 1, j, i, j) || dfs(grid, visited, i - 1, j, i, j) || dfs(grid, visited, i, j + 1, i, j) || dfs(grid, visited, i, j - 1, i, j)) {
                return true;
            }
        }
        return false;
    }
}