class Solution {
    public int idealArrays(int n, int maxValue) {
        
        int MOD = 1000000007;
        long[] dp = new long[maxValue + 1];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            long[] ndp = new long[maxValue + 1];
            long sum = 0;
            for (int j = 1; j <= maxValue; j++) {
                sum += dp[j];
                ndp[j] = sum;
            }
            dp = ndp;
        }
        long res = 0;
        for (long v: dp) {
            res += v;
        }
        return (int) (res % MOD);
    }
}