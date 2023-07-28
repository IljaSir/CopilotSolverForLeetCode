class Solution {
    public int maxTwoEvents(int[][] events) {
        
        int n = events.length;
        int[] dp = new int[n];
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        for (int i = 0; i < n; i++) {
            dp[i] = events[i][2];
            for (int j = i - 1; j >= 0; j--) {
                if (events[j][1] < events[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + events[i][2]);
                    break;
                }
            }
            if (i > 0) {
                dp[i] = Math.max(dp[i], dp[i - 1]);
            }
        }
        return dp[n - 1];
    }
}