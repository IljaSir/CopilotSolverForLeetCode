class Solution {
    public int checkRecord(int n) {
        
        int mod = 1000000007;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % mod;
        }
        long result = dp[n];
        for (int i = 1; i <= n; i++) {
            result = (result + dp[i - 1] * dp[n - i]) % mod;
        }
        return (int)result;
    }
}