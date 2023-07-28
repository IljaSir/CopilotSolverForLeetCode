class Solution {
    public int minSkips(int[] dist, int speed, int hoursBefore) {
        
        int n = dist.length;
        double[][] dp = new double[n][n+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = Double.MAX_VALUE;
            }
        }
        dp[0][0] = (double)dist[0] / speed;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] == Double.MAX_VALUE) {
                    continue;
                }
                dp[i+1][j] = Math.min(dp[i+1][j], Math.ceil(dp[i][j]) + (double)dist[i+1] / speed);
                dp[i+1][j+1] = Math.min(dp[i+1][j+1], dp[i][j] + (double)dist[i+1] / speed);
            }
        }
        for (int i = 0; i < n; i++) {
            if (dp[n-1][i] <= hoursBefore) {
                return i;
            }
        }
        return -1;
    }
}