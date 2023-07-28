class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        
        int[][] grid = new int[row][col];
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int res = 0;
        for (int i = 0; i < cells.length; i++) {
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
            if (cells[i][0] == 1) {
                dfs(grid, cells[i][0] - 1, cells[i][1] - 1, dir);
            }
            if (grid[row - 1][col - 1] == 2) {
                res = i + 1;
            }
        }
        return res;
    }
    
    public void dfs(int[][] grid, int r, int c, int[][] dir) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != 0) {
            return;
        }
        grid[r][c] = 2;
        for (int i = 0; i < 4; i++) {
            dfs(grid, r + dir[i][0], c + dir[i][1], dir);
        }
    }
}