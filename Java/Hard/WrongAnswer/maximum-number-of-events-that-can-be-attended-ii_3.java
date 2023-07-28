class Solution {
    public int maxValue(int[][] events, int k) {
        
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        int n = events.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = events[i][2];
        }
        for (int i = 1; i < k; i++) {
            int[] dp2 = new int[n];
            int j = 0;
            for (int l = 0; l < n; l++) {
                while (j < n && events[j][0] <= events[l][1]) {
                    j++;
                }
                dp2[l] = Math.max(dp[l], dp[l] + (j < n ? dp[j] : 0));
            }
            dp = dp2;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}