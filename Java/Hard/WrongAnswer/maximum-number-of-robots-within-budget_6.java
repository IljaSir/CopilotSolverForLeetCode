class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        
        int n = chargeTimes.length;
        int[] maxCharge = new int[n];
        int[] sumRunning = new int[n];
        maxCharge[0] = chargeTimes[0];
        sumRunning[0] = runningCosts[0];
        for (int i = 1; i < n; i++) {
            maxCharge[i] = Math.max(maxCharge[i - 1], chargeTimes[i]);
            sumRunning[i] = sumRunning[i - 1] + runningCosts[i];
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            long cost = (long)maxCharge[i] + (long)sumRunning[i];
            if (cost > budget) {
                break;
            }
            int left = 0;
            int right = i;
            while (left < right) {
                int mid = (left + right + 1) / 2;
                cost = (long)maxCharge[i] + (long)sumRunning[i] - (long)sumRunning[mid] + (long)sumRunning[mid - 1] + (long)maxCharge[mid - 1];
                if (cost <= budget) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}