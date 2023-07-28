class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        
        int n = tasks.length;
        int[][] dp = new int[1 << n][n + 1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(tasks, sessionTime, 0, 0, dp);
    }
    
    private int dfs(int[] tasks, int sessionTime, int mask, int cur, int[][] dp) {
        if (mask == (1 << tasks.length) - 1) {
            return 0;
        }
        if (dp[mask][cur] != -1) {
            return dp[mask][cur];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < tasks.length; i++) {
            if (((mask >> i) & 1) == 1) {
                continue;
            }
            if (cur + tasks[i] <= sessionTime) {
                res = Math.min(res, dfs(tasks, sessionTime, mask | (1 << i), cur + tasks[i], dp));
            } else {
                res = Math.min(res, dfs(tasks, sessionTime, mask | (1 << i), tasks[i], dp) + 1);
            }
        }
        return dp[mask][cur] = res;
    }
}