class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        
        int n = tasks.length;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            if (dp[mask] == -1) {
                continue;
            }
            int time = 0;
            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 1) == 0) {
                    time += tasks[i];
                    if (time <= sessionTime) {
                        dp[mask | (1 << i)] = dp[mask];
                    } else {
                        time = tasks[i];
                        dp[mask | (1 << i)] = dp[mask] + 1;
                    }
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}