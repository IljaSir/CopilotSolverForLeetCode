class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        
        int count = 0;
        for (int i = 0; i <= grid.length - 3; i++) {
            for (int j = 0; j <= grid[0].length - 3; j++) {
                if (grid[i + 1][j + 1] != 5) continue;
                if (magic(grid, i, j)) count++;
            }
        }
        return count;
    }
    public boolean magic(int[][] grid, int i, int j) {
        int[] count = new int[16];
        for (int r = i; r < i + 3; r++) {
            for (int c = j; c < j + 3; c++) {
                if (grid[r][c] < 1 || grid[r][c] > 9) return false;
                count[grid[r][c]]++;
            }
        }
        for (int v = 1; v <= 9; v++) {
            if (count[v] != 1) return false;
        }
        if ((grid[i][j] + grid[i][j + 1] + grid[i][j + 2]) != 15) return false;
        if ((grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2]) != 15) return false;
        if ((grid[i + 2][j] + grid[i + 2][j + 1] + grid[i + 2][j + 2]) != 15) return false;
        if ((grid[i][j] + grid[i + 1][j] + grid[i + 2][j]) != 15) return false;
        if ((grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1]) != 15) return false;
        if ((grid[i][j + 2] + grid[i + 1][j + 2] + grid[i + 2][j + 2]) != 15) return false;
        if ((grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2]) != 15) return false;
        if ((grid
    }
}