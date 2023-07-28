class Solution {
    public int largestMagicSquare(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        int[][] rowSums = new int[m][n + 1];
        int[][] colSums = new int[m + 1][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSums[i][j + 1] = rowSums[i][j] + grid[i][j];
                colSums[i + 1][j] = colSums[i][j] + grid[i][j];
            }
        }
        int ans = 1;
        for (int k = Math.min(m, n); k >= 2; k--) {
            for (int i = 0; i + k <= m; i++) {
                for (int j = 0; j + k <= n; j++) {
                    if (isMagic(rowSums, colSums, i, j, k)) {
                        ans = Math.max(ans, k);
                    }
                }
            }
        }
        return ans;
    }
    public boolean isMagic(int[][] rowSums, int[][] colSums, int i, int j, int k) {
        int d1 = 0, d2 = 0;
        for (int x = 0; x < k; x++) {
            d1 += rowSums[i + x][j + x + 1] - rowSums[i + x][j + x];
            d2 += rowSums[i + x][j + k] - rowSums[i + x][j + k - x - 1];
        }
        if (d1 != d2) {
            return false;
        }
        for (int x = 0; x < k; x++) {
            int r = rowSums[i + x][j + k] - rowSums[i + x][j];
            int c = colSums[i + k][j + x] - colSums[i][j + x];
            if (r != c || r != d1) {
                return false;
            }
        }
        return true;
    }
}