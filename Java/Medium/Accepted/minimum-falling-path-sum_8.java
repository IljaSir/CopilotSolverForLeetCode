class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int n = matrix.length;
        int[][] dp = new int[2][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int min = dp[(i - 1) % 2][j];
                if (j > 0) {
                    min = Math.min(min, dp[(i - 1) % 2][j - 1]);
                }
                if (j < n - 1) {
                    min = Math.min(min, dp[(i - 1) % 2][j + 1]);
                }
                dp[i % 2][j] = min + matrix[i][j];
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[(n - 1) % 2][i]);
        }
        return ans;
    }
}