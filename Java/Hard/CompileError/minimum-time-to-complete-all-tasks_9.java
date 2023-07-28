class Solution {
    public int findMinimumTime(int[][] tasks) {
        
        int n = tasks.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            dp[i][i] = tasks[i][2];
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                }
                dp[i][j] = Math.min(dp[i][j], tasks[i][2] + tasks[j][2] + Math.max(tasks[j][1] - tasks[k][0], 0));
            }
        }
        return dp[0][n - 1];
    }
}