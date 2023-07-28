class Solution {
    public int minSkips(int[] dist, int speed, int hoursBefore) {
        
        int n = dist.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; ++i) {
            int d = (dist[i - 1] + speed - 1) / speed;
            for (int j = 0; j <= i; ++j) {
                if (dp[i - 1][j] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j], (dp[i - 1][j] + d - 1) / d * d);
                }
                if (j > 0 && dp[i - 1][j - 1] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + d);
                }
            }
        }
        for (int i = 0; i <= n; ++i) {
            if (dp[n][i] <= hoursBefore * (long) speed) {
                return i;
            }
        }
        return -1;
    }
}