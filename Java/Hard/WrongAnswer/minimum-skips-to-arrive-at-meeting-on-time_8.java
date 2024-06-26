class Solution {
    public int minSkips(int[] dist, int speed, int hoursBefore) {
        
        int n = dist.length;
        double[][] dp = new double[n+1][n+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Double.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i][j] = Math.ceil(dp[i-1][j] + (double)dist[i-1]/speed) + (dp[i-1][j] + (double)dist[i-1]/speed - Math.ceil(dp[i-1][j] + (double)dist[i-1]/speed));
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], Math.ceil(dp[i-1][j-1]) + (double)dist[i-1]/speed);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dp[n][i] <= hoursBefore) {
                return i;
            }
        }
        return -1;
    }
}