class Solution {
    public long gridGame(int[][] grid) {
        
        int n = grid[0].length;
        long[] sum = new long[n];
        long[] dp = new long[n];
        sum[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + grid[0][i];
        }
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + grid[1][i - 1];
        }
        long min = dp[n - 1];
        for (int i = 1; i < n; i++) {
            long temp = dp[i - 1] + sum[i - 1] - dp[i];
            min = Math.min(min, temp);
        }
        return min;
    }
}