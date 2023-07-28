class Solution {
    public int numOfArrays(int n, int m, int k) {
        
        if (k > n || k > m) {
            return 0;
        }
        if (k == 1) {
            return (int) Math.pow(m, n);
        }
        long[][][] dp = new long[n + 1][m + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int l = 1; l <= k; l++) {
                    if (l == 1) {
                        dp[i][j][l] = j;
                    } else {
                        for (int p = 1; p <= j; p++) {
                            dp[i][j][l] += (dp[i - 1][p][l - 1] * j) % 1000000007;
                            dp[i][j][l] %= 1000000007;
                        }
                    }
                }
            }
        }
        long sum = 0;
        for (int i = 1; i <= m; i++) {
            sum += dp[n][i][k];
            sum %= 1000000007;
        }
        return (int) sum;
    }
}