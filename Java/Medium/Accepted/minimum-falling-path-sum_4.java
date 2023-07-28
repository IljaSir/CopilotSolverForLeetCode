class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = matrix[i][j] + dp[i - 1][j];
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], matrix[i][j] + dp[i - 1][j - 1]);
                }
                if (j < n - 1) {
                    dp[i][j] = Math.min(dp[i][j], matrix[i][j] + dp[i - 1][j + 1]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }
        return min;
    }
}