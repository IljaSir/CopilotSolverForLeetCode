class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        
        int n = gas.size();
        int sum = 0;
        int min_sum = 0;
        int min_idx = 0;
        for (int i = 0; i < n; ++i) {
            sum += gas[i] - cost[i];
            if (sum < min_sum) {
                min_sum = sum;
                min_idx = i;
            }
        }
        return sum < 0 ? -1 : (min_idx + 1) % n;
    }
};