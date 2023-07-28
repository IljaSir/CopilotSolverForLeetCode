class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        
        int n = chargeTimes.length;
        long[][] dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = chargeTimes[i] + runningCosts[i];
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + runningCosts[j];
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int l = 0, r = n - i;
            while (l < r) {
                int m = l + r + 1 >> 1;
                if (dp[i][i + m - 1] <= budget) {
                    l = m;
                } else {
                    r = m - 1;
                }
            }
            ans = Math.max(ans, l);
        }
        return ans;
    }
}