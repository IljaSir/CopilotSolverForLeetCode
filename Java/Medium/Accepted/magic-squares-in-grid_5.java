class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int i = 0; i < row - 2; i++) {
            for (int j = 0; j < col - 2; j++) {
                if (grid[i + 1][j + 1] != 5) {
                    continue;
                }
                if (magic(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }
    private boolean magic(int[][] grid, int i, int j) {
        boolean[] used = new boolean[16];
        for (int r = i; r < i + 3; r++) {
            int sum = 0;
            for (int c = j; c < j + 3; c++) {
                int v = grid[r][c];
                if (v < 1 || v > 9 || used[v]) {
                    return false;
                }
                used[v] = true;
                sum += v;
            }
            if (sum != 15) {
                return false;
            }
        }
        for (int c = j; c < j + 3; c++) {
            int sum = 0;
            for (int r = i; r < i + 3; r++) {
                sum += grid[r][c];
            }
            if (sum != 15) {
                return false;
            }
        }
        if (grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2] != 15) {
            return false;
        }
        if (grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j] != 15) {
            return false;
        }
        return true;
    }
}