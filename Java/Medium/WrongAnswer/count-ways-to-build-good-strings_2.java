class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        
        int mod = 1000000007;
        int[][][] dp = new int[high + 1][zero + 1][one + 1];
        for (int i = low; i <= high; i++) {
            for (int j = 0; j <= zero; j++) {
                for (int k = 0; k <= one; k++) {
                    if (i == low) {
                        dp[i][j][k] = 1;
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                        if (j > 0) {
                            dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j - 1][k]) % mod;
                        }
                        if (k > 0) {
                            dp[i][j][k] = (dp[i][j][k] + dp[i - 1][j][k - 1]) % mod;
                        }
                        if (j > 0 && k > 0) {
                            dp[i][j][k] = (dp[i][j][k] - dp[i - 1][j - 1][k - 1] + mod) % mod;
                        }
                    }
                }
            }
        }
        return dp[high][zero][one];
    }
}