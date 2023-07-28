class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        
        int n = chargeTimes.length;
        long[] dp = new long[n+1];
        int res = 0;
        for (int i = 1; i <= n; i++) {
            long cost = chargeTimes[i-1] + runningCosts[i-1];
            if (cost <= budget) {
                res = Math.max(res, 1);
                dp[i] = cost;
            }
            for (int j = i-1; j >= 1; j--) {
                cost += runningCosts[j-1];
                if (cost > budget) break;
                if (dp[j] + chargeTimes[i-1] <= budget) {
                    dp[i] = Math.max(dp[i], dp[j] + chargeTimes[i-1]);
                    res = Math.max(res, i-j+1);
                }
            }
        }
        return res;
    }
}