class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        
        int n = tasks.length;
        int[] dp = new int[1<<n];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int mask = 0; mask < (1<<n); mask++) {
            int time = 0;
            for (int i = 0; i < n; i++) {
                if (((mask>>i)&1) == 1) {
                    time += tasks[i];
                }
            }
            time %= sessionTime;
            for (int i = 0; i < n; i++) {
                if (((mask>>i)&1) == 0) {
                    dp[mask|(1<<i)] = Math.min(dp[mask|(1<<i)], dp[mask] + (time + tasks[i] - 1) / sessionTime);
                }
            }
        }
        return dp[(1<<n)-1];
    }
}