class Solution {
    public boolean containsCycle(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (dfs(grid, i, j, visited, i, j, -1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] grid, int i, int j, boolean[][] visited, int prevI, int prevJ, int dir) {
        if (visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int k = 0; k < 4; k++) {
            int nextI = i + dirs[k][0];
            int nextJ = j + dirs[k][1];
            if (nextI == prevI && nextJ == prevJ) {
                continue;
            }
            if (nextI >= 0 && nextI < grid.length && nextJ >= 0 && nextJ < grid[0].length && grid[nextI][nextJ] == grid[i][j]) {
                if (dfs(grid, nextI, nextJ, visited, i, j, k)) {
                    return true;
                }
            }
        }
        return false;
    }
}