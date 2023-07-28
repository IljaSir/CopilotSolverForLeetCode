class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        
        int n = gas.size();
        int start = 0;
        int end = 0;
        int sum = 0;
        while (start < n) {
            sum += gas[end] - cost[end];
            end = (end + 1) % n;
            if (sum < 0) {
                start = end;
                sum = 0;
            } else if (start == end) {
                return start;
            }
        }
        return -1;
    }
};