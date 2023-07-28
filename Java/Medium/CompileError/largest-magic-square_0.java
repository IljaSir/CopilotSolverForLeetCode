class Solution {
    public int largestMagicSquare(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        int[][] rowSum = new int[m + 1][n + 1];
        int[][] colSum = new int[m + 1][n + 1];
        int[][] diagSum = new int[m + 1][n + 1];
        int[][] antiDiagSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                rowSum[i][j] = rowSum[i][j - 1] + grid[i - 1][j - 1];
                colSum[i][j] = colSum[i - 1][j] + grid[i - 1][j - 1];
                diagSum[i][j] = diagSum[i - 1][j - 1] + grid[i - 1][j - 1];
                antiDiagSum[i][j] = antiDiagSum[i - 1][j + 1] + grid[i - 1][j - 1];
            }
        }
        int ans = 1;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                int k = Math.min(m - i + 1, n - j + 1);
                for (; k > ans; --k) {
                    if (rowSum[i][j + k - 1] - rowSum[i][j - 1] != colSum[i + k - 1][j] - colSum[i - 1][j]) {
                        continue;
                    }
                    if (rowSum[i][j + k - 1] - rowSum[i][j - 1] != diagSum[i + k - 1][j + k - 1] - diagSum[i - 1][j - 1]) {
                        continue;
                    }
                    if (rowSum[i][j + k - 1] - rowSum[i][j - 1] != antiDiagSum[i + k - 1][j] - antiDiagSum[i - 1][j + k]) {
                        continue;
                    }
                    ans = k
    }
}