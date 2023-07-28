class Solution {
    public int uniquePathsIII(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        int sx = 0, sy = 0, tx = 0, ty = 0;
        int empty = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    sx = i;
                    sy = j;
                } else if (grid[i][j] == 2) {
                    tx = i;
                    ty = j;
                } else if (grid[i][j] == 0) {
                    empty++;
                }
            }
        }
        return dfs(grid, sx, sy, tx, ty, empty);
    }

    public int dfs(int[][] grid, int x, int y, int tx, int ty, int empty) {
        if (x == tx && y == ty) {
            return empty == 0 ? 1 : 0;
        }
        int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int ret = 0;
        int m = grid.length, n = grid[0].length;
        grid[x][y] = -1;
        for (int i = 0; i < 4; i++) {
            int nx = x + d[i][0], ny = y + d[i][1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] != -1) {
                ret += dfs(grid, nx, ny, tx, ty, empty - 1);
            }
        }
        grid[x][y] = 0;
        return ret;
    }
}