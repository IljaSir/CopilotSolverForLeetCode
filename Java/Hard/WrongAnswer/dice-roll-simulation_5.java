class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        
        int M = 1000000007;
        int[][] dp = new int[n + 1][6];
        for (int i = 0; i < 6; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    if (j == k) {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= M;
                    } else {
                        if (rollMax[k] >= i - 1) {
                            dp[i][j] += dp[i - 1][k];
                            dp[i][j] %= M;
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 6; i++) {
            res += dp[n][i];
            res %= M;
        }
        return res;
    }
}