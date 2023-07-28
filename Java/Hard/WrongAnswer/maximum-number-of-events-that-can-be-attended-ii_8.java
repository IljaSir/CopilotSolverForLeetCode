class Solution {
    public int maxValue(int[][] events, int k) {
        
        int n = events.length;
        int m = 100000;
        int[][] dp = new int[m + 1][k + 1];
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        for (int i = 1; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= k; i++) {
            dp[0][i] = 0;
        }
        int j = 0;
        for (int i = 1; i <= m; i++) {
            while (j < n && events[j][1] < i) {
                j++;
            }
            for (int l = 1; l <= k; l++) {
                dp[i][l] = dp[i - 1][l];
                for (int r = j; r < n; r++) {
                    if (events[r][0] <= i) {
                        dp[i][l] = Math.max(dp[i][l], dp[events[r][0] - 1][l - 1] + events[r][2]);
                    }
                }
            }
        }
        return dp[m][k];
    }
}