class Solution {
    public double new21Game(int n, int k, int maxPts) {
        
        if (k == 0 || n >= k + maxPts) return 1;
        double[] dp = new double[n + 1];
        dp[0] = 1;
        double W = Math.min(n - k + 1, maxPts);
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] / W;
            if (i < k) dp[i] += dp[i - 1];
            else dp[i] += dp[i - 1] - dp[i - maxPts - 1] / W;
        }
        return dp[n];
    }
}