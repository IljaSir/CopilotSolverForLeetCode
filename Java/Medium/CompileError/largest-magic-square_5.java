class Solution {
    public int largestMagicSquare(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] row = new int[m][n];
        int[][] col = new int[m][n];
        int[][] diag = new int[m][n];
        int[][] antiDiag = new int[m][n];
        for (int i = 0; i < m; i++) {
            row[i][0] = grid[i][0];
            for (int j = 1; j < n; j++) {
                row[i][j] = row[i][j - 1] + grid[i][j];
            }
        }
        for (int j = 0; j < n; j++) {
            col[0][j] = grid[0][j];
            for (int i = 1; i < m; i++) {
                col[i][j] = col[i - 1][j] + grid[i][j];
            }
        }
        for (int i = 0; i < m; i++) {
            diag[i][0] = grid[i][0];
            for (int j = 1; j < n; j++) {
                if (i + j < m) {
                    diag[i][j] = diag[i][j - 1] + grid[i + j][j];
                }
            }
        }
        for (int j = 1; j < n; j++) {
            diag[0][j] = grid[0][j];
            for (int i = 1; i < m; i++) {
                if (j + i < n) {
                    diag[i][j] = diag[i - 1][j] + grid[i][j + i];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            antiDiag[i][0] = grid[i][0];
            for (int j = 1; j < n; j++) {
                if (i - j >= 0) {
                    antiDiag[i][j] = antiDiag[i][j - 1] + grid[i - j][j];
                }
            }
        }
        for (int j = 1; j < n; j++) {
            antiDiag[m - 1][j] = grid[m - 1][j];
            for
    }
}