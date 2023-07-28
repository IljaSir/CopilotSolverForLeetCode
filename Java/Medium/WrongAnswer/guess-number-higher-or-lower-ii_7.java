class Solution {
    public int getMoneyAmount(int n) {
        
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            dp[i][i + 1] = 0;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], k + Math.max(dp[i][k - 1], dp[k + 1][j]));
                }
            }
        }
        return dp[1][n];
    }
}