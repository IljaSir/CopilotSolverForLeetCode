class Solution {
    public int findMinimumTime(int[][] tasks) {
        
        int n = tasks.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = tasks[i][2];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j + i < n; j++) {
                dp[j][j+i] = Integer.MAX_VALUE;
                for (int k = j; k < j + i; k++) {
                    dp[j][j+i] = Math.min(dp[j][j+i], dp[j][k] + dp[k+1][j+i]);
                }
                int start = tasks[j][0];
                int end = tasks[j+i][1];
                int duration = end - start + 1;
                for (int k = j; k <= j + i; k++) {
                    if (tasks[k][0] <= start && tasks[k][1] >= end) {
                        duration -= tasks[k][2];
                    }
                }
                dp[j][j+i] = Math.min(dp[j][j+i], duration);
            }
        }
        return dp[0][n-1];
    }
}