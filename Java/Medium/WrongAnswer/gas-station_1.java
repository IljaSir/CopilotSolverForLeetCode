class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int n = gas.length;
        int[] diff = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = gas[i] - cost[i];
        }
        int start = 0;
        int end = 0;
        int sum = 0;
        while (start < n) {
            sum += diff[end];
            if (sum < 0) {
                start = end + 1;
                sum = 0;
            }
            end = (end + 1) % n;
            if (start == end) {
                return start;
            }
        }
        return -1;
    }
}