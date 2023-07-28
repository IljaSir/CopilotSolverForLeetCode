class Solution {
    public int findCrossingTime(int n, int k, int[][] time) {
        
        int[][] dp = new int[k][n + 1];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j <= n; j++) {
                if (dp[i][j] == Integer.MAX_VALUE) {
                    continue;
                }
                int leftToRight = time[i][0];
                int pickOld = time[i][1];
                int rightToLeft = time[i][2];
                int putNew = time[i][3];
                if (j < n) {
                    dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + leftToRight + pickOld + rightToLeft);
                }
                if (i < k - 1) {
                    dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + leftToRight + rightToLeft);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            res = Math.min(res, dp[i][n] + time[i][3]);
        }
        return res;
    }
}