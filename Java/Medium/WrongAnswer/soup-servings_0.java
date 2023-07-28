class Solution {
    public double soupServings(int n) {
        
        if (n > 4800) {
            return 1.0;
        }
        int N = (n + 24) / 25;
        double[][] dp = new double[N + 1][N + 1];
        dp[N][N] = 0.5;
        for (int i = N; i >= 0; i--) {
            for (int j = N; j >= 0; j--) {
                if (i == N && j == N) {
                    continue;
                }
                if (i == 0 && j == 0) {
                    continue;
                }
                dp[i][j] = 0.25 * (dp[Math.max(0, i - 4)][j] + dp[Math.max(0, i - 3)][Math.max(0, j - 1)] + dp[Math.max(0, i - 2)][Math.max(0, j - 2)] + dp[Math.max(0, i - 1)][Math.max(0, j - 3)]);
            }
        }
        return dp[0][0];
    }
}