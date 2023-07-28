class Solution {
public:
    int twoCitySchedCost(vector<vector<int>>& costs) {
        
        auto cost = 0;
        auto n = costs.size();
        vector<int> diff(n);
        for (auto i = 0; i < n; i++) {
            cost += costs[i][0];
            diff[i] = costs[i][1] - costs[i][0];
        }
        sort(diff.begin(), diff.end());
        for (auto i = 0; i < n / 2; i++) {
            cost += diff[i];
        }
        return cost;
    }
};