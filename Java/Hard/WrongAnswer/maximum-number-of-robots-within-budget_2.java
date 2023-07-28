class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        
        int n = chargeTimes.length;
        int maxCharge = 0;
        for (int i = 0; i < n; i++) {
            maxCharge = Math.max(maxCharge, chargeTimes[i]);
        }
        int l = 0, r = n;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            long cost = 0;
            for (int i = 0; i < mid; i++) {
                cost += runningCosts[i];
            }
            cost += (long) mid * maxCharge;
            if (cost <= budget) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        int ans = l;
        long cost = 0;
        for (int i = 0; i < ans; i++) {
            cost += runningCosts[i];
        }
        cost += (long) ans * maxCharge;
        for (int i = ans - 1; i >= 0; i--) {
            cost -= runningCosts[i];
            cost += chargeTimes[i];
            if (cost > budget) {
                break;
            }
            ans = i;
        }
        return n - ans;
    }
}