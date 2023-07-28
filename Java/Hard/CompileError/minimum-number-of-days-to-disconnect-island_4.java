class Solution {
    public int minDays(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] visited = new int[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    count++;
                    if (count > 1) {
                        return 0;
                    }
                    dfs(grid, i, j, visited, dir);
                }
            }
        }
        if (count == 0) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    visited = new int[n][m];
                    count = 0;
                    for (int k = 0; k < n; k++) {
                        for (int l = 0; l < m; l++) {
                            if (grid[k][l] == 1 && visited[k][l] == 0) {
                                count++;
                                if (count > 1) {
                                    return 1;
                                }
                                dfs(grid, k, l, visited, dir);
                            }
                        }
                    }
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }
}