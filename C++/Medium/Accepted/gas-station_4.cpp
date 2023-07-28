class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        
        int n = gas.size();
        int sum_gas = 0, sum_cost = 0;
        int start = 0, tank = 0;
        for (int i = 0; i < n; ++i) {
            sum_gas += gas[i];
            sum_cost += cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return sum_gas < sum_cost ? -1 : start;
    }
};