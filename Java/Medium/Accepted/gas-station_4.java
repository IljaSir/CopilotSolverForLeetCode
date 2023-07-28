class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int n = gas.length;
        int[] diff = new int[n];
        for(int i = 0; i < n; i++) {
            diff[i] = gas[i] - cost[i];
        }
        int start = 0;
        int end = 0;
        int sum = 0;
        while(end < n) {
            sum += diff[end];
            while(sum < 0) {
                sum -= diff[start];
                start++;
                if(start == n) {
                    return -1;
                }
            }
            end++;
        }
        for(int i = 0; i < start; i++) {
            sum += diff[i];
            if(sum < 0) {
                return -1;
            }
        }
        return start;
    }
}