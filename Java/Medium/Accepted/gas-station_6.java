class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int start = 0;
        int end = 0;
        int tank = 0;
        int n = gas.length;
        while (end < n) {
            tank += gas[end] - cost[end];
            if (tank < 0) {
                start = end + 1;
                end = start;
                tank = 0;
            } else {
                end++;
            }
        }
        if (start == n) {
            return -1;
        }
        for (int i = 0; i < start; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                return -1;
            }
        }
        return start;
    }
}