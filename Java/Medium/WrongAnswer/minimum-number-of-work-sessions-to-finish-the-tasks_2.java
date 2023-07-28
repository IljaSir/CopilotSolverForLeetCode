class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        
        int n = tasks.length;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            if (dp[mask] == Integer.MAX_VALUE) {
                continue;
            }
            int curTime = 0;
            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 1) == 0) {
                    curTime += tasks[i];
                    if (curTime > sessionTime) {
                        break;
                    }
                    dp[mask | (1 << i)] = Math.min(dp[mask | (1 << i)], dp[mask] + 1);
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}