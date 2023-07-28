class Solution {
    public int idealArrays(int n, int maxValue) {
        
        int mod = 1000000007;
        long[] dp = new long[maxValue + 1];
        for (int i = 1; i <= maxValue; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            long[] next = new long[maxValue + 1];
            long sum = 0;
            for (int j = 1; j <= maxValue; j++) {
                sum += dp[j];
                next[j] = sum;
                if (j > 1) {
                    next[j] -= dp[j - 1];
                }
            }
            for (int j = 1; j <= maxValue; j++) {
                dp[j] = next[j] % mod;
            }
        }
        long ans = 0;
        for (int i = 1; i <= maxValue; i++) {
            ans += dp[i];
        }
        return (int) (ans % mod);
    }
}