class Solution {
    public int checkRecord(int n) {
        
        int mod = 1000000007;
        int[][][] dp = new int[n+1][2][3];
        dp[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][0] = (dp[i][j][0] + dp[i-1][j][k]) % mod;
                    if (j > 0) {
                        dp[i][j][0] = (dp[i][j][0] + dp[i-1][j-1][k]) % mod;
                    }
                    if (k > 0) {
                        dp[i][j][k] = (dp[i][j][k] + dp[i-1][j][k-1]) % mod;
                    }
                }
            }
        }
        int ans = 0;
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 3; k++) {
                ans = (ans + dp[n][j][k]) % mod;
            }
        }
        return ans;
    }
}