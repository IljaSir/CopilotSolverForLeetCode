class Solution {
    public int checkRecord(int n) {
        
        int mod = 1000000000 + 7;
        long[] dp = new long[6];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 0;
        dp[3] = 1;
        dp[4] = 0;
        dp[5] = 0;
        for (int i = 1; i <= n; i++) {
            long[] next = new long[6];
            next[0] = (dp[0] + dp[1] + dp[2]) % mod;
            next[1] = dp[0];
            next[2] = dp[1];
            next[3] = (dp[0] + dp[1] + dp[2] + dp[3] + dp[4] + dp[5]) % mod;
            next[4] = dp[3];
            next[5] = dp[4];
            dp = next;
        }
        return (int) ((dp[0] + dp[1] + dp[2] + dp[3] + dp[4] + dp[5]) % mod);
    }
}