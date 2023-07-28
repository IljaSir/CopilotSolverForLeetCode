class Solution {
    public long maxPoints(int[][] points) {
        
        int m = points.length;
        int n = points[0].length;
        long[] dp = new long[n];
        for (int i = 0; i < m; i++) {
            long[] ndp = new long[n];
            long[] lmax = new long[n];
            long[] rmax = new long[n];
            lmax[0] = dp[0];
            for (int j = 1; j < n; j++) {
                lmax[j] = Math.max(lmax[j - 1] - 1, dp[j]);
            }
            rmax[n - 1] = dp[n - 1];
            for (int j = n - 2; j >= 0; j--) {
                rmax[j] = Math.max(rmax[j + 1] - 1, dp[j]);
            }
            for (int j = 0; j < n; j++) {
                ndp[j] = points[i][j] + Math.max(lmax[j], rmax[j]);
            }
            dp = ndp;
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}