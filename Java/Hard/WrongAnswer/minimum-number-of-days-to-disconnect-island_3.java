class Solution {
    public int minDays(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    dfs(grid, i, j, dirs);
                }
            }
        }
        if (count == 0) {
            return 0;
        }
        if (count > 1) {
            return 1;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    for (int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                            grid[i][j] = 1;
                            count = 0;
                            for (int a = 0; a < m; a++) {
                                for (int b = 0; b < n; b++) {
                                    if (grid[a][b] == 1) {
                                        count++;
                                        dfs(grid, a, b, dirs);
                                    }
                                }
                            }
                            if (count > 1) {
                                return 2;
                            }
                            grid[i][j] = 0;
                        }
                    }
                }
            }
        }
        return 2;
    }

    private void dfs(int[][] grid, int i, int j, int[][] dirs) {
        int m = grid.length;
        int n = grid[0].length;
        grid[i][j] = 0;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
                dfs(grid, x, y, dirs);
            }
        }
    }
}