class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        
        int n = gas.size();
        int min = INT_MAX, minIndex = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
            if (sum < min) {
                min = sum;
                minIndex = i;
            }
        }
        return sum < 0 ? -1 : (minIndex + 1) % n;
    }
};