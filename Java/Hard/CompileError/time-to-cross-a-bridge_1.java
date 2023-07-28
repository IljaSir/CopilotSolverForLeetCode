class Solution {
    public int findCrossingTime(int n, int k, int[][] time) {
        
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 1; i <= k; i++) {
            dp[1][i] = time[i - 1][0] + time[i - 1][1] + time[i - 1][2] + time[i - 1][3];
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                for (int l = 1; l <= k; l++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][l] + time[j - 1][0] + time[j - 1][1] + time[j - 1][2] + time[j - 1][3]);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) {
            ans = Math.min(ans, dp[n][i]);
        }
        return ans;
    }
}
    }
}