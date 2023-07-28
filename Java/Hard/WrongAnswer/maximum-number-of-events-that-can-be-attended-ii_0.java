class Solution {
    public int maxValue(int[][] events, int k) {
        
        Arrays.sort(events, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int n = events.length;
        int[] dp = new int[n];
        dp[0] = events[0][2];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], events[i][2]);
        }
        for (int i = 1; i < k; i++) {
            int[] ndp = new int[n];
            int j = 0;
            for (int k1 = 0; k1 < n; k1++) {
                while (j < n && events[j][0] <= events[k1][1]) {
                    j++;
                }
                if (j < n) {
                    ndp[k1] = dp[k1] + events[j][2];
                }
                if (k1 > 0) {
                    ndp[k1] = Math.max(ndp[k1], ndp[k1 - 1]);
                }
            }
            dp = ndp;
        }
        return dp[n - 1];
    }
}