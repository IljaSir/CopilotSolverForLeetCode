class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        
        int n = gas.size();
        vector<int> diff(n);
        for (int i = 0; i < n; i++) {
            diff[i] = gas[i] - cost[i];
        }
        int start = 0;
        int min = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += diff[i];
            if (sum < min) {
                min = sum;
                start = i + 1;
            }
        }
        return sum < 0 ? -1 : start;
    }
};