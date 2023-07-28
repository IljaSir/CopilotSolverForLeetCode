class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int a = j > 0 ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
                int b = dp[i - 1][j];
                int c = j < n - 1 ? dp[i - 1][j + 1] : Integer.MAX_VALUE;
                dp[i][j] = Math.min(a, Math.min(b, c)) + matrix[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            res = Math.min(res, dp[n - 1][i]);
        }
        return res;
    }
}