class Solution {
    public int totalStrength(int[] strength) {
        
        int n = strength.length;
        int MOD = 1_000_000_000 + 7;
        long sum = 0;
        long[] dp = new long[n];
        for (int i = 0; i < n; i++) {
            dp[i] = strength[i];
            sum += strength[i];
        }
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[i], dp[i - 1]);
        }
        long res = 0;
        for (int i = n - 1; i >= 0; i--) {
            res += dp[i] * sum;
            res %= MOD;
            sum -= strength[i];
        }
        return (int) res;
    }
}