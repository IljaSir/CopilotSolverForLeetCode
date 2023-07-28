class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        
        int mod = 1000000007;
        int[][] dp = new int[n][6];
        for (int i = 0; i < 6; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    if (j != k) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][k]) % mod;
                    }
                }
            }
        }
        int result = 0;
        for (int i = 0; i < 6; i++) {
            result = (result + dp[n - 1][i]) % mod;
        }
        return result;
    }
}