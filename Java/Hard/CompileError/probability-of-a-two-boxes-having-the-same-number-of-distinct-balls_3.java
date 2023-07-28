class Solution {
    public double getProbability(int[] balls) {
        
        int n = balls.length;
        int m = balls[0];
        for (int i = 1; i < n; i++) {
            m = Math.max(m, balls[i]);
        }
        long[] fac = new long[n * m + 1];
        fac[0] = 1;
        for (int i = 1; i < fac.length; i++) {
            fac[i] = fac[i - 1] * i;
        }
        long[] inv = new long[n * m + 1];
        inv[n * m] = pow(fac[n * m], mod - 2);
        for (int i = n * m - 1; i >= 0; i--) {
            inv[i] = inv[i + 1] * (i + 1) % mod;
        }
        long[] ways = new long[n * m + 1];
        ways[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = n * m; j >= balls[i]; j--) {
                ways[j] = (ways[j] + ways[j - balls[i]]) % mod;
            }
        }
        long[] cnt = new long[n * m + 1];
        for (int i = 0; i <= n * m; i++) {
            cnt[i] = fac[n * m] * inv[i] % mod * inv[n * m - i] % mod * ways[i] % mod;
        }
        long[][] dp = new long[n + 1][n * m + 1];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n * m; j++) {
                for (int k = 0; k <= balls[i] && k <= j; k++) {
                    dp[i + 1][j] = (dp[i + 1][j] + dp[i][j - k] * cnt[k]) % mod;
                }
            }
        }
        long total = 0;
        for (int i = 0; i <= n * m; i++) {
            total = (total + dp[n][i]) % mod;
        }
        long ans = dp[n][n *
    }
}