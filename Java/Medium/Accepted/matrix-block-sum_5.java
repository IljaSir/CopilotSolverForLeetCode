class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        
        int m = mat.length, n = mat[0].length;
        int[][] ans = new int[m][n];
        int[][] sum = new int[m + 1][n + 1];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                sum[i + 1][j + 1] = mat[i][j] + sum[i + 1][j] + sum[i][j + 1] - sum[i][j];
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int r1 = Math.max(0, i - k), c1 = Math.max(0, j - k);
                int r2 = Math.min(m, i + k + 1), c2 = Math.min(n, j + k + 1);
                ans[i][j] = sum[r2][c2] - sum[r1][c2] - sum[r2][c1] + sum[r1][c1];
            }
        }
        return ans;
    }
}