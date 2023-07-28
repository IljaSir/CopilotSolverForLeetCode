class Solution {
    public int numOfArrays(int n, int m, int k) {
        
        int mod = 1000000007;
        int[][][] dp = new int[n + 1][m + 1][k + 1];
        for (int i = 1; i <= m; i++) {
            dp[1][i][1] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int l = 1; l <= k; l++) {
                    dp[i][j][l] = (int) ((dp[i][j - 1][l] + (long) dp[i - 1][j - 1][l - 1] * j) % mod);
                    dp[i][j][l] = (dp[i][j][l] + (int) ((long) dp[i - 1][j][l] * (j - 1) % mod)) % mod;
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            ans = (ans + dp[n][i][k]) % mod;
        }
        return ans;
    }
}