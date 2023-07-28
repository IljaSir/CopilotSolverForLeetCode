class Solution {
    public long maxPoints(int[][] points) {
        
        int m = points.length;
        int n = points[0].length;
        long[] dp = new long[n];
        for (int i = 0; i < n; i++) {
            dp[i] = points[0][i];
        }
        for (int i = 1; i < m; i++) {
            long[] ndp = new long[n];
            long max = Long.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dp[j] + j);
                ndp[j] = Math.max(ndp[j], max - j + points[i][j]);
            }
            max = Long.MIN_VALUE;
            for (int j = n - 1; j >= 0; j--) {
                max = Math.max(max, dp[j] - j);
                ndp[j] = Math.max(ndp[j], max + j + points[i][j]);
            }
            dp = ndp;
        }
        long ans = 0;
        for (long x : dp) {
            ans = Math.max(ans, x);
        }
        return ans;
    }
}