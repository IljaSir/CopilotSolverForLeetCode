class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        
        int mod = 1000000007;
        long[][][] dp = new long[low + 1][zero + 1][one + 1];
        for (int i = 0; i <= low; i++) {
            for (int j = 0; j <= zero; j++) {
                for (int k = 0; k <= one; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        long ans = 0;
        for (int i = low; i <= high; i++) {
            ans += dfs(i, zero, one, dp);
            ans %= mod;
        }
        return (int) ans;
    }
    private long dfs(int n, int zero, int one, long[][][] dp) {
        if (n == 0) {
            return 1;
        }
        if (dp[n][zero][one] != -1) {
            return dp[n][zero][one];
        }
        long ans = 0;
        int mod = 1000000007;
        if (zero > 0) {
            ans += dfs(n - 1, zero - 1, one, dp);
            ans %= mod;
        }
        if (one > 0) {
            ans += dfs(n - 1, zero, one - 1, dp);
            ans %= mod;
        }
        ans += dfs(n - 1, zero, one, dp);
        ans %= mod;
        dp[n][zero][one] = ans;
        return ans;
    }
}