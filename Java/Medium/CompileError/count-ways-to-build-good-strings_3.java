class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        
        int mod = 1000000007;
        int ( = high - low + 1;
        long[][][] dp = new long[n][zero + 1][one + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= zero; j++) {
                for (int k = 0; k <= one; k++) {
                    if (i == 0) {
                        if (j == 0 && k == 0) {
                            dp[i][j][k] = 1;
                        } else if (j == 0) {
                            dp[i][j][k] = k;
                        } else if (k == 0) {
                            dp[i][j][k] = j;
                        } else {
                            dp[i][j][k] = j + k;
                        }
                    } else {
                        if (j == 0 && k == 0) {
                            dp[i][j][k] = 0;
                        } else if (j == 0) {
                            dp[i][j][k] = dp[i - 1][j][k - 1];
                        } else if (k == 0) {
                            dp[i][j][k] = dp[i - 1][j - 1][k];
                        } else {
                            dp[i][j][k] = (dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1]) % mod;
                        }
                    }
                }
            }
        }
        long res = 0;
        for (int j = 0; j <= zero; j++) {
            for (int k = 0; k <= one; k++) {
                res = (res + dp[n - 1][j][k]) % mod;
            }
        }
        return (int) res;
    }
}