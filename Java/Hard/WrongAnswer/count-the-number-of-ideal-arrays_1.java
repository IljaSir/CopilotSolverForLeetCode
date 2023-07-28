class Solution {
    public int idealArrays(int n, int maxValue) {
        
        int MOD = 1000000007;
        long[] dp = new long[maxValue + 1];
        Arrays.fill(dp, 1);
        for (int i = 2; i <= n; i++) {
            long[] ndp = new long[maxValue + 1];
            long sum = 0;
            for (int j = 1; j <= maxValue; j++) {
                sum = (sum + dp[j]) % MOD;
                ndp[j] = sum;
            }
            dp = ndp;
        }
        long ans = 0;
        for (int i = 1; i <= maxValue; i++) {
            ans = (ans + dp[i]) % MOD;
        }
        return (int) ans;
    }
}