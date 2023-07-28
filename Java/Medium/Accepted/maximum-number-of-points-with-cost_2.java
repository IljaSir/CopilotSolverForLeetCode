class Solution {
    public long maxPoints(int[][] points) {
        
        int m = points.length;
        int n = points[0].length;
        long[] dp = new long[n];
        for (int i = 0; i < n; i++) {
            dp[i] = points[0][i];
        }
        for (int i = 1; i < m; i++) {
            long[] dp2 = new long[n];
            long max = Long.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dp[j] + j);
                dp2[j] = max - j;
            }
            max = Long.MIN_VALUE;
            for (int j = n - 1; j >= 0; j--) {
                max = Math.max(max, dp[j] - j);
                dp2[j] = Math.max(dp2[j], max + j);
            }
            for (int j = 0; j < n; j++) {
                dp2[j] += points[i][j];
            }
            dp = dp2;
        }
        long ans = 0;
        for (long x : dp) {
            ans = Math.max(ans, x);
        }
        return ans;
    }
}