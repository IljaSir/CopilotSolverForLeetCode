class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        
        long mod = 1000000007;
        long[][][] dp = new long[high+1][zero+1][one+1];
        for (int i = 1; i <= zero; i++) {
            dp[1][i][0] = 1;
        }
        for (int i = 1; i <= one; i++) {
            dp[1][0][i] = 1;
        }
        for (int i = 2; i <= high; i++) {
            for (int j = 0; j <= zero; j++) {
                for (int k = 0; k <= one; k++) {
                    if (j > 0) {
                        dp[i][j][k] = (dp[i][j][k] + dp[i-1][j-1][k]) % mod;
                    }
                    if (k > 0) {
                        dp[i][j][k] = (dp[i][j][k] + dp[i-1][j][k-1]) % mod;
                    }
                    if (j > 0 && k > 0) {
                        dp[i][j][k] = (dp[i][j][k] + dp[i-1][j][k]) % mod;
                    }
                }
            }
        }
        long res = 0;
        for (int i = low; i <= high; i++) {
            for (int j = 0; j <= zero; j++) {
                for (int k = 0; k <= one; k++) {
                    res = (res + dp[i][j][k]) % mod;
                }
            }
        }
        return (int)res;
    }
}