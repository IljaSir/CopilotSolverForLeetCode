class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = matrix[i][j];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int min = dp[i - 1][j];
                if (j - 1 >= 0) {
                    min = Math.min(min, dp[i - 1][j - 1]);
                }
                if (j + 1 < m) {
                    min = Math.min(min, dp[i - 1][j + 1]);
                }
                dp[i][j] += min;
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            ans = Math.min(ans, dp[n - 1][i]);
        }
        return ans;
    }
}