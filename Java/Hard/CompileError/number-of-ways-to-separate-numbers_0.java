class Solution {
    public int numberOfCombinations(String num) {
        
        int[][] grid = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                grid[i][j] = 1;
            }
        }
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int days = cells.length;
        for (int i = days - 1; i >= 0; i--) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            grid[r][c] = 0;
            if (r == 0) {
                if (dfs(r, c, grid, directions)) {
                    return i;
                }
            }
        }
        return 0;
    }
    
    private boolean dfs(int r, int c, int[][] grid, int[][] directions) {
        int row = grid.length;
        int col = grid[0].length;
        if (r == row - 1) {
            return true;
        }
        for (int[] d : directions) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr >= 0 && nr < row && nc >= 0 && nc < col && grid[nr][nc] == 0) {
                if (dfs(nr, nc, grid, directions)) {
                    return true;
                }
            }
        }
        return false;
    }
}