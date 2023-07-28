class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        
        int n = tasks.length;
        int[] dp = new int[1 << n];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            int curTime = 0;
            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 1) == 1) {
                    curTime += tasks[i];
                }
            }
            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 1) == 0) {
                    int next = mask | (1 << i);
                    int cur = dp[mask];
                    if (curTime + tasks[i] <= sessionTime) {
                        dp[next] = Math.min(dp[next], cur);
                    } else {
                        dp[next] = Math.min(dp[next], cur + 1);
                    }
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}