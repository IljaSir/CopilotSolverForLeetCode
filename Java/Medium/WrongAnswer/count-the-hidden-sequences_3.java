class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        
        int n = differences.length;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        long sum = 0;
        long mod = (long)1e9 + 7;
        for (int i = 0; i < n; i++) {
            sum += differences[i];
            dp[i + 1] = (dp[i + 1] + dp[i]) % mod;
            if (sum >= lower) {
                int l = Math.max(0, i + 2 - (int)(sum - lower + 1));
                int r = Math.min(i + 1, (int)(sum - upper + 1));
                if (l <= r) {
                    dp[r + 1] = (dp[r + 1] - dp[l] + mod) % mod;
                }
            }
        }
        return (int)dp[n];
    }
}