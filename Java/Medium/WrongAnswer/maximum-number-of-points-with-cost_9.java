class Solution {
    public long maxPoints(int[][] points) {
        
        int m = points.length, n = points[0].length;
        long[] dp = new long[n];
        for (int i = 0; i < m; i++) {
            long[] next = new long[n];
            long max = 0;
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dp[j] + j);
                next[j] = max - j + points[i][j];
            }
            max = 0;
            for (int j = n - 1; j >= 0; j--) {
                max = Math.max(max, dp[j] - j);
                next[j] = Math.max(next[j], max + j + points[i][j]);
            }
            dp = next;
        }
        long ans = 0;
        for (long x : dp) ans = Math.max(ans, x);
        return ans;
    }
}