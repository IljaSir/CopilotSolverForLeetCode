class Solution {
    public long gridGame(int[][] grid) {
        
        long[][] dp = new long[2][grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            if (i == 0) {
                dp[0][i] = grid[0][i];
                dp[1][i] = grid[1][i];
            } else {
                dp[0][i] = grid[0][i] + dp[0][i - 1];
                dp[1][i] = grid[1][i] + dp[1][i - 1];
            }
        }
        long res = Long.MAX_VALUE;
        for (int i = 0; i < grid[0].length; i++) {
            long sum = 0;
            if (i == 0) {
                sum = dp[1][grid[0].length - 1];
            } else if (i == grid[0].length - 1) {
                sum = dp[0][grid[0].length - 2];
            } else {
                sum = Math.max(dp[0][i - 1], dp[1][grid[0].length - 1] - dp[1][i]);
            }
            res = Math.min(res, sum);
        }
        return res;
    }
}