class Solution {
    public int numOfWays(int n) {
        
        int mod = 1000000000 + 7;
        long[] dp = new long[3];
        long[] dp2 = new long[3];
        dp[0] = dp[1] = dp[2] = 6;
        for (int i = 1; i < n; i++) {
            dp2[0] = dp[0] * 3 + dp[1] * 2;
            dp2[1] = dp[0] * 2 + dp[1] * 2 + dp[2] * 2;
            dp2[2] = dp[1] * 2 + dp[2] * 3;
            dp[0] = dp2[0] % mod;
            dp[1] = dp2[1] % mod;
            dp[2] = dp2[2] % mod;
        }
        return (int) ((dp[0] + dp[1] + dp[2]) % mod);
    }
}