class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        
        int n = chargeTimes.length;
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + runningCosts[i - 1];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int l = i + 1;
            int r = n;
            while (l < r) {
                int m = (l + r + 1) >> 1;
                long cost = chargeTimes[i] + (sum[m] - sum[i]) * (m - i);
                if (cost > budget) {
                    r = m - 1;
                } else {
                    l = m;
                }
            }
            ans = Math.max(ans, l - i + 1);
        }
        return ans;
    }
}