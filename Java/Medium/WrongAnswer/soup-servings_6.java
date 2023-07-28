class Solution {
    public double soupServings(int n) {
        
        if (n > 4800) return 1;
        int N = (n + 24) / 25;
        double[][] dp = new double[N + 1][N + 1];
        dp[0][0] = 0.5;
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                int a = Math.min(i + 4, N);
                int b = Math.min(j + 3, N);
                dp[a][b] += dp[i][j] / 4;
                a = Math.min(i + 3, N);
                b = Math.min(j + 4, N);
                dp[a][b] += dp[i][j] / 4;
                a = Math.min(i + 2, N);
                b = Math.min(j + 2, N);
                dp[a][b] += dp[i][j] / 4;
                a = Math.min(i + 1, N);
                b = Math.min(j + 3, N);
                dp[a][b] += dp[i][j] / 4;
            }
        }
        return dp[N][N];
    }
}