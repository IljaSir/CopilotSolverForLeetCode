class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        
        int mod = 1000000007;
        long[] dp = new long[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 1] - ((i - forget - 1 >= 0) ? dp[i - forget - 1] : 0) + mod) % mod;
            if (i > delay) {
                dp[i] = (dp[i] + dp[i - delay]) % mod;
            }
        }
        return (int) dp[n];
    }
}