class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        
        long mod = (long)1e9 + 7;
        long[] dp = new long[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - delay]) % mod;
            if (i > forget) {
                dp[i] = (dp[i] - dp[i - forget - 1] + mod) % mod;
            }
        }
        return (int)dp[n];
    }
}