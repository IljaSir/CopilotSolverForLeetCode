class Solution {
    public int closedIsland(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if((i == 0 || j == 0 || i == n - 1 || j == m - 1) && grid[i][j] == 0) {
                    dfs(i, j, grid, dir);
                }
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 0) {
                    dfs(i, j, grid, dir);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, int[][] grid, int[][] dir) {
        grid[i][j] = 1;
        for(int k = 0; k < 4; k++) {
            int r = i + dir[k][0];
            int c = j + dir[k][1];
            if(r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] == 0) {
                dfs(r, c, grid, dir);
            }
        }
    }
}