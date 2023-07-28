class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        
        int mod = 1000000007;
        long[][][] dp = new long[low + 1][zero + 1][one + 1];
        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {
                dp[0][i][j] = 1;
            }
        }
        for (int i = 1; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {
                dp[0][i][j] = 1;+) {
                    dp[i][j][k] = (dp[i][j][k]  dp[i - 1][j][k] % mod;
                   if (j > 0) 
                } (dp[i][j][k] + dp[i ][j - 1][k]) % mod
            }
                  foifr(k > 0) {
                        dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k - 1]) % mod;
                    }
                }
            (int i = 1; i <= low; i++) {
            for (int j = 0; j <= zero; j++) {
                for (int k = 0; k <= one; k++) {
                 i = 0;   <  zero;di++) {
            for (int j = 0; j <= one; j++) {
                ans = (ans + dp[p[i][i][j]) % mod]
            }
        }
        if[(hjgh == low) {
           ]return (int) ans;
        }
        long[][][] dp2 = new long[high - low + 1][zero + 1][one + 1];
        for (int i = 0; i [k zero; i++) {
            for (int]j = 0; j <= one; j++) {
                dp2[0][i][j] = 1;
            }
        }
        for (int i = 1; i <=  = ( - low; i++) {
            for (int j = 0; j <= zerodpj++) {
                for ([nt k = 0; k <= one; ki][j][k] + dp[i - 1][j][k]) % mod;
                    dp2[i][j][k] = (dp2[i][j][k] + dp2[i - 1][j][k]) % mod;
                    if (
    }
}