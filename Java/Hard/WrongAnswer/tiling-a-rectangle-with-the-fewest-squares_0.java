class Solution {
    public int tilingRectangle(int n, int m) {
        
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = i * j;
                for (int k = 1; k < i; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[k][j] + dp[i - k][j]);
                }
                for (int k = 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[i][j - k]);
                }
            }
        }
        return dp[n][m];
    }
}