class Solution {
    public int numOfWays(int n) {
        
        int mod = 1000000007;
        long[][][] dp = new long[n][3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    dp[0][i][j] = 1;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (j != k) {
                        for (int l = 0; l < 3; l++) {
                            if (k != l) {
                                dp[i][j][k] += dp[i - 1][j][l];
                            }
                        }
                        dp[i][j][k] %= mod;
                    }
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    ans += dp[n - 1][i][j];
                }
            }
        }
        return (int)(ans % mod);
    }
}