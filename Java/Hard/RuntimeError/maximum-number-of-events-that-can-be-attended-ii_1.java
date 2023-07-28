class Solution {
    public int maxValue(int[][] events, int k) {
        
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        int n = events.length;
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            int[] event = events[i - 1];
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                int l = 0, r = i - 1;
                while (l < r) {
                    int mid = (l + r + 1) >> 1;
                    if (events[mid - 1][1] < event[0]) {
                        l = mid;
                    } else {
                        r = mid - 1;
                    }
                }
                if (events[r - 1][1] < event[0]) {
                    dp[i][j] = Math.max(dp[i][j], dp[r][j - 1] + event[2]);
                }
            }
        }
        return dp[n][k];
    }
}