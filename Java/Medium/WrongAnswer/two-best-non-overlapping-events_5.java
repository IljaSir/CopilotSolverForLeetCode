class Solution {
    public int maxTwoEvents(int[][] events) {
        
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;
        int[] dp = new int[n];
        dp[0] = events[0][2];
        for (int i = 1; i < n; i++) {
            int value = events[i][2];
            int j = i - 1;
            while (j >= 0 && events[j][1] >= events[i][0]) {
                j--;
            }
            if (j >= 0) {
                value += dp[j];
            }
            dp[i] = Math.max(dp[i - 1], value);
        }
        return dp[n - 1];
    }
}