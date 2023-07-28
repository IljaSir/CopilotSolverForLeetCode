class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int n = gas.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = gas[i] - cost[i];
        }
        int[] prefixSum = new int[n];
        prefixSum[0] = diff[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + diff[i];
        }
        if (prefixSum[n - 1] < 0) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < n; i++) {
            if (prefixSum[i] < min) {
                min = prefixSum[i];
                minIndex = i;
            }
        }
        return (minIndex + 1) % n;
    }
}