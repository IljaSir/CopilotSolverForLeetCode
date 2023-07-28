class Solution {
    public int findCrossingTime(int n, int k, int[][] time) {
        
        int[][] dp = new int[k][n + 1];
        int minTime = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < k; i++) {
            dp[i][1] = time[i][0] + time[i][1] + time[i][2] + time[i][3];
            for (int j = 2; j <= n; j++) {
                for (int l = 0; l < k; l++) {
                    if (dp[l][j - 1] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[l][j - 1] + time[i][0] + time[i][1] + time[i][2] + time[i][3]);
                    }
                }
            }
            minTime = Math.min(minTime, dp[i][n]);
        }
        return minTime;
    }
}