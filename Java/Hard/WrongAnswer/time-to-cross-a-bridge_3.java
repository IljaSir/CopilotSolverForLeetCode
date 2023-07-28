class Solution {
    public int findCrossingTime(int n, int k, int[][] time) {
        
        int[][] dp = new int[n + 1][k];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                for (int l = 0; l < k; l++) {
                    if (dp[i][j] != Integer.MAX_VALUE) {
                        dp[i + 1][l] = Math.min(dp[i + 1][l], dp[i][j] + time[j][0] + time[j][1] + time[l][2] + time[l][3]);
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            ans = Math.min(ans, dp[n][i]);
        }
        return ans;
    }
}