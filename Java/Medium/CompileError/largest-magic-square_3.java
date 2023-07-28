class Solution {
    public int largestMagicSquare(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] rowSum = new int[m][n];
        int[][] colSum = new int[m][n];
        int[][] diagSum = new int[m][n];
        int[][] antiDiagSum = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i][j] = grid[i][j];
                colSum[i][j] = grid[i][j];
                diagSum[i][j] = grid[i][j];
                antiDiagSum[i][j] = grid[i][j];
                if (i > 0) {
                    rowSum[i][j] += rowSum[i - 1][j];
                }
                if (j > 0) {
                    colSum[i][j] += colSum[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    diagSum[i][j] += diagSum[i - 1][j - 1];
                }
                if (i > 0 && j < n - 1) {
                    antiDiagSum[i][j] += antiDiagSum[i - 1][j + 1];
                }
            }
        }
        int max = 1;
        for (int k = 2; k <= Math.min(m, n); k++) {
            for (int i = 0; i + k - 1 < m; i++) {
                for (int j = 0; j + k - 1 < n; j++) {
                    int row = rowSum[i + k - 1][j];
                    if (i > 0) {
                        row -= rowSum[i - 1][j];
                    }
                    int col = colSum[i][j + k - 1];
                    if (j > 0) {
                        col -= colSum[i][j - 1];
                    }
                    int diag = diagSum[i + k - 1][j + k - 1];
                    if (i > 0 && j > 0) {
                        diag -= diagSum[i - 1][j - 1];
                    }
                    int antiDiag = antiDiagSum[i +
    }
}