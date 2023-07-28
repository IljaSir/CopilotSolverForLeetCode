class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        
        int n = chargeTimes.length;
        int[][] dp = new int[n + 1][n + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                long cost = chargeTimes[i - 1] + (long) runningCosts[i - 1] * j;
                if (cost <= budget) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return max;
    }
}