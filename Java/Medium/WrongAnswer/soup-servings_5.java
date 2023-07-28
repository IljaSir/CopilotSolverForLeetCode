class Solution {
    public double soupServings(int n) {
        
        if (n > 4800) return 1;
        int N = (n + 24) / 25;
        double[][] dp = new double[N + 1][N + 1];
        dp[0][0] = 0.5;
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) {
                int a = Math.max(i - 4, 0);
                int b = Math.max(j - 8, 0);
                dp[i][j] += 0.25 * dp[a][b];
                a = Math.max(i - 3, 0);
                b = Math.max(j - 6, 0);
                dp[i][j] += 0.25 * dp[a][b];
                a = Math.max(i - 2, 0);
                b = Math.max(j - 6, 0);
                dp[i][j] += 0.25 * dp[a][b];
                a = Math.max(i - 1, 0);
                b = Math.max(j - 4, 0);
                dp[i][j] += 0.25 * dp[a][b];
            }
        }
        return dp[N][N];
    }
}