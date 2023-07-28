class Solution {
    public int numTilings(int n) {
        
        int MOD = 1000000007;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] * 2 % MOD;
            if (i >= 3) {
                dp[i] = (dp[i] + dp[i - 3]) % MOD;
            }
        }
        return (int) dp[n];
    }
}