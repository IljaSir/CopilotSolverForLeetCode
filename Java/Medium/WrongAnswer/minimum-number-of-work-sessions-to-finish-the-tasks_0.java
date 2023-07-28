class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        
        int n = tasks.length;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int mask = 0; mask < (1 << n); ++mask) {
            int time = 0;
            for (int i = 0; i < n; ++i) {
                if (((mask >> i) & 1) != 0) {
                    time += tasks[i];
                }
            }
            time %= sessionTime;
            for (int i = 0; i < n; ++i) {
                if (((mask >> i) & 1) == 0) {
                    int next = mask | (1 << i);
                    if (time + tasks[i] <= sessionTime) {
                        dp[next] = Math.min(dp[next], dp[mask]);
                    } else {
                        dp[next] = Math.min(dp[next], dp[mask] + 1);
                    }
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}