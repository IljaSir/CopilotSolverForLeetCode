class Solution {
    public int distinctSequences(int n) {
        
        final int MOD = 1000000007;
        int[][][] dp = new int[n + 1][7][7];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (i == 1) {
                        dp[i][j][k] = 1;
                    } else {
                        for (int l = 1; l <= 6; l++) {
                            if (l != k && Math.abs(l - j) > 1) {
                                dp[i][j][k] = (dp[i][j][k] + dp[i - 1][l][j]) % MOD;
                            }
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                ans = (ans + dp[n][i][j]) % MOD;
            }
        }
        return ans;
    }
}