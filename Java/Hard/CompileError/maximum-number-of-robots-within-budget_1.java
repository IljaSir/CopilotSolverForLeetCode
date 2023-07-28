class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        
        int n = chargeTimes.length;
        int[] order = new int[n];
        for (int i = 0; i < n; i++) {
            order[i] = i;
        }
        Arrays.sort(order, (a, b) -> chargeTimes[a] - chargeTimes[b]);
        int[] charge = new int[n];
        int[] run = new int[n];
        for (int i = 0; i < n; i++) {
            charge[i] = chargeTimes[order[i]];
            run[i] = runningCosts[order[i]];
        }
        int[] prefix = new int[n];
        for (int i = 0; i < n; i++) {
            prefix[i] = run[i];
            if (i > 0) {
                prefix[i] += prefix[i - 1];
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n) {
                long cost = charge[i] + (long) (j - i + 1) * prefix[j];
                if (cost <= budget) {
                    ans = Math.max(ans, j - i + 1);
                }
                j++;
            }
        }
        return ans;
    }
}