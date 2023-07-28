class Solution {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        
        int m = grid.length, n = grid[0].length;
        int[] res = new int[hits.length];
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] hit : hits) {
            grid[hit[0]][hit[1]]--;
        }
        for (int j = 0; j < n; j++) {
            dfs(grid, 0, j, m, n, dirs);
        }
        for (int i = hits.length - 1; i >= 0; i--) {
            int x = hits[i][0], y = hits[i][1];
            grid[x][y]++;
            if (grid[x][y] == 1 && isConnected(grid, x, y, m, n, dirs)) {
                res[i] = dfs(grid, x, y, m, n, dirs) - 1;
            }
        }
        return res;
    }
    
    private boolean isConnected(int[][] grid, int x, int y, int m, int n, int[][] dirs) {
        if (x == 0) {
            return true;
        }
        for (int[] dir : dirs) {
            int nx = x + dir[0], ny = y + dir[1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 2) {
                return true;
            }
        }
        return false;
    }
    
    private int dfs(int[][] grid, int x, int y, int m, int n, int[][] dirs) {
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 1) {
            return 0;
        }
        grid[x][y] = 2;
        int res = 1;
        for (int[] dir : dirs) {
            int nx = x + dir[0], ny = y + dir[1];
            res += dfs(grid, nx, ny, m, n, dirs);
        }
        return res;
    }
}