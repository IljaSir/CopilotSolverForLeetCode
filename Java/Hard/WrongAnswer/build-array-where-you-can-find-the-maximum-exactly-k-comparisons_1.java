class Solution {
    public int numOfArrays(int n, int m, int k) {
        
        int mod = 1000000007;
        long[][][] dp = new long[n + 1][m + 1][k + 1];
        for (int i = 1; i <= m; i++) {
            dp[1][i][1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int l = 1; l <= k; l++) {
                    for (int p = 1; p <= j; p++) {
                        if (p < j) {
                            dp[i][j][l] += dp[i - 1][p][l];
                        } else {
                            dp[i][j][l] += dp[i - 1][p][l - 1];
                        }
                        dp[i][j][l] %= mod;
                    }
                }
            }
        }
        long res = 0;
        for (int i = 1; i <= m; i++) {
            res += dp[n][i][k];
            res %= mod;
        }
        return (int)res;
    }
}