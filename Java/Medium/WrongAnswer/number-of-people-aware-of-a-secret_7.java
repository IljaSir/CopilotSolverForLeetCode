class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        
        int[] dp = new int[n + 1];
        int mod = 1000000007;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - delay]) % mod;
            if (i - delay - forget > 0) {
                dp[i] = (dp[i] - dp[i - delay - forget] + mod) % mod;
            }
        }
        return dp[n];
    }
}