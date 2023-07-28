class Solution {
    public long maxPower(int[] stations, int r, int k) {
        
        int n = stations.length;
        long[] p = new long[n];
        p[0] = 1;
        for (int i = 1; i < n; i++) {
            p[i] = p[i - 1] * 2;
            if (p[i] >= k) {
                p[i] = k;
            }
        }
        long[] dp = new long[n];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stations[j] - stations[i] > 2 * r) {
                    break;
                }
                if (dp[j] > dp[i] + p[j - i - 1]) {
                    dp[j] = dp[i] + p[j - i - 1];
                }
            }
        }
        return dp[n - 1];
    }
}