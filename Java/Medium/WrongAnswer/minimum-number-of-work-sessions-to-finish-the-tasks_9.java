class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        
        int[] dp = new int[1 << tasks.length];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        return dfs(tasks, sessionTime, 0, dp);
    }
    private int dfs(int[] tasks, int sessionTime, int mask, int[] dp) {
        if (dp[mask] != -1) {
            return dp[mask];
        }
        int left = sessionTime;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < tasks.length; i++) {
            if (((mask >> i) & 1) == 1) {
                continue;
            }
            if (tasks[i] <= left) {
                left -= tasks[i];
                res = Math.min(res, dfs(tasks, sessionTime, mask | (1 << i), dp));
                left += tasks[i];
            } else {
                res = Math.min(res, dfs(tasks, sessionTime, mask | (1 << i), dp) + 1);
            }
        }
        return dp[mask] = res;
    }
}