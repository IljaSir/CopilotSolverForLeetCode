class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int start = 0;
        int n = gas.length;
        int i = 0;
        int total = 0;
        int sum = 0;
        while (i < n) {
            total += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if (sum < 0) {
                start = i + 1;
                sum = 0;
            }
            i++;
        }
        if (total < 0) {
            return -1;
        }
        return start;
    }
}