class Solution {
    public double soupServings(int n) {
        
        if (n > 4800) {
            return 1.0;
        }
        int N = (n + 24) / 25;
        double[][] dp = new double[N+1][N+1];
        return helper(dp, N, N);
    }

    public double helper(double[][] dp, int a, int b) {
        if (a <= 0 && b <= 0) {
            return 0.5;
        }
        if (a <= 0) {
            return 1.0;
        }
        if (b <= 0) {
            return 0.0;
        }
        if (dp[a][b] > 0) {
            return dp[a][b];
        }
        dp[a][b] = 0.25 * (helper(dp, a-4, b) + helper(dp, a-3, b-1) + helper(dp, a-2, b-2) + helper(dp, a-1, b-3));
        return dp[a][b];
    }
}