class Solution {
    public int idealArrays(int n, int maxValue) {
        
        int MOD = 1000000007;
        long[] dp = new long[maxValue + 1];
        long[] sum = new long[maxValue + 1];
        for (int i = 1; i <= maxValue; i++) {
            dp[i] = 1;
            sum[i] = sum[i - 1] + dp[i];
        }
        for (int i = 1; i < n; i++) {
            long[] dp2 = new long[maxValue + 1];
            long[] sum2 = new long[maxValue + 1];
            for (int j = 1; j <= maxValue; j++) {
                dp2[j] = sum[j];
                sum2[j] = sum2[j - 1] + dp2[j];
            }
            dp = dp2;
            sum = sum2;
        }
        long ans = 0;
        for (int i = 1; i <= maxValue; i++) {
            ans += dp[i];
        }
        return (int) (ans % MOD);
    }
}