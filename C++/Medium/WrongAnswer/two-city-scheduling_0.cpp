class Solution {
public:
    int twoCitySchedCost(vector<vector<int>>& costs) {
        
        int n = costs.size();
        vector<int> diff(n);
        for (int i = 0; i < n; i++) {
            diff[i] = costs[i][0] - costs[i][1];
        }
        sort(diff.begin(), diff.end());
        int sum = 0;
        for (int i = 0; i < n / 2; i++) {
            sum += costs[i][0] + costs[i + n / 2][1];
        }
        for (int i = 0; i < n / 2; i++) {
            sum += diff[i];
        }
        return sum;
    }
};