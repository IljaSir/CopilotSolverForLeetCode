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
        long     = 0;
        for (int i = low; i <= high; i +) {
            ans +   if (j > 0) {
                        dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j - 1][k]) % mod;
                    }
                    if (k > 0) {
                        dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k - 1]) % mod;
                    }
                }
            }
        }
        long ans = 0;
        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {
                ans = (ans + dp[low][i][j]) % mod;
            }
        }
        if (high == low) {
            return (int) ans;
        }
        long[][][] dp2 = new long[high - low + 1][zero + 1][one + 1];
        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {
                dp2[0][i][j] = 1;
            }
        }
        for (int i = 1; i <= high - low; i++) {
            for ns;
    }
}