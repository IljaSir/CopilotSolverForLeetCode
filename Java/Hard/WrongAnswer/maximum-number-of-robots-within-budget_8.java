class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        
        int n = chargeTimes.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            long cost = 0;
            for (int j = i; j < n; j++) {
                cost += runningCosts[j];
                if (chargeTimes[j] > chargeTimes[i]) {
                    cost += chargeTimes[j] - chargeTimes[i];
                    count++;
                }
                if (cost > budget) {
                    break;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}