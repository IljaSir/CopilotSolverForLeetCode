class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        
        int n = gas.size();
        int start = 0;
        int end = 0;
        int tank = 0;
        while (start < n) {
            while (end < n) {
                tank += gas[end] - cost[end];
                if (tank < 0) {
                    break;
                }
                end++;
            }
            if (end == n) {
                return start;
            }
            start = end + 1;
            end = start;
            tank = 0;
        }
        return -1;
    }
};