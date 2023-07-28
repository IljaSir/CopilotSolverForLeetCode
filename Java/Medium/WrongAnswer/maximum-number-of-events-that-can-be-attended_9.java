class Solution {
    public int maxEvents(int[][] events) {
        
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int n = events.length;
        int[] dp = new int[n + 1];
        int res = 0;
        for (int i = 0; i < n; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
            int[] e = events[i];
            int start = e[0];
            int end = e[1];
            if (start <= dp[i + 1] + 1) {
                res++;
                dp[i + 1] = Math.max(dp[i + 1], end);
            }
        }
        return res;
    }
}