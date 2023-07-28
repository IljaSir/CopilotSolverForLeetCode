class Solution {
    public int maxTwoEvents(int[][] events) {
        
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;
        int[] dp = new int[n];
        dp[0] = events[0][2];
        int prev = 0;
        for (int i = 1; i < n; i++) {
            int[] cur = events[i];
            int[] prevEvent = events[prev];
            int val = cur[2];
            if (cur[0] != prevEvent[0]) {
                dp[i] = Math.max(dp[i - 1], val);
            } else {
                dp[i] = dp[i - 1];
            }
            if (cur[0] > prevEvent[1]) {
                dp[i] = Math.max(dp[i], dp[prev] + val);
            }
            if (cur[0] > prevEvent[0] && cur[1] < prevEvent[1]) {
                dp[i] = Math.max(dp[i], dp[prev] + val);
            }
            if (cur[1] < prevEvent[1]) {
                prev = i;
            }
        }
        return dp[n - 1];
    }
}