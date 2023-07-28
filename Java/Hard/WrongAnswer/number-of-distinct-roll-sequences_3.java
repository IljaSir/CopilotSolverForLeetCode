class Solution {
    public int distinctSequences(int n) {
        
        int mod = 1000000007;
        int[][][] dp = new int[n + 1][7][7];
        for (int i = 1; i <= 6; ++i) {
            for (int j = 1; j <= 6; ++j) {
                dp[2][i][j] = 1;
            }
        }
        for (int k = 3; k <= n; ++k) {
            for (int i = 1; i <= 6; ++i) {
                for (int j = 1; j <= 6; ++j) {
                    for (int p = 1; p <= 6; ++p) {
                        if (i != j && Math.abs(i - j) != 1) {
                            dp[k][i][j] = (dp[k][i][j] + dp[k - 1][j][p]) % mod;
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int i = 1; i <= 6; ++i) {
            for (int j = 1; j <= 6; ++j) {
                res = (res + dp[n][i][j]) % mod;
            }
        }
        return res;
    }
}