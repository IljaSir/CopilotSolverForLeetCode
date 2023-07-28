class Solution {
    public int minSkips(int[] dist, int speed, int hoursBefore) {
        
        int n = dist.length;
        double[][] dp = new double[n][n+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = Double.MAX_VALUE;
            }
        }
        dp[0][0] = (double) dist[0] / speed;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i-1][0] + (double) dist[i] / speed;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.min(dp[i-1][j] + (double) dist[i] / speed, Math.ceil(dp[i-1][j-1]) + (double) dist[i] / speed);
            }
        }
        for (int j = 0; j <= n; j++) {
            if (dp[n-1][j] <= hoursBefore) {
                return j;
            }
        }
        return -1;
    }
}