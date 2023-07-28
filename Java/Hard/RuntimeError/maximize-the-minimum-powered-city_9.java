class Solution {
    public long maxPower(int[] stations, int r, int k) {
        
        int n = stations.length;
        long[] dp = new long[n];
        Arrays.fill(dp, Long.MAX_VALUE);
        for (int i = 0; i < k; i++) {
            long[] next = new long[n];
            Arrays.fill(next, Long.MAX_VALUE);
            for (int j = 0; j < n; j++) {
                int l = Math.max(0, j - r);
                int m = Math.min(n - 1, j + r);
                for (int a = l; a <= m; a++) {
                    next[a] = Math.min(next[a], dp[j] + Math.abs(stations[j] - stations[a]));
                }
            }
            dp = next;
        }
        long ans = Long.MAX_VALUE;
        for (long x : dp) {
            ans = Math.min(ans, x);
        }
        return ans;
    }
}