class Solution {
    public int maximumRows(int[][] matrix, int numSelect) {
        
        int m = matrix.length, n = matrix[0].length;
        int[] rows = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rows[i] = (rows[i] << 1) + matrix[i][j];
            }
        }
        int[] dp = new int[1 << n];
        for (int row : rows) {
            for (int mask = (1 << n) - 1; mask >= 0; mask--) {
                if ((mask & row) == row) {
                    dp[mask | row] = Math.max(dp[mask | row], dp[mask] + 1);
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}