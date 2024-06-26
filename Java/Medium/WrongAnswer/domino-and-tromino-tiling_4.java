class Solution {
    public int numTilings(int n) {
        
        int mod = 1000000007;
        long[] dp = new long[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i-1]*2;
            if (i-2 >= 0) {
                dp[i] += dp[i-2]*2;
            }
            if (i-3 >= 0) {
                dp[i] += dp[i-3];
            }
            dp[i] %= mod;
        }
        return (int)dp[n];
    }
}