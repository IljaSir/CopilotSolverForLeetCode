class Solution {
    public int maxTwoEvents(int[][] events) {
        
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        int n = events.length;
        int[] dp = new int[n];
        dp[0] = events[0][2];
        int res = dp[0];
        for (int i = 1; i < n; i++) {
            int val = events[i][2];
            int l = 0;
            int r = i - 1;
            while (l < r) {
                int m = l + (r - l + 1) / 2;
                if (events[m][1] < events[i][0]) {
                    l = m;
                } else {
                    r = m - 1;
                }
            }
            if (events[l][1] < events[i][0]) {
                val += dp[l];
            }
            dp[i] = Math.max(val, dp[i-1]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}