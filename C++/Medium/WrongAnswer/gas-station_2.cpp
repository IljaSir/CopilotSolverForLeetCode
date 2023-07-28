class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        
        int start = 0;
        int total = 0;
        int tank = 0;
        for (int i = 0; i < gas.size(); i++) {
            int consume = gas[i] - cost[i];
            if (tank + consume < 0) {
                start = i + 1;
                total += tank;
                tank = 0;
            } else {
                tank += consume;
            }
        }
        return (total + tank < 0) ? -1 : start;
    }
};