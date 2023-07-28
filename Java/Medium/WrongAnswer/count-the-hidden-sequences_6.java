class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        
        int mod = 1000000007;
        int n = differences.length;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        long pre = 0;
        for (int i = 0; i < n; i++) {
            pre += differences[i];
            long l = Math.max(pre - upper, 0);
            long r = Math.max(pre - lower, 0);
            dp[i + 1] = (dp[i + 1] + (pre - l) * dp[i]) % mod;
            dp[i + 1] = (dp[i + 1] + (r - l) * dp[i]) % mod;
            dp[i + 1] = (dp[i + 1] - (pre - r) * dp[i]) % mod;
            if (dp[i + 1] < 0) {
                dp[i + 1] += mod;
            }
        }
        return (int) dp[n];
    }
}