class Solution {
    public int countHousePlacements(int n) {
        
        int MOD = 1_000_000_007;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }
        long ans = dp[n] * 2 % MOD;
        for (int i = 1; i <= n; i++) {
            ans = (ans + dp[i - 1] * dp[n - i] % MOD) % MOD;
        }
        return (int) ans;
    }
}