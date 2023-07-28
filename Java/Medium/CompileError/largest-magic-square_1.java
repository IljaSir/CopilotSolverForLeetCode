class Solution {
    public int largestMagicSquare(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        int[][] row = new int[m][n + 1];
        int[][] col = new int[m + 1][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i][j + 1] = row[i][j] + grid[i][j];
                col[i + 1][j] = col[i][j] + grid[i][j];
            }
        }
        for (int len = Math.min(m, n); len >= 1; len--) {
            for (int i = 0; i <= m - len; i++) {
                for (int j = 0; j <= n - len; j++) {
                    int sum = row[i][j + len] - row[i][j];
                    if (check(row, i, j, j + len, sum) && check(col, j, i, i + len, sum)) {
                        if (check(grid, i, j, len, sum)) {
                            return len;
                        }
                    }
                }
            }
        }
        return 1;
    }

    private boolean check(int[][] grid, int row, int col, int len, int sum) {
        int diag1 = 0, diag2 = 0;
        for (int i = 0; i < len; i++) {
            diag1 += grid[row + i][col + i];
            diag2 += grid[row + i][col + len - 1 - i];
            if (grid[row + i][col + i] != grid[row + i][col + len - 1 - i]) {
                return false;
            }
        }
        return diag1 == sum && diag2 == sum;
    }

    private boolean check(int[][] grid, int row, int col, int len, int sum) {
        for (int i = 0; i < len; i++) {
            int r = 0, c = 0;
            for (int j = 0; j < len; j++) {
                r += grid[row + i][col + j];
                c += grid[row + j][col + i];
            }
            if (r != sum || c != sum) {
                return false
    }
}