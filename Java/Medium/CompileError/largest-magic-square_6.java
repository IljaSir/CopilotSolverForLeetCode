class Solution {
    public int largestMagicSquare(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        int[][] rowSum = new int[m][n+1];
        int[][] colSum = new int[m+1][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i][j+1] = rowSum[i][j] + grid[i][j];
                colSum[i+1][j] = colSum[i][j] + grid[i][j];
            }
        }
        int len = Math.min(m, n);
        for (int k = len; k >= 1; k--) {
            for (int i = 0; i <= m - k; i++) {
                for (int j = 0; j <= n - k; j++) {
                    if (check(rowSum, colSum, i, j, k)) {
                        return k;
                    }
                }
            }
        }
        return 1;
    }
    private boolean check(int[][] rowSum, int[][] colSum, int i, int j, int k) {
        int sum = rowSum[i][j+k] - rowSum[i][j];
        for (int x = 1; x < k; x++) {
            if (rowSum[i+x][j+k] - rowSum[i+x][j] != sum) {
                return false;
            }
        }
        for (int y = 0; y < k; y++) {
            if (colSum[i+k][j+y] - colSum[i][j+y] != sum) {
                return false;
            }
        }
        int diag1 = 0, diag2 = 0;
        for (int x = 0; x < k; x++) {
            diag1 += grid[i+x][j+x];
            diag2 += grid[i+x][j+k-1-x];
        }
        return diag1 == sum && diag2 == sum;
    }
}