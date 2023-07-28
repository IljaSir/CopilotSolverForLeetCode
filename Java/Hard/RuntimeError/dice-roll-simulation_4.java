class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        
        int MOD = 1_000_000_007;
        int[][] dp = new int[n][6];
        for (int i = 0; i < 6; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            int[] s = new int[6];
            s[0] = dp[i - 1][0];
            for (int j = 1; j < 6; j++) {
                s[j] = (s[j - 1] + dp[i - 1][j]) % MOD;
            }
            for (int j = 0; j < 6; j++) {
                dp[i][j] = s[j];
                if (i >= rollMax[j]) {
                    dp[i][j] = (dp[i][j] - s[j - rollMax[j]] + MOD) % MOD;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 6; i++) {
            res = (res + dp[n - 1][i]) % MOD;
        }
        return res;
    }
}