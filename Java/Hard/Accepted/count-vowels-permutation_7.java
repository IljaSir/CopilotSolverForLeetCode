class Solution {
    public int countVowelPermutation(int n) {
        
        final int MOD = 1000000007;
        long[] dp = new long[]{1, 1, 1, 1, 1};
        for (int i = 2; i <= n; i++) {
            long[] ndp = new long[5];
            ndp[0] = (dp[1] + dp[2] + dp[4]) % MOD;
            ndp[1] = (dp[0] + dp[2]) % MOD;
            ndp[2] = (dp[1] + dp[3]) % MOD;
            ndp[3] = dp[2];
            ndp[4] = (dp[2] + dp[3]) % MOD;
            dp = ndp;
        }
        long c = 0;
        for (long x: dp) {
            c = (c + x) % MOD;
        }
        return (int) c;
    }
}