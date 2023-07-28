class Solution {
    public int numOfArrays(int n, int m, int k) {
        
        int mod = 1000000007;
        int[][][] dp = new int[n][m + 1][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int l = 1; l <= k; l++) {
                    if (i == 0) {
                        if (l == 1) {
                            dp[i][j][l] = 1;
                        }
                    } else {
                        for (int p = 1; p <= m; p++) {
                            if (p < j) {
                                dp[i][j][l] += dp[i - 1][p][l];
                            } else if (p == j) {
                                dp[i][j][l] += dp[i - 1][p][l];
                            } else {
                                dp[i][j][l] += dp[i - 1][p][l - 1];
                            }
                            dp[i][j][l] %= mod;
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            ans += dp[n - 1][i][k];
            ans %= mod;
        }
        return ans;
    }
}