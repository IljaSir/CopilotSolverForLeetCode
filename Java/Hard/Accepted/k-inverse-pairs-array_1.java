class Solution {
    public int kInversePairs(int n, int k) {
        
        int[][] dp = new int[n + 1][k + 1];
        dp[1][0] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= k; j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1000000007;
                if (j >= i) {
                    dp[i][j] = (dp[i][j] - dp[i - 1][j - i] + 1000000007) % 1000000007;
                }
            }
        }
        return dp[n][k];
    }
}