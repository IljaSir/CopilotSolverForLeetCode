class Solution {
    public int countSquares(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0];
            res += dp[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = matrix[0][j];
            res += dp[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    res += dp[i][j];
                }
            }
        }
        return res;
    }
}