class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        
        int n = differences.length;
        long[] dp = new long[n + 1];
        long mod = (long)1e9 + 7;
        dp[0] = 1;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += differences[i];
            dp[i + 1] = (dp[i + 1] + dp[i]) % mod;
            if (sum >= lower && sum <= upper) {
                dp[i + 1] = (dp[i + 1] + dp[i]) % mod;
            }
            if (sum - upper >= 1) {
                dp[i + 1] = (dp[i + 1] - dp[(int)(sum - upper - 1)]) % mod;
            }
            if (sum - lower >= 0) {
                dp[i + 1] = (dp[i + 1] + dp[(int)(sum - lower)]) % mod;
            }
        }
        return (int)((dp[n] - 1 + mod) % mod);
    }
}