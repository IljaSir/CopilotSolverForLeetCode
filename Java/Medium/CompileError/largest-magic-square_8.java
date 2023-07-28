class Solution {
    public int largestMagicSquare(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        int[][] rowSum = new int[m][n];
        int[][] colSum = new int[m][n];
        int[][] diagSum = new int[m][n];
        int[][] antiDiagSum = new int[m][n];
        int[][][] dp = new int[m][n][Math.min(m, n)];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i][j] = grid[i][j] + (j > 0 ? rowSum[i][j - 1] : 0);
                colSum[i][j] = grid[i][j] + (i > 0 ? colSum[i - 1][j] : 0);
                diagSum[i][j] = grid[i][j] + (i > 0 && j > 0 ? diagSum[i - 1][j - 1] : 0);
                antiDiagSum[i][j] = grid[i][j] + (i > 0 && j < n - 1 ? antiDiagSum[i - 1][j + 1] : 0);
            }
        }
        int res = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < Math.min(m, n); k++) {
                    if (i + k < m && j + k < n) {
                        if (i > 0) {
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i - 1][j][k]);
                        }
                        if (j > 0) {
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i][j - 1][k]);
                        }
                        if (rowSum[i][j + k] - (j > 0 ? rowSum[i][j - 1] : 0) != colSum[i + k][j] - (i > 0 ? colSum[i - 1][j] : 0)) {
                            break;
                        }
                        if (diagSum[i +
    }
}