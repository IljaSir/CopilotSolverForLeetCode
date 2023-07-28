class Solution {
    public int numOfArrays(int n, int m, int k) {
        
        int MOD = 1000000007;
        int[][][] dp = new int[n + 1][m + 1][k + 1];
        for (int i = 1; i <= m; i++) {
            dp[1][i][1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int l = 1; l <= k; l++) {
                    for (int p = 1; p <= m; p++) {
                        if (p < j) {
                            dp[i][j][l] = (dp[i][j][l] + dp[i - 1][p][l - 1]) % MOD;
                        } else {
                            dp[i][j][l] = (dp[i][j][l] + dp[i - 1][p][l]) % MOD;
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            ans = (ans + dp[n][i][k]) % MOD;
        }
        return ans;
    }
}