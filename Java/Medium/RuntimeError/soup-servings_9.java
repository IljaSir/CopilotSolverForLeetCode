class Solution {
    public double soupServings(int n) {
        
        if (n > 4800) {
            return 1.0;
        }
        double[][] dp = new double[25][25];
        return helper(n, n, dp);
    }
    
    private double helper(int a, int b, double[][] dp) {
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
        dp[a][b] = 0.25 * (helper(a - 100, b, dp) + helper(a - 75, b - 25, dp) + helper(a - 50, b - 50, dp) + helper(a - 25, b - 75, dp));
        return dp[a][b];
    }
}