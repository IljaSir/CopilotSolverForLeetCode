class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        
        int mod = 1000000007;
        long[][] dp = new long[n][6];
        for (int i = 0; i < 6; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    if (j != k) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][k]) % mod;
                    } else {
                        if (i >= rollMax[j]) {
                            dp[i][j] = (dp[i][j] + dp[i - rollMax[j]][k]) % mod;
                        }
                    }
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < 6; i++) {
            ans = (ans + dp[n - 1][i]) % mod;
        }
        return (int) ans;
    }
}