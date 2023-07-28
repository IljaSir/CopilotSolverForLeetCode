class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        
        int[][][] dp = new int[n][6][16];
        int mod = 1000000007;
        for (int i = 0; i < 6; i++) {
            dp[0][i][1] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 1; k <= 15; k++) {
                    for (int l = 0; l < 6; l++) {
                        if (j == l) {
                            if (k < rollMax[j]) {
                                dp[i][j][k + 1] = (dp[i][j][k + 1] + dp[i - 1][j][k]) % mod;
                            }
                        } else {
                            dp[i][j][1] = (dp[i][j][1] + dp[i - 1][l][k]) % mod;
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 1; j <= 15; j++) {
                res = (res + dp[n - 1][i][j]) % mod;
            }
        }
        return res;
    }
}