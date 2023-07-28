class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = matrix[n - 1][i];
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = j - 1; k <= j + 1; k++) {
                    if (k >= 0 && k < n) {
                        min = Math.min(min, dp[i + 1][k]);
                    }
                }
                dp[i][j] = min + matrix[i][j];
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[0][i]);
        }
        return ans;
    }
}