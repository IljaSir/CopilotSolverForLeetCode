class Solution {
    public int checkRecord(int n) {
        
        int mod = 1000000007;
        long[] dp = new long[n + 1];
        dp[0] = dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % mod;
        }
        long res = dp[n];
        for (int i = 0; i < n; i++) {
            res = (res + dp[i] * dp[n - i - 1]) % mod;
        }
        return (int) res;
    }
}