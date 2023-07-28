class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        
        int n = chargeTimes.length;
        int[] maxChargeTimes = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            maxChargeTimes[i] = Math.max(maxChargeTimes[i - 1], chargeTimes[i - 1]);
        }
        int[] minRunningCosts = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            minRunningCosts[i] = minRunningCosts[i - 1] + runningCosts[i - 1];
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int left = i, right = n;
            while (left < right) {
                int mid = (left + right + 1) / 2;
                long cost = (long) maxChargeTimes[i] + (long) minRunningCosts[mid] - (long) minRunningCosts[i - 1];
                if (cost <= budget) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            if ((long) maxChargeTimes[i] + (long) minRunningCosts[left] - (long) minRunningCosts[i - 1] <= budget) {
                ans = Math.max(ans, left - i + 1);
            }
        }
        return ans;
    }
}