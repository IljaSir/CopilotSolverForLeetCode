class Solution {
    public int distinctSequences(int n) {
        
        long[][] dp = new long[n + 1][7];
        int mod = 1000000007;
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j != k && gcd(j, k) == 1) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][k]) % mod;
                    }
                }
            }
        }
        long ans = 0;
        for (int i = 1; i <= 6; i++) {
            ans = (ans + dp[n][i]) % mod;
        }
        return (int) ans;
    }

    private int gcd(int a, int b) {
        while (b > 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}