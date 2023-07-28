class Solution {
    public int minDays(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        if (count > 1) return 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    visited = new boolean[m][n];
                    count = 0;
                    for (int k = 0; k < m; k++) {
                        for (int l = 0; l < n; l++) {
                            if (grid[k][l] == 1 && !visited[k][l]) {
                                dfs(grid, visited, k, l);
                                count++;
                            }
                        }
                    }
                    if (count > 1) return 1;
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }
}