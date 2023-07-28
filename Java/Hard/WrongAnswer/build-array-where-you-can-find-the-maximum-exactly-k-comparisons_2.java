class Solution {
    public int numOfArrays(int n, int m, int k) {
        
        long[][][] dp = new long[n + 1][m + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i == 1) {
                    dp[i][j][1] = 1;
                } else {
                    for (int l = 1; l <= j; l++) {
                        for (int p = 1; p < i; p++) {
                            for (int q = 1; q < k; q++) {
                                dp[i][j][k] += dp[p][l][q];
                                dp[i][j][k] %= 1000000007;
                            }
                        }
                    }
                }
            }
        }
        long res = 0;
        for (int i = 1; i <= m; i++) {
            res += dp[n][i][k];
            res %= 1000000007;
        }
        return (int)res;
    }
}