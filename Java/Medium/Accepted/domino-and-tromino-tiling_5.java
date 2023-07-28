class Solution {
    public int numTilings(int n) {
        
        int mod = 1000000007;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = 1;
            } else if (i == 2) {
                dp[i] = 2;
            } else {
                dp[i] = 2 * dp[i - 1] % mod + dp[i - 3] % mod;
                dp[i] %= mod;
            }
        }
        return (int) dp[n];
    }
}