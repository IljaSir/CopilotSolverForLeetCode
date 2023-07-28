class Solution {
    public int largestMagicSquare(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] row = new int[m][n];
        int[][] col = new int[m][n];
        int[][] diag = new int[m][n];
        int[][] antiDiag = new int[m][n];
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += grid[i][j];
                row[i][j] = sum;
            }
        }
        for (int j = 0; j < n; j++) {
            int sum = 0;
            for (int i = 0; i < m; i++) {
                sum += grid[i][j];
                col[i][j] = sum;
            }
        }
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    diag[i][j] = grid[i][j];
                } else {
                    diag[i][j] = diag[i - 1][j - 1] + grid[i][j];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (i == 0 || j == n - 1) {
                    antiDiag[i][j] = grid[i][j];
                } else {
                    antiDiag[i][j] = antiDiag[i - 1][j + 1] + grid[i][j];
                }
            }
        }
        int result = 1;
        for (int k = 2; k <= Math.min(m, n); k++) {
            for (int i = k - 1; i < m; i++) {
                for (int j = k - 1; j < n; j++) {
                    int sum = row[i][j];
                    if (j - k >= 0) {
                        sum -= row[i][j - k];
                    }
                    int flag = 0;
                    for (int l
    }
}