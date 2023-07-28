class Solution {
    public int idealArrays(int n, int maxValue) {
        
        long MOD = 1000000007;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            long sum = 0;
            for (int j = 1; j <= maxValue; j++) {
                if (i == 1) {
                    sum += 1;
                } else {
                    sum += dp[i - 2] * (j - 1);
                }
                sum %= MOD;
            }
            dp[i] = sum;
        }
        return (int)dp[n];
    }
}