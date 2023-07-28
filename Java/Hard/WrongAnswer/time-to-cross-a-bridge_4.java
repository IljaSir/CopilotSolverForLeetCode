class Solution {
    public int findCrossingTime(int n, int k, int[][] time) {
        
        int[][] dp = new int[n + 1][k];
        for (int i = 0; i < k; i++) {
            dp[1][i] = time[i][0] + time[i][2];
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int l = 0; l < k; l++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][l] + time[j][0] + time[j][2] + time[j][3]);
                }
                dp[i][j] += time[j][1];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            res = Math.min(res, dp[n][i]);
        }
        return res;
    }
}