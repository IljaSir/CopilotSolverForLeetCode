class Solution {
    public boolean containsCycle(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (dfs(grid, visited, i, j, -1, -1, dirs)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] grid, boolean[][] visited, int i, int j, int pi, int pj, int[][] dirs) {
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
                if (grid[x][y] == grid[i][j]) {
                    if (x == pi && y == pj) {
                        continue;
                    }
                    if (visited[x][y]) {
                        return true;
                    }
                    if (dfs(grid, visited, x, y, i, j, dirs)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}