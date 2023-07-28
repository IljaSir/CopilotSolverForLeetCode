class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        
        int n = gas.size();
        int ans = -1;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            int j = i;
            int cnt = 0;
            while (cnt < n) {
                sum += gas[j];
                sum -= cost[j];
                if (sum < 0) {
                    break;
                }
                j = (j + 1) % n;
                cnt++;
            }
            if (cnt == n) {
                ans = i;
                break;
            }
        }
        return ans;
    }
};