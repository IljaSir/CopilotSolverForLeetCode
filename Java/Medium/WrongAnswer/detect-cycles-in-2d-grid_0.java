class Solution {
    public boolean containsCycle(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && dfs(grid, i, j, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] grid, int i, int j, int pi, int pj, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != grid[pi][pj]) {
            return false;
        }
        if (visited[i][j]) {
            return true;
        }
        visited[i][j] = true;
        return dfs(grid, i + 1, j, i, j, visited) || dfs(grid, i - 1, j, i, j, visited) || dfs(grid, i, j + 1, i, j, visited) || dfs(grid, i, j - 1, i, j, visited);
    }
}