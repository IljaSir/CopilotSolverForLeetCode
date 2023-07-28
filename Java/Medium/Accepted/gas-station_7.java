class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int n = gas.length;
        int start = 0;
        int end = 0;
        int tank = 0;
        int total = 0;
        while (end < n) {
            tank += gas[end] - cost[end];
            total += gas[end] - cost[end];
            if (tank < 0) {
                start = end + 1;
                tank = 0;
            }
            end++;
        }
        return total < 0 ? -1 : start;
    }
}