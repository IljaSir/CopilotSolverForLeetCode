class Solution {
    public int distinctSequences(int n) {
        
        if (n == 1) return 6;
        int mod = (int)1e9 + 7;
        long[][] dp = new long[n + 1][6];
        for (int i = 1; i <= 6; i++) dp[1][i - 1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    if (j == k) continue;
                    if (gcd(j + 1, k + 1) == 1) {
                        dp[i][k] = (dp[i][k] + dp[i - 1][j]) % mod;
                    }
                }
            }
        }
        long res = 0;
        for (int i = 0; i < 6; i++) res = (res + dp[n][i]) % mod;
        return (int)res;
    }
}