class Solution {
    public boolean containsCycle(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && dfs(grid, visited, i, j, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] grid, boolean[][] visited, int i, int j, int pi, int pj, int cnt) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != grid[pi][pj]) {
            return false;
        }
        if (visited[i][j]) {
            return cnt >= 4;
        }
        visited[i][j] = true;
        if (dfs(grid, visited, i + 1, j, i, j, cnt + 1)
            || dfs(grid, visited, i - 1, j, i, j, cnt + 1)
            || dfs(grid, visited, i, j + 1, i, j, cnt + 1)
            || dfs(grid, visited, i, j - 1, i, j, cnt + 1)) {
            return true;
        }
        return false;
    }
}