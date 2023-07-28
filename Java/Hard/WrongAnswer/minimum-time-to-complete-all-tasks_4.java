class Solution {
    public int findMinimumTime(int[][] tasks) {
        
        int n = tasks.length;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < (1 << n); i++) {
            int time = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    time = Math.max(time, tasks[j][1]);
                }
            }
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) == 0) {
                    if (time >= tasks[j][0]) {
                        dp[i | (1 << j)] = Math.min(dp[i | (1 << j)], dp[i] + tasks[j][2]);
                    } else {
                        dp[i | (1 << j)] = Math.min(dp[i | (1 << j)], dp[i] + tasks[j][2] + tasks[j][0] - time);
                    }
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}