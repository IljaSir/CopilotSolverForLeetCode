class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int start = 0;
        int end = 0;
        int curGas = 0;
        while (start < gas.length) {
            curGas += gas[end];
            if (curGas < cost[end]) {
                start = end + 1;
                end = start;
                curGas = 0;
            } else {
                curGas -= cost[end];
                end = (end + 1) % gas.length;
                if (start == end) {
                    return start;
                }
            }
        }
        return -1;
    }
}