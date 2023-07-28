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
                if (j > 0) {
                    rowSum[i][j] += rowSum[i][j - 1];
                }
                colSum[i][j] = grid[i][j];
                if (i > 0) {
                    colSum[i][j] += colSum[i - 1][j];
                }
                diagSum[i][j] = grid[i][j];
                if (i > 0 && j > 0) {
                    diagSum[i][j] += diagSum[i - 1][j - 1];
                }
                antiDiagSum[i][j] = grid[i][j];
                if (i > 0 && j < n - 1) {
                    antiDiagSum[i][j] += antiDiagSum[i - 1][j + 1];
                }
            }
        }
        int k = Math.min(m, n);
        for (; k >= 2; k--) {
            for (int i = 0; i + k <= m; i++) {
                for (int j = 0; j + k <= n; j++) {
                    if (check(rowSum, colSum, diagSum, antiDiagSum, i, j, k)) {
                        return k;
                    }
                }
            }
        }
        return k;
    }
    private boolean check(int[][] rowSum, int[][] colSum, int[][] diagSum, int[][] antiDiagSum, int x, int y, int k) {
        int sum = rowSum[x][y + k - 1];
        if (y > 0) {
            sum -= rowSum[x][y - 1];
        }
        for (int i = x; i < x + k; i++) {
            int cur = rowSum[i][y + k - 1];
            if
    }
}