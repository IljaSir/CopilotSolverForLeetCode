class Solution {
    public int maximumRows(int[][] matrix, int numSelect) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[] row = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i] = (row[i] << 1) + matrix[i][j];
            }
        }
        int[] dp = new int[1 << n];
        for (int i = 0; i < m; i++) {
            int[] next = new int[1 << n];
            for (int j = 0; j < (1 << n); j++) {
                next[j] = dp[j];
                if ((j & row[i]) == row[i]) {
                    next[j] = Math.max(next[j], dp[j ^ row[i]] + 1);
                }
            }
            dp = next;
        }
        return dp[(1 << n) - 1];
    }
}