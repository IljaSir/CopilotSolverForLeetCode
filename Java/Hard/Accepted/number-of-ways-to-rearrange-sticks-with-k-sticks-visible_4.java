class Solution {
    public int rearrangeSticks(int n, int k) {
        
        int mod = 1000000007;
        long[][] dp = new long[n + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j] * (i - 1)) % mod;
            }
        }
        return (int) dp[n][k];
    }
}