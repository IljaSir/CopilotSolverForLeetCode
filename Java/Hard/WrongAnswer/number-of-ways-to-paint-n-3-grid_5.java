class Solution {
    public int numOfWays(int n) {
        
        int mod = (int)1e9 + 7;
        long[][] dp = new long[n][3];
        for (int i = 0; i < 3; i++) {
            dp[0][i] = 6;
        }
        for (int i = 1; i < n; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2]) % mod;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
        }
        long ans = 0;
        for (int i = 0; i < 3; i++) {
            ans += dp[n - 1][i];
            ans %= mod;
        }
        return (int)ans;
    }
}