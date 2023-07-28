class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        
        int n = chargeTimes.length;
        int[] chargeTimesSorted = new int[n];
        System.arraycopy(chargeTimes, 0, chargeTimesSorted, 0, n);
        Arrays.sort(chargeTimesSorted);
        int[] runningCostsSorted = new int[n];
        for (int i = 0; i < n; i++) {
            runningCostsSorted[i] = runningCosts[Arrays.binarySearch(chargeTimes, chargeTimesSorted[i])];
        }
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + runningCostsSorted[i - 1];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int lo = 1, hi = n - i;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (chargeTimesSorted[i] + prefixSum[i + mid] <= budget) {
                    ans = Math.max(ans, mid);
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return ans;
    }
}