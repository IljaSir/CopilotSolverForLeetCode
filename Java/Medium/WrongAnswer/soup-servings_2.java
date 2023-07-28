class Solution {
    public double soupServings(int n) {
        
        if (n > 5000) {
            return 1.0;
        }
        int N = (n + 24) / 25;
        double[][] dp = new double[N + 1][N + 1];
        dp[0][0] = 0.5;
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                int s = i + j;
                if (s > 0) {
                    dp[i][j] += 0.25 * (i >= 4 ? dp[i - 4][j] : (j >= 4 ? dp[i][j - 4] : 0.5));
                    dp[i][j] += 0.25 * (i >= 3 && j >= 1 ? dp[i - 3][j - 1] : (j >= 3 && i >= 1 ? dp[i - 1][j - 3] : 0.5));
                    dp[i][j] += 0.25 * (i >= 2 && j >= 2 ? dp[i - 2][j - 2] : (j >= 2 && i >= 2 ? dp[i - 2][j - 2] : 0.5));
                    dp[i][j] += 0.25 * (i >= 1 && j >= 3 ? dp[i - 1][j - 3] : (j >= 1 && i >= 3 ? dp[i - 3][j - 1] : 0.5));
                }
            }
        }
        return dp[N][N];
    }
}