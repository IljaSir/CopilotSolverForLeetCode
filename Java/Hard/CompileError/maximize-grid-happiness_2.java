class Solution {
    public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
        
        int[][] grid = new int[m][n];
        int[] max = new int[1];
        backtracking(grid, 0, 0, introvertsCount, extrovertsCount, max);
        return max[0];
    }
    
    private void backtracking(int[][] grid, int row, int col, int introvertsCount, int extrovertsCount, int[] max) {
        int m = grid.length;
        int n = grid[0].length;
        if (row == m) {
            max[0] = Math.max(max[0], getHappiness(grid));
            return;
        }
        int nextRow = row;
        int nextCol = col + 1;
        if (nextCol == n) {
            nextRow++;
            nextCol = 0;
        }
        if (introvertsCount > 0) {
            grid[row][col] = 1;
            backtracking(grid, nextRow, nextCol, introvertsCount - 1, extrovertsCount, max);
            grid[row][col] = 0;
        }
        if (extrovertsCount > 0) {
            grid[row][col] = 2;
            backtracking(grid, nextRow, nextCol, introvertsCount, extrovertsCount - 1, max);
            grid[row][col] = 0;
        }
        backtracking(grid, nextRow, nextCol, introvertsCount, extrovertsCount, max);
    }
    
    private int getHappiness(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    res += 120;
                    if (i > 0) {
                        if (grid[i - 1][j] == 1) {
                            res -= 30;
                        } else if (grid[i - 1][j] == 2) {
                            res += 20;
                        }
                    }
                    if (j > 0) {
                        if (grid[i][j - 1] == 1) {
                            res -= 30;
                        } else if (grid[i][j - 1
    }
}