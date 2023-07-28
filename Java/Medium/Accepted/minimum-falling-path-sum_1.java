class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int left = j == 0 ? Integer.MAX_VALUE : dp[i - 1][j - 1];
                int right = j == n - 1 ? Integer.MAX_VALUE : dp[i - 1][j + 1];
                dp[i][j] = matrix[i][j] + Math.min(left, Math.min(dp[i - 1][j], right));
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, dp[n - 1][i]);
        }
        return min;
    }
}