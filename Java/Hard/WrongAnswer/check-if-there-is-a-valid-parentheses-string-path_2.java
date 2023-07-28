class Solution {
    public boolean hasValidPath(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        return dfs(grid, visited, 0, 0);
    }
    public boolean dfs(char[][] grid, boolean[][] visited, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        if (i == m - 1 && j == n - 1) {
            return true;
        }
        int[] x = {0, 0, -1, 1};
        int[] y = {-1, 1, 0, 0};
        for (int k = 0; k < 4; k++) {
            if (grid[i][j] == '(') {
                if (k == 0 || k == 2) {
                    continue;
                }
            } else if (grid[i][j] == ')') {
                if (k == 1 || k == 3) {
                    continue;
                }
            } else if (grid[i][j] == '[') {
                if (k == 0 || k == 3) {
                    continue;
                }
            } else if (grid[i][j] == ']') {
                if (k == 1 || k == 2) {
                    continue;
                }
            } else if (grid[i][j] == '{') {
                if (k == 2 || k == 3) {
                    continue;
                }
            } else if (grid[i][j] == '}') {
                if (k == 0 || k == 1) {
                    continue;
                }
            }
            if (dfs(grid, visited, i + x[k], j + y[k])) {
                return true;
            }
        }
        return false;
    }
}