class Solution {
    public long maxPower(int[] stations, int r, int k) {
        
        int n = stations.length;
        long[] dp = new long[n];
        for (int i = 0; i < n; i++) {
            int l = Math.max(0, i - r);
            int h = Math.min(n - 1, i + r);
            dp[i] = (long) (h - l + 1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stations[j] - stations[i] > 2 * r) {
                    break;
                }
                dp[j] = Math.max(dp[j], dp[i] + (long) (j - i + 1 + 2 * r));
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i] + (long) (k * (2 * r + 1)));
        }
        return ans;
    }
}